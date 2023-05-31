package com.app.bookstore.book;

import java.util.List;

import com.app.bookstore.exemplary.ExemplaryGetDTO;

public class BookWithExemplariesDTO {
	private Integer id;
	private String title;
	private Integer year;
	private Integer isbn;
	private List<ExemplaryGetDTO> exemplaries;

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

	public void setYear(Integer integer) {
		this.year = integer;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer integer) {
		this.isbn = integer;
	}

	public List<ExemplaryGetDTO> getExemplaries() {
		return exemplaries;
	}

	public void setExemplaries(List<ExemplaryGetDTO> exemplaries) {
		this.exemplaries = exemplaries;
	}
}
