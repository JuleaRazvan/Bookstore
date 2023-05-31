package com.app.bookstore.book;

public class BookGetDTO {
	
	private Integer id;
	private String title;
	private Integer year;
	private Integer isbn;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "BookGetDTO [id=" + id + ", title=" + title + ", year=" + year + ", isbn=" + isbn + "]";
	}
}
