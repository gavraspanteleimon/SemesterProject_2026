package iekakmi.SemesterProject.DomainLayer.Models.Entities;

import java.util.Set;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name = "author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "nationality")
    public String nationality;

    @Column(name = "dateofbirth")
    public int dateofbirth;

  
    @ManyToMany(mappedBy = "authors")  
    private List<Book> book;
    
    public Author() {}
    
    
    public Author( String name, String nationality, int dateofbirth) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.dateofbirth = dateofbirth;

	}


	// constructors, getters, setters...

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public List<Book> getBook() {
		return book;
	}


	public void setBook(List<Book> book) {
		this.book = book;
	}

   
    
}