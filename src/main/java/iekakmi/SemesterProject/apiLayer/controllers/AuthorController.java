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
import iekakmi.SemesterProject.dataAccessLayer.Dtos.AuthorDto;
import iekakmi.SemesterProject.dataAccessLayer.Services.AuthorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Author")
public class AuthorController {
	
	private final AuthorService authorService ;
	
	public AuthorController ( AuthorService authorService )
	{
		this.authorService = authorService ;
	}

	@GetMapping
	public ResponseEntity<ResponseContainer<List<AuthorDto>>>getAuthor()
	{
		List<AuthorDto> response = authorService.getAuthorDto();
		return ResponseEntity.ok(new ResponseContainer<>(response));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseContainer<AuthorDto>> getCityById(@PathVariable Integer id)
	{
		AuthorDto response = authorService.getAuthorById(id);
		return ResponseEntity.ok(new ResponseContainer<>(response));
	}
	
	@PostMapping
	public ResponseEntity<ResponseContainer<Integer>>createAuthor(@Valid @RequestBody AuthorDto dto)
	{
		int id = authorService.createAuthor(dto);
		return new ResponseEntity<>(new ResponseContainer<>(id),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseContainer<AuthorDto>>updateAuthor
	(@PathVariable Integer id, @Valid @RequestBody AuthorDto dto ) {
		
		dto.setId(id);
		AuthorDto updated = authorService.updateAuthor(dto);
		return ResponseEntity.ok(new ResponseContainer<>(updated));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteAuthor(@PathVariable Integer id)
	{
		authorService.deleteAuthor(id);
		return ResponseEntity.ok().build();
	}

}
