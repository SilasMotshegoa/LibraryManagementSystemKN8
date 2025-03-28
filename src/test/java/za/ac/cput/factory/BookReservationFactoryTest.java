package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BookReservation;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Author: Yvvonne Mthiyane
 * Student Number: 222530723
 */

class BookReservationFactoryTest {

    BookReservation reservation1;

    @BeforeEach
    void setUp() {
        reservation1 = BookReservationFactory.createBook(22334L, 12L, 7724L, "Cancelled");
    }

    @Test
    void createBook() {
        assertNotNull(reservation1);
    }
}