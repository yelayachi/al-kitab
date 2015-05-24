package kitabook.repositories;

import kitabook.entities.InterestedInPublisher;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterestedInPublisherRepository extends
		PagingAndSortingRepository<InterestedInPublisher, Long> {

}
