package za.ac.cput.factory;

import za.ac.cput.domain.BookReservation;


/**
 * Author: Yvvonne Mthiyane
 * Student Number: 222530723
 */

public class BookReservationFactory {

    public static BookReservation createBook(Long reservationId, Long bookId, Long userId, String status){

        if (reservationId == null || reservationId <= 0 || bookId == null || bookId <= 0 || userId == null || userId <= 0 || status == null ) {
            return null;
        }

        if (!status.equals("Pending") && !status.equals("Approved") && !status.equals("Cancelled")) {
            return null;
        }

        return new BookReservation.Builder()
                .setReservationId(reservationId)
                .setBookId(bookId)
                .setUserId(userId)
                .setStatus(status)
                .build();
    }
}
