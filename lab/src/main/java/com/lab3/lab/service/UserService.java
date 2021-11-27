package com.lab3.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab3.lab.model.User;
import com.lab3.lab.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User add(User user) {
		return repository.save(user);
	}

	public List<User> getAllUsers() {
		return (List<User>) repository.findAll();
	}

	public User findById(long id) {
		return repository.findById(id).get();
	}

	public void deleteUser(long id) {
		repository.deleteById(id);
	}

	public User updateUser(long id, User user) {
		User newUser = repository.findById(id).get();
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setAddress(user.getAddress());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		return repository.save(newUser);
	}

}
