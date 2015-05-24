package kitabook.repositories;

import kitabook.entities.InterestedInParticipant;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterestedInParticipantRepository extends
		PagingAndSortingRepository<InterestedInParticipant, Long> {

}
