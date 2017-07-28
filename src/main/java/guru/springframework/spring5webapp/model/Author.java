package guru.springframework.spring5webapp.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(value = AccessType.FIELD)
    private Long id;

    @Access(value = AccessType.FIELD)
    private String firstName;

    @Access(value = AccessType.FIELD)
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    @Access(value = AccessType.FIELD)
    private Collection<Book> books = new HashSet<>();

    @Deprecated
    Author() {
        this("", "", new HashSet<>());
    }

    public Author(String firstName, String lastName, Book... books) {
        this(firstName, lastName, new HashSet<>(Arrays.asList(books)));
    }

    public Author(String firstName, String lastName, Collection<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = Objects.isNull(books) ? new HashSet<>() : books;

        init();
    }

    private void init() {
        this.books.forEach(book -> book.addAuthor(this));
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Collection<Book> getBooks() {
        return new HashSet<>(this.books);
    }

    public void addBook(Book book) {
        if(Objects.isNull(book)) {
            return;
        }

        if(!this.books.contains(book)) {
            this.books.add(book);
            book.addAuthor(this);
        }
    }
}