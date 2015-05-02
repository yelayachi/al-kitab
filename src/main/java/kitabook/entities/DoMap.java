package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DoMap extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participant_idparticipant")
	private Participant participant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_idbook")
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mindmap_idmindmap")
	private MindMap mindMap;
	
	@Column(name = "participant_idparticipant", insertable = false, updatable = false)
	private int idParticipant;
	
	@Column(name = "book_idbook", insertable = false, updatable = false)
	private int idBook;
	
	@Column(name = "mindmap_idmindmap", insertable = false, updatable = false)
	private int idMindMap;
	
	@Column(length = 10)
	private String date_creation;

	public DoMap(Participant participant, Book book, MindMap mindMap, String date_creation) {
		super();
		this.participant = participant;
		this.book = book;
		this.mindMap = mindMap;
		this.date_creation = date_creation;
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

	public MindMap getMindMap() {
		return mindMap;
	}

	public void setMindMap(MindMap mindMap) {
		this.mindMap = mindMap;
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

	public int getIdMindMap() {
		return idMindMap;
	}

	public void setIdMindMap(int idMindMap) {
		this.idMindMap = idMindMap;
	}

	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	
	public String toString() {

		return String.format("DoMap [%s, %s, %s, %s, %s, %s]", id, version, mindMap, book, participant, date_creation);
	}
	
}
