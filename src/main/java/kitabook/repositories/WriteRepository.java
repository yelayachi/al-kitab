package kitabook.repositories;

import kitabook.entities.Write;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface WriteRepository extends PagingAndSortingRepository<Write, Long> {

}
