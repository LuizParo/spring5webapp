package guru.springframework.spring5webapp.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(value = AccessType.FIELD)
    private Long id;

    @Access(value = AccessType.FIELD)
    private String title;

    @Access(value = AccessType.FIELD)
    private String isbn;

    @OneToOne
    @Access(value = AccessType.FIELD)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @Access(value = AccessType.FIELD)
    private Collection<Author> authors;

    @Deprecated
    Book() {
        this("", "", null, new HashSet<>());
    }

    public Book(String title, String isbn, Publisher publisher) {
        this(title, isbn, publisher, new HashSet<>());
    }

    public Book(String title, String isbn, Publisher publisher, Author... authors) {
        this(title, isbn, publisher, new HashSet<>(Arrays.asList(authors)));
    }

    public Book(String title, String isbn, Publisher publisher, Collection<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = Objects.isNull(authors) ? new HashSet<>() : authors;

        init();
    }

    private void init() {
        this.authors.forEach(author -> author.addBook(this));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Collection<Author> getAuthors() {
        return new HashSet<>(authors);
    }

    public void addAuthor(Author author) {
        if(Objects.isNull(author)) {
            return;
        }

        if(!this.authors.contains(author)) {
            this.authors.add(author);
            author.addBook(this);
        }
    }
}