package za.ac.cput.repository;


import za.ac.cput.domain.BookReservation;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Author: Yvvonne Mthiyane
 * Student Number: 222530723
 */

public class BookReservationRepository implements IBookReservationRepository{

    private static BookReservationRepository repository = null;

    private List<BookReservation> bookReservationList;

    private BookReservationRepository(){
        bookReservationList = new ArrayList<BookReservation>();
    }

    public static BookReservationRepository getRepository(){
        if (repository == null) {
            repository = new BookReservationRepository();
        }
        return repository;
    }

    @Override
    public BookReservation create(BookReservation bookReservation) {
        boolean success = bookReservationList.add(bookReservation);
        if (success) {
            return bookReservation;
        }
        return null;
    }

    @Override
    public BookReservation read(Long reservationId) {
        System.out.println(bookReservationList.size());
        for (int i = 0; i < bookReservationList.size(); i++) {
            System.out.println("inside for loop" + bookReservationList.get(i).getReservationId() + " Yvvonne" + reservationId);
            if (bookReservationList.get(i).getReservationId() == reservationId) {
                System.out.println("inside read" + bookReservationList.get(i) );
                return bookReservationList.get(i);
            }
        }
        return null;
    }

    @Override
    public BookReservation update(BookReservation bookReservation) {
        System.out.println(bookReservation.getReservationId());
        BookReservation existingReservation = read(bookReservation.getReservationId());
        System.out.println(existingReservation);
        if (existingReservation != null) {
            System.out.println("inside if " + bookReservation);
            bookReservationList.remove(existingReservation);
            bookReservationList.add(bookReservation);
            return bookReservation;
        }
        return null;
    }

    @Override
    public boolean delete(Long reservationId) {
        BookReservation reservationToDelete = read(reservationId);
        if (reservationToDelete != null) {
            return bookReservationList.remove(reservationToDelete);
        }
        return false;
    }

    @Override
    public List<BookReservation> getAll() {
        return new ArrayList<>(bookReservationList);
    }
}
