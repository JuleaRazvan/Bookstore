package com.app.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.bookstore.exemplary.ExemplaryMapper;

@Component
public class BookMapper {
	
	@Autowired
	private ExemplaryMapper exemplaryMapper;
	
	public Book bookCreateDTO2Book(BookCreateDTO bookCreateDTO) {
		Book book = new Book();
		book.setTitle(bookCreateDTO.getTitle());
		book.setYear(bookCreateDTO.getYear());
		book.setIsbn(bookCreateDTO.getIsbn());
		return book;
	}
	
	public BookGetDTO book2BookGetDTO(Book book) {
		BookGetDTO bookGetDTO = new BookGetDTO();
		bookGetDTO.setId(book.getId());
		bookGetDTO.setTitle(book.getTitle());
		bookGetDTO.setYear(book.getYear());
		bookGetDTO.setIsbn(book.getIsbn());
		return bookGetDTO;
	}
	
	public List<BookGetDTO> listBook2listGetDTO(List<Book> books){
		return books.stream()
				.map(book -> book2BookGetDTO(book))
				.toList();
	}
	
	public List<BookWithExemplariesDTO> bookList2BooksWithExemplariesDTO(List<Book> books){
		return books.stream()
				.map(book -> book2BookWithExemplariesDTO(book))
				.toList();
	}
	
	private BookWithExemplariesDTO book2BookWithExemplariesDTO(Book book) {
		BookWithExemplariesDTO bookGetDto = new BookWithExemplariesDTO();
		bookGetDto.setId(book.getId());
		bookGetDto.setIsbn(book.getIsbn());
		bookGetDto.setTitle(book.getTitle());
		bookGetDto.setYear(book.getYear());
		bookGetDto.setExemplaries(book.getExemplaries().stream()
				.map(exemplary -> exemplaryMapper.exemplary2ExemplaryGetDTO(exemplary))
				.toList());
		return bookGetDto;
	}
}
