package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Personne extends AbstractEntity {

	
	private static final long serialVersionUID = 1L;

	@Column(name = "first_name", length = 45)
	private String firstName;
	
	@Column(name = "last_name", length = 45)
	private String lastName;
	
	@Column(length = 45)
	private String occupation;
	
	@Column(length = 320)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adress_idadress")
	private Address adresse;
	
	// clé étrangère
	@Column(name = "adress_idadress", insertable = false, updatable = false)
	private int idAdresse;
	
	public Personne() {
	}

	public Personne(String firstName, String lastName, String occupation, String email, Address adresse) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.email = email;
		this.adresse = adresse;
	}

	public Address getAdresse() {
		return adresse;
	}

	public void setAdresse(Address adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String toString() {
		return String.format("Personne[%s, %s, %s, %s, %s]", id, version, firstName, lastName, occupation);
	}
	
	

}
