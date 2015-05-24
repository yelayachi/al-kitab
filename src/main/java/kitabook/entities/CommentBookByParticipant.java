package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CommentBookByParticipant extends AbstractEntity {

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
	
	@Column(length = 45)
	private String comment;

	public CommentBookByParticipant(Participant participant, Book book, String comment) {
		super();
		this.participant = participant;
		this.book = book;
		this.comment = comment;
	}

	public CommentBookByParticipant() {
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String toString() {

		return String.format("Comment [%s, %s, %s, %s, %s]", id, version, comment, book.getTitle(), participant.getLogin());
	}
}
