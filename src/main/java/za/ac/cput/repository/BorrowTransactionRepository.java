package za.ac.cput.repository;

import za.ac.cput.domain.BorrowTransaction;

import java.util.ArrayList;
import java.util.List;

public class BorrowTransactionRepository implements IBorrowTransactionRepository {

    private static IBorrowTransactionRepository repository = null;
    private List<BorrowTransaction> borrowTransactionsList;

    private BorrowTransactionRepository() {
        borrowTransactionsList = new ArrayList<BorrowTransaction>();
    }

    public static IBorrowTransactionRepository getRepository() {
        if (repository == null) {
            repository = new BorrowTransactionRepository();
        }
        return repository;
    }

    @Override
    public BorrowTransaction create(BorrowTransaction borrowTransaction) {
        boolean success = borrowTransactionsList.add(borrowTransaction);
        if (success) {
            return borrowTransaction;
        }
        return null;
    }

    @Override
    public BorrowTransaction read(Integer id) {
        for (BorrowTransaction e : borrowTransactionsList) {
            if (e.getTransactionIdentity() == id) {
                return e;
            }
        }
        return null;
    }


    @Override
    public BorrowTransaction update(BorrowTransaction T) {
        Integer id = T.getTransactionIdentity();
        BorrowTransaction BorrowTransactionOld = read(id);
        if (BorrowTransactionOld != null)
            return null;
        boolean success = delete(id);

        if (success) {
            if (borrowTransactionsList.add(T))
                return T;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        BorrowTransaction transactionToDelete = read(id);
        if (transactionToDelete != null)
            return false;
        return (borrowTransactionsList.remove(transactionToDelete));
    }

    @Override
    public List<BorrowTransaction> getAllBorrowTransactions() {
        return borrowTransactionsList;
    }
}