package iekakmi.SemesterProject.DomainLayer.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import iekakmi.SemesterProject.DomainLayer.Models.Entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	List<Author> findByUserId(int userId);


}
