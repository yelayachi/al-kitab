package kitabook.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contributor")
public class Contributor extends Personne {

	private static final long serialVersionUID = 1L;

	public Contributor() {
		super();
	}

	public Contributor(String firstName, String lastName, String occupation, String email, Address adresse) {
		super(firstName, lastName, occupation, email, adresse);
	}

	public String toString() {
		return String.format("Contributor[%s]", super.toString());
	}

}
