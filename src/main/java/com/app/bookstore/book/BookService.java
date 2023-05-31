package com.app.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book create(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	public Book findById(Integer id) {
		return bookRepository.findById(id).orElseThrow();
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public List<Book> findByName(String name) {
		return bookRepository.findByTitle(name);
	}

	public Book update(Book bookToUpdate, Integer id) {
		Book existingBook = bookRepository.findById(id).orElseThrow();
		existingBook.setTitle(bookToUpdate.getTitle());
		existingBook.setYear(bookToUpdate.getYear());
		existingBook.setIsbn(bookToUpdate.getIsbn());
		return bookRepository.save(existingBook);
	}

	public void delete(Integer id) {
		bookRepository.deleteById(id);
	}
}