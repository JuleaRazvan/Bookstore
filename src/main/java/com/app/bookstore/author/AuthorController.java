package com.app.bookstore.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AuthorMapper authorMapper;

	@PostMapping
	public ResponseEntity<AuthorGetDTO> createAuthor(@RequestBody AuthorCreateDTO authorCreateDTO) {
		Author author = authorService.create(authorMapper.authorCreateDTO2Author(authorCreateDTO));
		return new ResponseEntity<>(authorMapper.author2AuthorGetDTO(author), HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public List<Author> findAll() {
		return authorService.findAll();
	}
	
	@GetMapping("/name")
	public List<AuthorGetDTO> findByName(@RequestParam String name){
		return authorMapper.listAuhor2ListAuthorGetDTO(authorService.findByName(name));
	}

	@PutMapping("/{id}")
	public AuthorGetDTO update(@RequestBody AuthorCreateDTO authorCreateDTO, @PathVariable Integer id) {
		Author author = authorMapper.authorCreateDTO2Author(authorCreateDTO);
		Author updateAuthor = authorService.update(author, id);
		return authorMapper.author2AuthorGetDTO(updateAuthor);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		authorService.delete(id);
	}
}
