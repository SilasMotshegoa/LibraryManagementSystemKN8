package za.ac.cput.factory;

import za.ac.cput.domain.Book;

/**
 * @author Pelisa: Pali
 * @Student Number: 217189113

 */

public class BookFactory {
    public static Book createBook(Long bookId, String title, String bookVersion, String genre, String author, String isbn) {
            if (bookId == null || bookId <= 0 ||
                title == null || title.isEmpty() ||
                bookVersion == null || bookVersion.isEmpty() ||
                genre == null || genre.isEmpty() ||
                author == null || author.isEmpty() ||
                isbn == null || isbn.isEmpty()) {
            return null;
        }

        return new Book.Builder()
                .setBookId(bookId)
                .setTitle(title)
                .setBookVersion(bookVersion)
                .setGenre(genre)
                .setAuthor(author)
                .setIsbn(isbn)
                .build();
    }


}
