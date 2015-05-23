package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the interestedintopic database table.
 * 
 */
@Entity
@Table(name = "Interestedintopic")
public class Interestedintopic extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	private String comment;

	//bi-directional many-to-one association to Participant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="User_idParticipant")
	private Participant participant;

	//bi-directional many-to-one association to Topic
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Topic_idTopic")
	private Topic topic;
	
	@Column(name = "User_idParticipant", insertable = false, updatable = false)
	private int idParticipant;
	
	@Column(name = "Topic_idTopic", insertable = false, updatable = false)
	private int idTopic;

	public Interestedintopic() {
	}

	public Interestedintopic(Participant participant, Topic topic, String comment) {
		this.participant = participant;
		this.topic = topic;
		this.comment = comment;
	}
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}