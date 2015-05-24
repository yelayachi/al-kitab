package kitabook.repositories;

import kitabook.entities.Read;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReadRepository extends PagingAndSortingRepository<Read, Long> {

}
