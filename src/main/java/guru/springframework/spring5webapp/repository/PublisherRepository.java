package guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.Repository;

import guru.springframework.spring5webapp.model.Publisher;

public interface PublisherRepository extends Repository<Publisher, Long> {

    <S extends Publisher> S save(S entity);
}