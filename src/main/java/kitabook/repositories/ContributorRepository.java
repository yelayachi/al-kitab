package kitabook.repositories;

import kitabook.entities.Contributor;

import org.springframework.data.repository.CrudRepository;

public interface ContributorRepository extends CrudRepository<Contributor, Long> {

}
