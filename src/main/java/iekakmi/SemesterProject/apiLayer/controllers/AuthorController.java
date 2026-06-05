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
	public ResponseEntity<List<AuthorDto>>getAuthor()
	{
		List<AuthorDto> response = authorService.getAuthorDto();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer id)
	{
		AuthorDto response = authorService.getAuthorById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Integer>createAuthor(@Valid @RequestBody AuthorDto dto)
	{
		int id = authorService.createAuthor(dto);
		return new ResponseEntity<>(id,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AuthorDto>updateAuthor
	(@PathVariable Integer id, @Valid @RequestBody AuthorDto dto ) {
		
		dto.setId(id);
		AuthorDto updated = authorService.updateAuthor(dto);
		return ResponseEntity.ok(updated);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteAuthor(@PathVariable Integer id)
	{
		authorService.deleteAuthor(id);
		return ResponseEntity.ok().build();
	}

}
