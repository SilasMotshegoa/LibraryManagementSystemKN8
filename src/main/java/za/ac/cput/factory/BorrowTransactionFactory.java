package za.ac.cput.factory;

import za.ac.cput.domain.BorrowTransaction;
import za.ac.cput.util.BorrowTransactionHelper;

import java.time.LocalDate;

public class BorrowTransactionFactory {

    public static BorrowTransaction createBorrowTransaction(int transactionIdentity, int bookIdentity, int userIdentity,
                                                            LocalDate borrowDate, LocalDate returnDate) {
        if (transactionIdentity <= 0 || bookIdentity <= 0 || userIdentity <= 0 || borrowDate == null) {
            return null;
        }

        LocalDate dueDate = borrowDate.plusDays(7);
        String status = BorrowTransactionHelper.determineStatus(returnDate, dueDate);
        double amountFine = BorrowTransactionHelper.calculateFine(returnDate, dueDate);

        return new BorrowTransaction.Builder()
                .setTransactionIdentity(transactionIdentity)
                .setBookIdentity(bookIdentity)
                .setUserIdentity(userIdentity)
                .setBorrowDate(borrowDate)
                .setDueDate(dueDate)
                .setReturnDate(returnDate)
                .setAmountFine(amountFine)
                .setStatus(status)
                .build();
    }
}
