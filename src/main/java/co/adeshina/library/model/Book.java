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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }

    public LocalDate getAdded() {
        return added;
    }

    public void setAdded(LocalDate added) {
        this.added = added;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public String getLendeeEmail() {
        return lendeeEmail;
    }

    public void setLendeeEmail(String lendeeEmail) {
        this.lendeeEmail = lendeeEmail;
    }

}
