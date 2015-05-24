package kitabook.repositories;

import kitabook.entities.InterestedInContributor;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterestedInContributorRepository extends
		PagingAndSortingRepository<InterestedInContributor, Long> {

}
