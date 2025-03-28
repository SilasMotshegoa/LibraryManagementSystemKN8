package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.BookReservation;
import za.ac.cput.factory.BookReservationFactory;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.repository.BookReservationRepository.getRepository;


/**
 * Author: Yvvonne Mthiyane
 * Student Number: 222530723
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookReservationRepositoryTest {


    BookReservationRepository bookReservationRepository = getRepository();

    BookReservation reservation1;
    BookReservation reservation2;
    BookReservation reservation3;

    @BeforeEach
    void setUp() {

        reservation1 = BookReservationFactory.createBook(22334L, 12L, 7724L, "Cancelled");
        reservation2 = BookReservationFactory.createBook(45674L, 23L, 7734L, "Approved");
        reservation3 = BookReservationFactory.createBook(76312L, 72L, 7781L, "Pending");

//        System.out.println(reservation1);
//        System.out.println(reservation2);
//        System.out.println(reservation3);

    }


    @Test
    @Order(1)
    void create() {

        BookReservation newBookReservation = bookReservationRepository.create(reservation1);
        assertNotNull(newBookReservation);
        System.out.println(newBookReservation);

        BookReservation newBookReservation2 = bookReservationRepository.create(reservation2);
        assertNotNull(newBookReservation2);
        System.out.println(newBookReservation2);

        BookReservation newBookReservation3 = bookReservationRepository.create(reservation3);
        assertNotNull(newBookReservation3);
        System.out.println(newBookReservation3);
    }

    @Test
    @Order(2)
    void read() {

        BookReservation foundReservation = bookReservationRepository.read(reservation1.getReservationId());
        assertNotNull(foundReservation);
        System.out.println("Read: " + foundReservation);
    }

    @Test
    @Order(3)
    void update() {

        BookReservation updatedReservation = new BookReservation.Builder().copy(reservation3).setUserId(7765L)
                .setStatus("Completed")
                .build();
        System.out.println(updatedReservation);
        BookReservation result = bookReservationRepository.update(updatedReservation);

        assertNotNull(result);
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = bookReservationRepository.delete(reservation2.getReservationId());
        assertNotNull(deleted);
        System.out.println("Deleted: " + reservation2.getReservationId());
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(bookReservationRepository.getAll());
    }
}