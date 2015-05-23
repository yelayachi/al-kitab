package kitabook.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the thematizes database table.
 * 
 */
@Entity
@Table(name="thematizes")
public class Thematize extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Lob
	private String observation;

	//bi-directional many-to-one association to Book
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Book_idBook")
	private Book book;

	//bi-directional many-to-one association to Topic
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Topic_idTopic")
	private Topic topic;

	public Thematize() {
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}