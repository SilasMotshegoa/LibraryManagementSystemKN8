package za.ac.cput.repository;

import za.ac.cput.domain.Book;

import java.util.List;

/**
 * @author Pelisa: Pali
 * @Student Number: 217189113

 */

public interface IBookRepository extends IRepository<Book,Long>{
    List<Book> getAll();

}
