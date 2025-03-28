package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pelisa: Pali
 * @Student Number: 217189113

 */

class BookFactoryTest {

    private static Book book1 = BookFactory.createBook(1231L, "Effective Java", "3rd Edition", "Programming", "Joshua Bloch", "9780134685991");
    private static Book book2 = BookFactory.createBook(1232L, "Clean Code", "1st Edition", "Software Engineering", "Robert C. Martin", "9780132350884");



    @Test
    public void testCreateBook() {
    assertNotNull(book1);
    assertNotNull(book2);

    System.out.println(book1.toString());
    System.out.println(book2.toString());
}

    @Test
    public void testBookEquality() {
        Book bookCopy = BookFactory.createBook(1231L, "Effective Java", "3rd Edition", "Programming", "Joshua Bloch", "9780134685991");
        assertEquals(book1, bookCopy);
    }

    @Test
    public void testBookIdentity() {
        assertNotSame(book1, book2);

    }

}