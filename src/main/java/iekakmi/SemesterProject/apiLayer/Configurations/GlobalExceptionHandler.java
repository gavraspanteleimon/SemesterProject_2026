package iekakmi.SemesterProject.apiLayer.Configurations;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import iekakmi.SemesterProject.apiLayer.models.ResponseContainer;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseContainer<Void>> handleNotFound(EntityNotFoundException ex)
	{
		return new ResponseEntity<>(new ResponseContainer<>(null,ex.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseContainer<Void>> handleValidation(MethodArgumentNotValidException ex)
	{
		String errors = ex.getBindingResult().getFieldErrors().stream()
				.map(e-> e.getField() + ": "+e.getDefaultMessage())
				.collect(Collectors.joining(", "));
		return new ResponseEntity<>(new ResponseContainer<>(null,errors),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseContainer<Void>> handleConstraintViolation(ConstraintViolationException ex)
	{
		return new ResponseEntity<>(new ResponseContainer<>(null, ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseContainer<Void>> handleGeneral(Exception ex)
	{
		return new ResponseEntity<>(new ResponseContainer<>(null,"Internal server error"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
