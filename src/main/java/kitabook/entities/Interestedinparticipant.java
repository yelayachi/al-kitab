package kitabook.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the interestedinparticipant database table.
 * 
 */
@Entity
@Table(name = "interestedinparticipant")
public class Interestedinparticipant extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Lob
	private String commonTopics;

	//bi-directional many-to-one association to Participant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="InterstedP_idParticipant")
	private Participant participant1;

	//bi-directional many-to-one association to Participant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="InterestingP_idParticipant")
	private Participant participant2;

	public Interestedinparticipant() {
	}

	public String getCommonTopics() {
		return this.commonTopics;
	}

	public void setCommonTopics(String commonTopics) {
		this.commonTopics = commonTopics;
	}

	public Participant getParticipant1() {
		return this.participant1;
	}

	public void setParticipant1(Participant participant1) {
		this.participant1 = participant1;
	}

	public Participant getParticipant2() {
		return this.participant2;
	}

	public void setParticipant2(Participant participant2) {
		this.participant2 = participant2;
	}

}