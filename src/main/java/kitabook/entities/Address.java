package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Address extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 11)
	private int street_number;
	
	@Column(length = 300)
	private String street;
	
	@Column(length = 6)
	private String postal_code;
	
	@Column(length = 45)
	private String city;
	
	@Column(length = 45)
	private String country;

	public Address(int street_number, String street, String postal_code,
			String city, String country) {
		this.street_number = street_number;
		this.street = street;
		this.postal_code = postal_code;
		this.city = city;
		this.country = country;
	}

	public Address() {
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {

		return String.format("Address [%s, %s, %s, %s, %s, %s, %s]", id, version, street_number, street, postal_code, city, country);
	}

}
