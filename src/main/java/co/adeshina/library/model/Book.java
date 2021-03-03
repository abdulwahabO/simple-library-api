package co.adeshina.library.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private String isbn;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "PUBLICATION_YEAR", nullable = false)
    private String year;

    @Column(name = "PUBLISHER", nullable = false)
    private String publisher;

    @Column(name = "IS_LENT", nullable = false)
    private boolean isLent;

    @Column(name = "ADDED_ON", nullable = false)
    private LocalDate added;

    @Column(name = "UPDATED_ON")
    private LocalDate updated;

    @Column(name = "LENT_TO")
    private String lendeeEmail;

    // todo: README should explain assumption: Library has just one copy of each book.

}
