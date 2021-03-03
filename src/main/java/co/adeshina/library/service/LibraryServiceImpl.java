package co.adeshina.library.service;

import co.adeshina.library.dao.BookRepository;
import co.adeshina.library.dto.BookDto;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    private Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

    private BookRepository bookRepository;

    public LibraryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findByAuthor(String author) {
        return null;
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        return null;
    }

    @Override
    public void addBooks(List<BookDto> books) {

    }

    @Override
    public void deleteBook(String isbn) {

    }

    @Override
    public void lendBook(String lendee, String isbn) {

    }
}
