package co.adeshina.library.controller;

import co.adeshina.library.dto.BookDto;
import co.adeshina.library.dto.SearchDto;
import co.adeshina.library.service.LibraryService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {

    // todo: write a data.sql that dumps a lot of books into DB.

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/search/author")
    public ResponseEntity<SearchDto> searchByAuthor(@RequestParam("q") String query) {

    }

    @GetMapping("/search/title")
    public ResponseEntity<SearchDto> searchByTitle(@RequestParam("q") String query) {
        List<BookDto> result = libraryService.findByTitle(query);
        SearchDto searchDto = new SearchDto();
        searchDto.setSize(result.size());
        searchDto.setBooks(result);
        return ResponseEntity.ok(searchDto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBooks(List<BookDto> books) {
        // todo: performs update if ISBN exists..
    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable("isbn") String isbn) {

    }

    @PutMapping("/lend/{isbn}/{lendee}")
    public ResponseEntity<Void> lendBook(
            @PathVariable("isbn") String isbn,
            @PathVariable("lendee") String lendeeEmail) {

    }
}
