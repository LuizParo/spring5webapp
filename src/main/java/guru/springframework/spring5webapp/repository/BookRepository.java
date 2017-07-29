package guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.Repository;

import guru.springframework.spring5webapp.model.Book;

public interface BookRepository extends Repository<Book, Long> {

    <S extends Book> S save(S entity);

    Iterable<Book> findAll();
}