package kitabook.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the translate database table.
 * 
 */
@Entity
@Table(name = "translate")
public class Translate extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Lob
	private String partTranslated;

	//bi-directional many-to-one association to Book
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Book_idBook")
	private Book book;

	//bi-directional many-to-one association to Contributor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Contributor_idContributor")
	private Contributor contributor;

	public Translate() {
	}

	public String getPartTranslated() {
		return this.partTranslated;
	}

	public void setPartTranslated(String partTranslated) {
		this.partTranslated = partTranslated;
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