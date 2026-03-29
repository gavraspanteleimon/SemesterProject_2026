package iekakmi.SemesterProject.DomainLayer.Models.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity (name = "book") 
public class Book {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	
	@Column( name = "isbn")
	public String isbn;
	
	@Column( name = "title")
	public String title ;
	
	@Column( name = "year")
	public int year;
	
	@Column( name = "author")
	public String author;
	
	
	@ManyToMany
	@JoinTable(
	  name = "BookByAuthor", 
	  joinColumns = @JoinColumn(name = "book_id"), 
	  inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;

	
	
	//constructors
	public Book() {}
	
	public Book(String isbn, String title, int year, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.author = author;
	}
	
	// getters , setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
