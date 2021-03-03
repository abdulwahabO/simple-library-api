package co.adeshina.library.service;

import co.adeshina.library.dto.BookDto;
import java.util.List;
import java.util.Optional;

public interface LibraryService {

    /**
     * Executes a search for all books by the given author.
     *
     * @param author The author to search for.
     * @return A list of DTOs describing the books that match the given author if any.
     * an empty Optional is returned.
     */
    Optional<List<BookDto>> findByAuthor(String author);

    /**
     * Executes a search for all books with the given title.
     *
     * @param title The title to search for.
     * @return A list of DTOS describing all books matching the given title if any are found.
     * Otherwise an empty is returned.
     */
    Optional<List<BookDto>> findByTitle(String title);

    /**
     * Adds the books described list of {@link BookDto}s to the library's database.
     *
     * @param dtos A list of DTOs representing the books to add to the database.
     */
    void addBooks(List<BookDto> dtos);

    /**
     * Removes the book matching the given ISBN from the library's database.
     *
     * @param isbn The ISBN of the book to remove.
     */
    void deleteBook(String isbn);

    /**
     * Marks the book with the given ISBN as lent out to the person with the given email address.
     *
     * @param lendee The email address of the person lending the book.
     * @param isbn The ISBN of the book to lend out.
     */
    void lendBook(String lendee, String isbn);
}
