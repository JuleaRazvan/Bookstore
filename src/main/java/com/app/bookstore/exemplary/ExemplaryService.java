package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.book.Book;
import com.app.bookstore.book.BookRepository;

@Service
public class ExemplaryService {
	
	@Autowired
	private ExemplaryRepository exemplaryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Exemplary create(Exemplary exemplary, Integer bookId) {
		Book book = bookRepository.findById(bookId).orElseThrow();
		book.addExemplary(exemplary);
		return exemplaryRepository.saveAndFlush(exemplary);
	}

	public Exemplary findById(Integer id) {
		return exemplaryRepository.findById(id).orElseThrow();
	}
	
	public List<Exemplary> findAll(){
		return exemplaryRepository.findAll();
	}
	
	public Exemplary update(Exemplary exemplaryUpdate, Integer Id) {
		Exemplary existingExemplary = exemplaryRepository.findById(Id).orElseThrow();
		existingExemplary.setDate(exemplaryUpdate.getDate());
		existingExemplary.setCode(exemplaryUpdate.getCode());
		existingExemplary.setPageNumber(exemplaryUpdate.getPageNumber());
		return exemplaryRepository.save(existingExemplary);
	}
	
	public void delete(Integer id) {
		// caz: orphan removal
//		Exemplary exemplary = exemplaryRepository.findById(id).orElseThrow();
//		Book book = bookRepository.findById(3).orElseThrow();
//		book.removeExemplary(exemplary);
//		bookRepository.flush();
		exemplaryRepository.deleteById(id);
	}
}
