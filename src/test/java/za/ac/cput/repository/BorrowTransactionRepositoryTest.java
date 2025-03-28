package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BorrowTransaction;
import za.ac.cput.factory.BorrowTransactionFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BorrowTransactionRepositoryTest {

    LocalDate borrowDate = LocalDate.of(2020, 3, 28);
    LocalDate returnDate = LocalDate.of(2020, 4, 01);


    private static IBorrowTransactionRepository repository = BorrowTransactionRepository.getRepository();
    private BorrowTransaction borrowTransaction = BorrowTransactionFactory.createBorrowTransaction(22053523,1579852,222634596,borrowDate, returnDate);


    @Test
    void a_create() {
        BorrowTransaction created = repository.create(borrowTransaction);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read() {
        BorrowTransaction read = repository.read(borrowTransaction.getTransactionIdentity());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        BorrowTransaction newTransaction = new BorrowTransaction.Builder().copy(borrowTransaction).setTransactionIdentity(2525684)
    .build();
    BorrowTransaction updated = repository.update(newTransaction);
        System.out.println(updated.toString());
    }

    @Test
    void _delete() {
        assertTrue(repository.delete(borrowTransaction.getTransactionIdentity()));
        System.out.println("deleted");
    }

    @Test
    void getAllBorrowTransactions() {
        System.out.println(repository.getAllBorrowTransactions());
    }
}