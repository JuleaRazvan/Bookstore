package com.app.bookstore.author;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
	public Author authorCreateDTO2Author(AuthorCreateDTO authorCreateDTO) {
		Author author = new Author();
		author.setName(authorCreateDTO.getName());
		author.setBirthDate(authorCreateDTO.getBirthDate());
		author.setDeathDate(authorCreateDTO.getDeathDate());
		author.setGender(authorCreateDTO.getGender());
		author.setNationality(authorCreateDTO.getNationality());

		return author;
	}

	public AuthorGetDTO author2AuthorGetDTO(Author author) {
		AuthorGetDTO authorGetDTO = new AuthorGetDTO();
		authorGetDTO.setId(author.getId());
		authorGetDTO.setName(author.getName());
		authorGetDTO.setBirthDate(author.getBirthDate());
		authorGetDTO.setDeathDate(author.getDeathDate());
		authorGetDTO.setGender(author.getGender());
		authorGetDTO.setNationality(author.getNationality());

		return authorGetDTO;
	}
	
	public List<AuthorGetDTO> listAuhor2ListAuthorGetDTO(List<Author> authors){
		return authors.stream()
				.map(author -> author2AuthorGetDTO(author))
				.toList();
	}
}
