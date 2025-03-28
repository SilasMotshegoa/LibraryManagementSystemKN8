package za.ac.cput.repository;


import za.ac.cput.domain.BookReservation;

import java.util.List;


/**
 * Author: Yvvonne Mthiyane
 * Student Number: 222530723
 */


public interface IBookReservationRepository extends IRepository<BookReservation, Long> {
    List<BookReservation> getAll();
}
