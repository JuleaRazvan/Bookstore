package com.app.bookstore.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User update(User userToUpdate, Integer userId) {
		User existingUser = userRepository.findById(userId).orElseThrow();
		existingUser.setFirstName(userToUpdate.getFirstName());
		existingUser.setLastName(userToUpdate.getLastName());
		existingUser.setAge(userToUpdate.getAge());
		existingUser.setEmail(userToUpdate.getEmail());
		
		return userRepository.save(existingUser);
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	
	public List<User> findByFirstName(String firstName){
		return userRepository.findByFirstName(firstName);
	}

}