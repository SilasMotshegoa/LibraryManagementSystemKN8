package za.ac.cput.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowTransactionHelper {

    private static final double FINE_PER_DAY = 2.0;

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    // Determines the status based on the return date
    public static String determineStatus(LocalDate returnDate, LocalDate dueDate) {
        if (returnDate == null) {
            return "Borrowed";
        } else if (returnDate.isAfter(dueDate)) {
            return "Overdue";
        } else {
            return "Returned";
        }
    }

    // Calculates the fine if the book is overdue
    public static double calculateFine(LocalDate returnDate, LocalDate dueDate) {
        if (returnDate == null || returnDate.isBefore(dueDate) || returnDate.isEqual(dueDate)) {
            return 0.0;
        }
        long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        return overdueDays * FINE_PER_DAY;
    }
}
