package za.ac.cput.domain;

import java.util.Objects;

/**
 * @author Pelisa: Pali
 * @Student Number: 217189113

 */

public class Book {

    private Long bookId;
    private String title;
    private String bookVersion;
    private String genre;
    private String author;
    private String isbn;


    private Book() {
    }

    private Book(Builder builder) {
        this.bookId = builder.bookId;
        this.title = builder.title;
        this.bookVersion = builder.bookVersion;
        this.genre = builder.genre;
        this.author = builder.author;
        this.isbn = builder.isbn;

    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getBookVersion() {
        return bookVersion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(title, book.title) && Objects.equals(bookVersion, book.bookVersion) && Objects.equals(genre, book.genre) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, bookVersion, genre, author, isbn);
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", bookVersion='" + bookVersion + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public static class Builder{
        private Long bookId;
        private String title;
        private String bookVersion;
        private String genre;
        private String author;
        private String isbn;

        public Builder setBookId(Long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBookVersion(String bookVersion) {
            this.bookVersion = bookVersion;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder copy(Book book) {
            this.bookId = book.bookId;
            this.title = book.title;
            this.bookVersion = book.bookVersion;
            this.genre = book.genre;
            this.author = book.author;
            this.isbn = book.isbn;
            return this;

        }

        public Book build() {
            return new Book(this);
        }
    }

}
