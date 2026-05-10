package iekakmi.SemesterProject.dataAccessLayer.Dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BookDto {
    public int id;

    public String isbn;

    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    public String title;

    public int year;

    public String author;

    public BookDto() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}