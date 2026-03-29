package iekakmi.SemesterProject.DomainLayer.Repositories;




import org.springframework.data.jpa.repository.JpaRepository;

import iekakmi.SemesterProject.DomainLayer.Models.Entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
