package iekakmi.SemesterProject.DomainLayer.Models.Entities;

import javax.swing.Spring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "book") 
public class Book {
	
	@Id
	@Column(name = "id")
	public int id ;
	
	public String isbn;
	public String title ;
	public int year;
	public String author;
	
	
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
