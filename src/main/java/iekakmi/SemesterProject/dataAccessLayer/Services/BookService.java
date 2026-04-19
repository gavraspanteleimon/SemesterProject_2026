package iekakmi.SemesterProject.dataAccessLayer.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import iekakmi.SemesterProject.DomainLayer.Models.Entities.Book;
import iekakmi.SemesterProject.DomainLayer.Repositories.BookRepository;
import iekakmi.SemesterProject.dataAccessLayer.Dtos.BookDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Validated
public class BookService {

	private final BookRepository bookRepository ;
	
	public BookService( BookRepository bookRepository)
	{
		this.bookRepository = bookRepository ;
	}
	
	public List<BookDto> getBooks()
	{
		return bookRepository.findAll().stream()
				.map(c -> {
					BookDto dto = new BookDto();
					dto.setId(c.getId());
					dto.setTitle(c.getTitle());
					return dto;
				})
				.collect(Collectors.toList());
	}
	
	public BookDto getBookById(int id)
	{
		Book c = bookRepository.findById(id)
				.orElseThrow(()->  new RuntimeException("Book not found with id: " + id));
		BookDto dto = new BookDto();
		dto.setId(c.getId());
		dto.setTitle(c.getTitle());
		return dto ;
}
	@Transactional 
	public int createBook(@Valid BookDto c )
	{
		Book entity = new Book();
		entity.setTitle(c.getTitle());
		Book saved = bookRepository.save(entity);
		return saved.getId();
	}
	
	@Transactional
	public BookDto updateBook(@Valid BookDto c)
	{
		Book entity = bookRepository.findById(c.getId())
				.orElseThrow(()->  new RuntimeException("Book not found with id: " + c.getId()));
		entity.setTitle(c.getTitle());
		bookRepository.save(entity);
		return c;
	}
	
	@Transactional
	public void deleteBook(int id)
	{
		bookRepository.deleteById(id);
	}
	
}
