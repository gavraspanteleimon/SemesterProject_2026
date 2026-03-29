package iekakmi.SemesterProject;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import iekakmi.SemesterProject.DomainLayer.Models.Entities.Author;
import iekakmi.SemesterProject.DomainLayer.Models.Entities.Book;
import iekakmi.SemesterProject.DomainLayer.Repositories.AuthorRepository;
import iekakmi.SemesterProject.DomainLayer.Repositories.BookRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DomainLayerTest {

	
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private AuthorRepository authorrepository;
	

	
	@Test
	void findallauthors() {
		
		List<Author> author= authorrepository.findAll();

		Assertions.assertThat(author).isNotNull();
		Assertions.assertThat(author.size()).isGreaterThan(0);
	}
		
	@Test
	void getallbooks() {
		List<Book> book = bookrepository.findAll();
		
		Assertions.assertThat(book).isNotNull();
		Assertions.assertThat(book.size()).isGreaterThan(0);
	
	
}
}
