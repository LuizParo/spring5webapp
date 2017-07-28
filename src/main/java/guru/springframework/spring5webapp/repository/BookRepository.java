package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<Book, Long> {

    <S extends Book> S save(S entity);

    Iterable<Book> findAll();
}