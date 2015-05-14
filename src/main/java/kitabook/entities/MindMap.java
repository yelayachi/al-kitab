package kitabook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Blob;

@Entity
@Table(name = "mindmap")
public class MindMap extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100)
	private int title;
	
	@Column
	private Blob mindMap;

	public MindMap(int title, Blob mindMap) {
		this.title = title;
		this.mindMap = mindMap;
	}
	
	public MindMap() {
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public Blob getMindMap() {
		return mindMap;
	}

	public void setMindMap(Blob mindMap) {
		this.mindMap = mindMap;
	}
	
	public String toString() {

		return String.format("MindMap [%s, %s, %s]", id, version, title);
	}
	
}
