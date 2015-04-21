package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	public Publisher(String commercial_name, String corporate_name,
			String creation_date) {
		super();
		this.commercial_name = commercial_name;
		this.corporate_name = corporate_name;
		this.creation_date = creation_date;
	}

	public Publisher() {
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
