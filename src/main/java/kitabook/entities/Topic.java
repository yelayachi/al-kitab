package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic extends AbstractEntity {

	private static final long serialVersionUID = 1L;


	@Column(length = 100)
	private String name;

	public Topic() {
	}

	public Topic(String name) {
		this.name = name;
	}

	public long getIdTopic() {
		return id;
	}

	public void setIdTopic(long idTopic) {
		this.id = idTopic;
	}

	public String getNom() {
		return name;
	}

	public void setNom(String name) {
		this.name = name;
	}

	public String toString() {

		return String.format("Topic[%s, %s, %s]", id, version, name);
	}

}
