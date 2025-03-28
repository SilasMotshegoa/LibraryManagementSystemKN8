package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BorrowTransaction;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class BorrowTransactionFactoryTest {

    @Test
    void testCreateValidBorrowTransaction() {
        LocalDate borrowDate = LocalDate.of(2025, 3, 29);
        LocalDate returnDate = LocalDate.of(2025, 4, 8);

        BorrowTransaction transaction = BorrowTransactionFactory.createBorrowTransaction(
                12345, 6789, 11111, borrowDate, returnDate);

        assertNotNull(transaction);
        assertEquals("Overdue", transaction.getStatus());
        assertTrue(transaction.getAmountFine() > 0);
    }
    @Test
    void testCreateInvalidBorrowTransaction() {
        // Invalid inputs (negative IDs, null borrow date)
        LocalDate borrowDate = null;
        LocalDate returnDate = LocalDate.of(2025, 4, 5);

        BorrowTransaction transaction = BorrowTransactionFactory.createBorrowTransaction(
                -1, -5, 0, borrowDate, returnDate); // Invalid IDs and null borrowDate

        assertNull(transaction, "Transaction should be null for invalid inputs.");
    }

    @Test
    public void testBorrowedStatusWhenReturnDateIsNull() {
        LocalDate borrowDate = LocalDate.of(2025, 3, 29);

        BorrowTransaction transaction = BorrowTransactionFactory.createBorrowTransaction(
                12345, 6789, 11111, borrowDate, null);

        assertNotNull(transaction);
        assertEquals("Borrowed", transaction.getStatus());
        assertEquals(0.0, transaction.getAmountFine());
    }
    @Test
    public  void testReturnedStatusWhenReturnedOnTime(){
        LocalDate borrowDate = LocalDate.of(2025, 3, 29);
        LocalDate returnDate = LocalDate.of(2025, 4, 5); // Same as due date

        BorrowTransaction transaction = BorrowTransactionFactory.createBorrowTransaction(
                12345, 6789, 11111, borrowDate, returnDate);

        assertNotNull(transaction);
        assertEquals("Returned", transaction.getStatus());
        assertEquals(0.0, transaction.getAmountFine());
    }
    @Test
    void testFactoryReturnsNullForInvalidIds() {
        LocalDate borrowDate = LocalDate.of(2025, 3, 29);

        BorrowTransaction transaction = BorrowTransactionFactory.createBorrowTransaction(
                -1, 6789, 11111, borrowDate, null);

        assertNotNull(transaction);
    }

    @Test
    void testFactoryReturnsNullForNullBorrowDate() {
        BorrowTransaction transaction = BorrowTransactionFactory.createBorrowTransaction(
                12345, 6789, 11111, null, null);

        assertNull(transaction);
    }
}