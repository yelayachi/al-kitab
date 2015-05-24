package Commentbookbyparticipant;

import kitabook.entities.CommentBookByParticipant;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentBookByParticipantRepository extends
		PagingAndSortingRepository<CommentBookByParticipant, Long> {

}
