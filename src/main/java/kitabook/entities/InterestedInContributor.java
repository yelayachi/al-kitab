package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the interestedincontributor database table.
 * 
 */
@Entity
@Table(name = "interestedincontributor")
public class InterestedInContributor extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Lob
	private String contributionsListe;

	//bi-directional many-to-one association to Contributor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Contributor_idContributor")
	private Contributor contributor;

	//bi-directional many-to-one association to Participant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="User_idParticipant")
	private Participant participant;
	
	@Column(name = "Contributor_idContributor", insertable = false, updatable = false)
	private int idContributor;
	
	@Column(name = "User_idParticipant", insertable = false, updatable = false)
	private int idParticipant;

	public InterestedInContributor() {
	}
	
	public InterestedInContributor(Contributor contributor, Participant participant, String contributionsListe) {
		this.contributor = contributor;
		this.participant = participant;
		this.contributionsListe = contributionsListe;
	}

	public String getContributionsListe() {
		return this.contributionsListe;
	}

	public void setContributionsListe(String contributionsListe) {
		this.contributionsListe = contributionsListe;
	}

	public Contributor getContributor() {
		return this.contributor;
	}

	public void setContributor(Contributor contributor) {
		this.contributor = contributor;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}