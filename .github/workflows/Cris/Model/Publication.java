package es.upm.dit.apsv.cris.model;

import java.io.Serializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;



@Entity
public class Publication implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String title;
	private String publicationName;
	private String publicationDate;
	private String authors;
	private int citeCount;
	
	public Publication() {
		super();
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public int getCiteCount() {
		return citeCount;
	}

	public void setCiteCount(int citeCount) {
		this.citeCount = citeCount;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", publicationName=" + publicationName
				+ ", publicationDate=" + publicationDate + ", authors=" + authors + ", citeCount=" + citeCount + "]";
	}

	
	
	
}
