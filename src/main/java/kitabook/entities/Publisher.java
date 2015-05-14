package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher extends AbstractEntity {


	private static final long serialVersionUID = 1L;
	
	@Column(length = 100)
	private String commercial_name;
	
	@Column(length = 100)
	private String corporate_name;
	
	@Column
	private String creation_date;
	
	@Column(length = 320)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adress_idadress")
	private Address adresse;
	
	// clé étrangère
	@Column(name = "adress_idadress", insertable = false, updatable = false)
	private int idAdresse;

	public Publisher(String commercial_name, String corporate_name,
			String creation_date, String email, Address adresse) {
		this.commercial_name = commercial_name;
		this.corporate_name = corporate_name;
		this.creation_date = creation_date;
		this.email = email;
		this.adresse = adresse;
	}

	public Publisher() {
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommercial_name() {
		return commercial_name;
	}

	public void setCommercial_name(String commercial_name) {
		this.commercial_name = commercial_name;
	}

	public String getCorporate_name() {
		return corporate_name;
	}

	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	
	public String toString() {

		return String.format("Publisher[%s, %s, %s, %s, %s]", id, version, commercial_name, corporate_name, creation_date);
	}
}
