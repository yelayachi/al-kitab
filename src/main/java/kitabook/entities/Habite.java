package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Habite extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participant_idparticipant")
	private Participant participant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adress_idadress")
	private Address adresse;
	
	@Column(name = "participant_idparticipant", insertable = false, updatable = false)
	private int idParticipant;
	
	@Column(name = "adress_idadress", insertable = false, updatable = false)
	private int idAadresse;

}
