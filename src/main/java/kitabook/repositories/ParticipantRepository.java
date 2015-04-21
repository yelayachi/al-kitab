package kitabook.repositories;

import kitabook.entities.Participant;

import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}
