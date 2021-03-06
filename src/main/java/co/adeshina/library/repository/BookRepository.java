package co.adeshina.library.repository;

import co.adeshina.library.model.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
}
