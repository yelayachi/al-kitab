package kitabook.repositories;

import kitabook.entities.InterestedInTopic;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterestedInTopicRepository extends
		PagingAndSortingRepository<InterestedInTopic, Long> {

}
