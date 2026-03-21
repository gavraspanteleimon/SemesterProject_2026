package iekakmi.SemesterProject.DomainLayer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import iekakmi.SemesterProject.DomainLayer.Models.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
