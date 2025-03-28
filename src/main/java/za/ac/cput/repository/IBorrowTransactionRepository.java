package za.ac.cput.repository;

import za.ac.cput.domain.BorrowTransaction;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IBorrowTransactionRepository extends IRepository<BorrowTransaction, Integer> {
    List<BorrowTransaction> getAllBorrowTransactions();
}

