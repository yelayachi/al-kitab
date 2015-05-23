package kitabook.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the write database table.
 * 
 */
@Entity
@Table(name = "write")
public class Write extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="writing_date")
	private Date writingDate;

	//bi-directional many-to-one association to Book
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Book_idBook")
	private Book book;

	//bi-directional many-to-one association to Contributor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Contributor_idContributor")
	private Contributor contributor;

	public Write() {
	}

	public Date getWritingDate() {
		return this.writingDate;
	}

	public void setWritingDate(Date writingDate) {
		this.writingDate = writingDate;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Contributor getContributor() {
		return this.contributor;
	}

	public void setContributor(Contributor contributor) {
		this.contributor = contributor;
	}

}