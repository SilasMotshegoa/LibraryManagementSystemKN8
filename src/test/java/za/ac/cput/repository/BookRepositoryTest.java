package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.repository.BookRepository.getRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

/**
 * @author Pelisa: Pali
 * @Student Number: 217189113

 */
class BookRepositoryTest {

    BookRepository bookRepository = getRepository();

    Book book1;
    Book book2;
    Book book3;

    @BeforeEach
    void setUp() {

        book1 = BookFactory.createBook(1231L, "Effective Java", "3rd Edition", "Programming", "Joshua Bloch", "9780134685991");
        book2 = BookFactory.createBook(1232L, "Clean Code", "1st Edition", "Software Engineering", "Robert C. Martin", "9780132350884");
        book3 = BookFactory.createBook(1233L, "The Mirror", "2nd Edition", "Developer", "Peli. B. Pali", "9780132350829");
    }

    @Test
    @Order(1)
    void create() {
        Book newBook = bookRepository.create(book1);
        assertNotNull(newBook);
        System.out.println(newBook);

        Book newBook2 = bookRepository.create(book2);
        assertNotNull(newBook2);
        System.out.println(newBook2);

        Book newBook3 = bookRepository.create(book3);
        assertNotNull(newBook3);
        System.out.println(newBook3);
    }

    @Test
    @Order(2)
    void read() {
        Book foundBook = bookRepository.read(book1.getBookId());
        assertNotNull(foundBook);
        System.out.println("Read: " + foundBook);

    }

    @Test
    @Order(3)
    void update() {
        Book updatedBook = new Book.Builder().copy(book3).setIsbn("9780134685943")
                .build();
        System.out.println(updatedBook);
        Book result = bookRepository.update(updatedBook);

        assertNotNull(result);
        System.out.println("Updated: " + result);

    }


    @Test
    @Order(4)
    void delete() {
        boolean deleted = bookRepository.delete(book2.getBookId());
        assertNotNull(deleted);
        System.out.println("Deleted: " + book1.getBookId());
    }

    @Test
    @Order(5)
    void getAll() {

        System.out.println(bookRepository.getAll());
    }
}