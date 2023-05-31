package com.app.bookstore.book;

public class BookCreateDTO {
	
	private String title;
	private Integer year;
	private Integer isbn;
	
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
		return "BookCreateDTO [title=" + title + ", year=" + year + ", isbn=" + isbn + "]";
	}
}
