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

    // constructors, getters, setters...
}