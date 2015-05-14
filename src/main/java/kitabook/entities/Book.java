package kitabook.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "book")
public class Book extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(length = 100)
	private String title;
	
	@Column
	private Date date_publishing;
	
	@Column(length = 11)
	private int pages_number;
	
	@Column(length = 45)
	private String isbn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_idpublisher")
	private Publisher publisher;

	// clé étrangère
	@Column(name = "publisher_idpublisher", insertable = false, updatable = false)
	private int idPublisher;

	public Book(Publisher publisher, String title, Date datePublishing, int pagesNumber,
			String isbn) {
		
		this.publisher = publisher;
		this.title = title;
		this.date_publishing = datePublishing;
		this.pages_number = pagesNumber;
		this.isbn = isbn;
	}
	
	public Book() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatePublishing() {
		return date_publishing;
	}

	public void setDatePublishing(Date datePublishing) {
		this.date_publishing = datePublishing;
	}

	public int getPagesNumber() {
		return pages_number;
	}

	public void setPagesNumber(int pagesNumber) {
		this.pages_number = pagesNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getIdPublisher() {
		return idPublisher;
	}

	public void setIdPublisher(int idPublisher) {
		this.idPublisher = idPublisher;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Transactional
	public String toString() {
		return String.format("Book [%s, %s, %s, %s, %s, %s]", id, version, title, date_publishing, pages_number, isbn);
	}

}
