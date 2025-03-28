package za.ac.cput.repository;

import za.ac.cput.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Pelisa: Pali
 * @Student Number: 217189113

 */

public class BookRepository implements IBookRepository {

    private static BookRepository repository = null;

    private List<Book> booksList;

    private BookRepository() {
        booksList = new ArrayList<Book>();
    }

    public static BookRepository getRepository() {
        if (repository == null) {
            repository = new BookRepository();
        }
        return repository;
    }

    @Override
    public Book create(Book book) {
        boolean success = booksList.add(book);
        if (success) {
            return book;
        }
        return null;
    }

    @Override
    public Book read(Long bookId) {
        System.out.println(booksList.size());
        for (int i = 0; i < booksList.size(); i++) {
            if (Objects.equals(booksList.get(i).getBookId(), bookId)) {
                System.out.println("inside read" + booksList.get(i) );
                return booksList.get(i);
            }
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        System.out.println(book.getBookId());
        Book existingReservation = read(book.getBookId());
        System.out.println(existingReservation);
        if (existingReservation != null) {
            System.out.println("inside if " + book);
            booksList.remove(existingReservation);
            booksList.add(book);
            return book;
        }
        return null;
    }

    @Override
    public boolean delete(Long bookId) {
        Book reservationToDelete = read(bookId);
        if (reservationToDelete != null) {
            return booksList.remove(reservationToDelete);
        }
        return false;
    }


    @Override
    public List<Book> getAll() {
        return new ArrayList<>(booksList);
    }

}
