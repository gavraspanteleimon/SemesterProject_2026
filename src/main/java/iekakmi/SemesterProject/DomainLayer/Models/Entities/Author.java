package iekakmi.SemesterProject.DomainLayer.Models.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "author") 
public class Author {
	
	@Id
	@Column(name = "id")
	public int id;
	
	public String name;
	public String nationality;
	public int dateofbirth;
	public String books ;
	
	//CONSTRUCTORS
	public Author() {}
	
	 Author(String name, String nationality, int dateofbirth, String books) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.dateofbirth = dateofbirth;
		this.books = books;
	}

	 // SETTERS - GETTERS
	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getNationality() {
		 return nationality;
	 }

	 public void setNationality(String nationality) {
		 this.nationality = nationality;
	 }

	 public int getDateofbirth() {
		 return dateofbirth;
	 }

	 public void setDateofbirth(int dateofbirth) {
		 this.dateofbirth = dateofbirth;
	 }

	 public String getBooks() {
		 return books;
	 }

	 public void setBooks(String books) {
		 this.books = books;
	 }
	
	
	
	
	
}
