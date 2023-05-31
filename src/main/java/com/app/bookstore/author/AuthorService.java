package com.app.bookstore.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	public Author create(Author author) {
		return authorRepository.saveAndFlush(author);
	}

	public Author update(Author authorUpdate, Integer Id) {
		Author existingAuthor = authorRepository.findById(Id).orElseThrow();
		existingAuthor.setName(authorUpdate.getName());
		existingAuthor.setBirthDate(authorUpdate.getBirthDate());
		existingAuthor.setDeathDate(authorUpdate.getDeathDate());
		existingAuthor.setGender(authorUpdate.getGender());
		existingAuthor.setNationality(authorUpdate.getNationality());
		return authorRepository.save(existingAuthor);
	}

	public void delete(Integer id) {
		authorRepository.deleteById(id);
	}

	public List<Author> findByName(String name) {
		return authorRepository.findByName(name);
	}
}
