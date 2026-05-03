package iekakmi.SemesterProject.dataAccessLayer.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import iekakmi.SemesterProject.DomainLayer.Models.Entities.Author;
import iekakmi.SemesterProject.DomainLayer.Repositories.AuthorRepository;
import iekakmi.SemesterProject.dataAccessLayer.Dtos.AuthorDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Validated
public class AuthorService {
	
	private final AuthorRepository authorRepository ;
	
	
	public AuthorService ( AuthorRepository authorRepository) {
		this.authorRepository = authorRepository ;
		
	}

	public List<AuthorDto> getAuthorDto() // get author list 
	{
	return authorRepository.findAll().stream()
			.map( c -> {
				AuthorDto dto = new AuthorDto();
				dto.setId(c.getId());
				dto.setName(c.getName());
				return dto;
			})
			.collect(Collectors.toList());
	}
	
	public AuthorDto getAuthorById(int id)
	{
		Author c = authorRepository.findById(id)
				.orElseThrow(()->  new RuntimeException("Author not found with id: " + id));
		AuthorDto dto = new AuthorDto();
		dto.setId(c.getId());
		dto.setName(c.getName());
		return dto ;
	}
	
	@Transactional
	public int createAuthor(@Valid AuthorDto c)
	{
	Author entity = new Author();
	entity.setName(c.getName());
	Author saved = authorRepository.save(entity);
	return saved.getId();
	}
	
	@Transactional
	public AuthorDto updateAuthor(@Valid AuthorDto c)
	{
		Author entity = authorRepository.findById(c.getId())
				.orElseThrow(()->  new RuntimeException("Author not found with id: " + c.getId()));
	entity.setName(c.getName());
	authorRepository.save(entity);
	return c ;
	}
	
	@Transactional 
	public void deleteAuthor(int id)
	{
		authorRepository.deleteById(id);
	}
	
}
