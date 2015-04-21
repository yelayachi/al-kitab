package kitabook.entities;

import javax.persistence.Column;
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
	
	
	public Personne() {
	}

	public Personne(String firstName, String lastName, String occupation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
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
