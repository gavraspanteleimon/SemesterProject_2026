package iekakmi.SemesterProject.apiLayer.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iekakmi.SemesterProject.apiLayer.models.ResponseContainer;
import iekakmi.SemesterProject.dataAccessLayer.Dtos.BookDto;
import iekakmi.SemesterProject.dataAccessLayer.Services.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Book")
public class BookController {
	
	private final BookService bookService ;
	
	public BookController(BookService bookService)
	{
		this.bookService = bookService ;
	}
	
	@GetMapping
	public ResponseEntity<ResponseContainer<List<BookDto>>>getBook()
	{
		List<BookDto> response = bookService.getBook();
		return ResponseEntity.ok(new ResponseContainer<>(response));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseContainer<BookDto>>getBookById(@PathVariable Integer id)
	{
		BookDto response = bookService.getBookById(id);
		return ResponseEntity.ok(new ResponseContainer<>(response));
	}
	
	@PostMapping
	public ResponseEntity<ResponseContainer<Integer>>createBook(@Valid @RequestBody BookDto dto)
	{
		int id = bookService.createBook(dto);
		return new ResponseEntity<>(new ResponseContainer<>(id),HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ResponseContainer<BookDto>>updateBook
	(@PathVariable Integer id, @Valid @RequestBody BookDto dto)
	{
		dto.setId(id);
		BookDto updated = bookService.updateBook(dto);
		return ResponseEntity.ok(new ResponseContainer<>(updated));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteBook(@PathVariable Integer id)
	{
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
	


}
