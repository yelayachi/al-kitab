package kitabook.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the readed database table.
 * 
 */
@Entity
@Table(name = "readed")
public class Readed extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date when;

	//bi-directional many-to-one association to Book
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Book_idBook")
	private Book book;

	//bi-directional many-to-one association to Participant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Participant_idParticipant")
	private Participant participant;

	public Readed() {
	}

	public Date getWhen() {
		return this.when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}