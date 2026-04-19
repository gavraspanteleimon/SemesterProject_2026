package iekakmi.SemesterProject.dataAccessLayer.Dtos;

import jakarta.validation.constraints.NotNull;   
import jakarta.validation.constraints.NotEmpty;  

public class AuthorDto {
	
    private int id;
    
	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be empty")
	
    private String name;
	
    private String nationality;
    
    private int dateofbirth;
    
    
    public AuthorDto() {} ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(int dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
    
    
    
    
}