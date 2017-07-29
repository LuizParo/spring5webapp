package guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.Repository;

import guru.springframework.spring5webapp.model.Author;

public interface AuthorRepository extends Repository<Author, Long> {

    <S extends Author> S save(S entity);

    Iterable<Author> findAll();
}