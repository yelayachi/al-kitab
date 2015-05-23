package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the interestedinpublisher database table.
 * 
 */
@Entity
@Table(name = "interestedinpublisher")
public class Interestedinpublisher extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Lob
	private String publicationListe;

	//bi-directional many-to-one association to Participant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Participant_idParticipant")
	private Participant participant;

	//bi-directional many-to-one association to Publisher
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Publisher_idPublisher")
	private Publisher publisher;
	
	@Column(name = "Participant_idParticipant", insertable = false, updatable = false)
	private int idParticipant;
	
	@Column(name = "Publisher_idPublisher", insertable = false, updatable = false)
	private int idPublisher;

	public Interestedinpublisher() {
	}

	public Interestedinpublisher(Participant participant, Publisher publisher, String publicationListe) {
		this.participant = participant;
		this.publisher = publisher;
		this.publicationListe = publicationListe;
	}

	public String getPublicationListe() {
		return this.publicationListe;
	}

	public void setPublicationListe(String publicationListe) {
		this.publicationListe = publicationListe;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}