package co.adeshina.library.controller;

import co.adeshina.library.dto.BookDto;
import co.adeshina.library.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search/author")
    public ResponseEntity<List<BookDto>> searchByAuthor(@RequestParam("q") String query) {
        if(query == null || query.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            Optional<List<BookDto>> optionalBookDtos = bookService.findByAuthor(query);
            List<BookDto> bookDtos = optionalBookDtos.orElse(new ArrayList<>());
            return ResponseEntity.ok(bookDtos);
        }
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<BookDto>> searchByTitle(@RequestParam("q") String query) {
        if(query == null || query.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            Optional<List<BookDto>> optionalBookDtos = bookService.findByTitle(query);
            List<BookDto> bookDtos = optionalBookDtos.orElse(new ArrayList<>());
            return ResponseEntity.ok(bookDtos);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBooks(@RequestBody List<BookDto> books) {
        if (books == null || books.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            bookService.addBooks(books);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String isbn) {
        // For simplicity - Assumes ISBN is valid
        bookService.deleteBook(isbn);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/lend/{isbn}/{lendee}")
    public ResponseEntity<Void> lendBook(
            @PathVariable("isbn") String isbn,
            @PathVariable("lendee") String lendeeEmail) {
        // For simplicity - Assumes both path variables are valid.
        bookService.lendBook(lendeeEmail, isbn);
        return ResponseEntity.ok().build();
    }
}
