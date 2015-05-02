package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chronic")
public class Chronic extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participant_idparticipant")
	private Participant participant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_idbook")
	private Book book;
	
	@Column(name = "participant_idparticipant", insertable = false, updatable = false)
	private int idParticipant;
	
	@Column(name = "book_idbook", insertable = false, updatable = false)
	private int idBook;
	
	@Column
	private String chronique;

	public Chronic(Participant participant, Book book, String chronique) {
		this.participant = participant;
		this.book = book;
		this.chronique = chronique;
	}

	public Chronic() {
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getChronique() {
		return chronique;
	}

	public void setChronique(String chronique) {
		this.chronique = chronique;
	}
	
	public String toString() {

		return String.format("Chronique [%s, %s, %s, %s, %s]", id, version, chronique, book.getTitle(), participant.getLogin());
	}
	
}
