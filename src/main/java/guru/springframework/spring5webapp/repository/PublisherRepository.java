package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.Repository;

public interface PublisherRepository extends Repository<Publisher, Long> {

    <S extends Publisher> S save(S entity);
}