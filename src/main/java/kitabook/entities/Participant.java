package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
public class Participant extends Personne {

	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 10)
	private String login;
	
	@Column(name = "mdp", length = 45)
	private String password;
	
	@Column(length = 10)
	private String birthday;

	public Participant(String login, String password, String firstName,
			String lastName, String occupation, String birthday) {
		super();
		this.login = login;
		this.password = password;
		this.birthday = birthday;
	}

	public Participant() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String toString() {
		return String.format("Participant [%s]", super.toString());
	}
	
}
