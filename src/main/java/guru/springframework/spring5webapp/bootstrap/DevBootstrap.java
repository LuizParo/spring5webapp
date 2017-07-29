package guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher harperCollins = new Publisher("Harper Collins", "");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        Author eric = new Author("Eric", "Evans", ddd);

        this.publisherRepository.save(harperCollins);
        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);

        Publisher worx = new Publisher("Worx", "");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        Author rod = new Author("Rod", "Johnson", noEJB);

        this.publisherRepository.save(worx);
        this.authorRepository.save(rod);
        this.bookRepository.save(noEJB);
    }
}