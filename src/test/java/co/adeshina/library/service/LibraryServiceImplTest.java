package co.adeshina.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import co.adeshina.library.dao.BookRepository;
import co.adeshina.library.dto.BookDto;
import co.adeshina.library.model.Book;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryServiceImplTest {

    private BookRepository bookRepository = mock(BookRepository.class);
    Book lentBook = mock(Book.class);

    @BeforeEach
    public void setup() {
        when(bookRepository.findByAuthor("Mr. Shola")).thenReturn(mockBooks());
        when(bookRepository.findById("12345")).thenReturn(Optional.of(lentBook));
    }

    @Test
    public void shouldReturnAuthorBooks() {
        LibraryService libraryService = new LibraryServiceImpl(bookRepository);
        Optional<List<BookDto>> booksOptional = libraryService.findByAuthor("Mr. Shola");
        assertTrue(booksOptional.isPresent());
        List<BookDto> bookDtos = booksOptional.get();
        assertEquals(2, bookDtos.size());
    }

    @Test
    public void shouldUpdateAndSaveLentBook(){
        LibraryService libraryService = new LibraryServiceImpl(bookRepository);
        libraryService.lendBook("ade@gmail.com", "12345");
        verify(lentBook).setLent(true);
        verify(lentBook).setLendeeEmail("ade@gmail.com");
        verify(bookRepository).save(lentBook);
    }

    private List<Book> mockBooks() {

        Book book = new Book();
        book.setYear("2021");
        book.setIsbn("0920928312");
        book.setAuthor("Mr. Shola");
        book.setPublisher("Hurst UK");
        book.setTitle("A Book of Colours");
        book.setAdded(LocalDate.now());

        Book book2 = new Book();
        book.setYear("2019");
        book.setIsbn("19809283552");
        book.setAuthor("Mr. Shola");
        book.setPublisher("Hurst UK");
        book.setTitle("Story Time");
        book.setAdded(LocalDate.now());

        return Arrays.asList(book, book2);
    }
}
