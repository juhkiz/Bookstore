package Bookstore.Bookstore.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long categoryid;
	 private String name;
	 
	 @OneToMany
	 @JsonIgnoreProperties("category")
	 private List<Book> books;
	 
	 
	public Category(){}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}
	
	 public List<Book> getBooks() {
		return books;
	}

	public void setCategoryid(Long id) {
		this.categoryid = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Category [id=" + categoryid + ", name=" + name + "]";
	}
	 
	 
	 
}
