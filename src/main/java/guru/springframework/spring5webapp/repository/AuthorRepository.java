package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.Repository;

public interface AuthorRepository extends Repository<Author, Long> {

    <S extends Author> S save(S entity);
}