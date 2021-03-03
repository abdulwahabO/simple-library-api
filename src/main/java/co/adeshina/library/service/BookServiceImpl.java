package co.adeshina.library.service;

import co.adeshina.library.repository.BookRepository;
import co.adeshina.library.dto.BookDto;
import co.adeshina.library.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<List<BookDto>> findByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        if (!books.isEmpty()) {
            List<BookDto> dtos = books.stream().map(this::createDto).collect(Collectors.toList());
            return Optional.of(dtos);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<BookDto>> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        if (!books.isEmpty()) {
            List<BookDto> dtos = books.stream().map(this::createDto).collect(Collectors.toList());
            return Optional.of(dtos);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void addBooks(List<BookDto> dtos) {
        List<Book> books = dtos.stream().map(this::createBook).collect(Collectors.toList());
        bookRepository.saveAll(books);
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    @Override
    public void lendBook(String lendee, String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        book.ifPresent(b -> {
            b.setLent(true);
            b.setLendeeEmail(lendee);
            bookRepository.save(b);
        });
    }

    private BookDto createDto(Book book) {
        BookDto dto = new BookDto();
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setTitle(book.getTitle());
        dto.setYear(book.getYear());
        dto.setPublisher(book.getPublisher());
        return dto;
    }

    private Book createBook(BookDto dto) {
        Book book = new Book();
        book.setIsbn(dto.getIsbn());
        book.setPublisher(dto.getPublisher());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setYear(dto.getYear());
        book.setAdded(LocalDate.now());
        book.setLent(false);
        return new Book();
    }
}
