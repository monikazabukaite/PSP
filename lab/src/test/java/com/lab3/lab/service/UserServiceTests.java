package com.lab3.lab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.lab3.lab.library.EmailValidator;
import com.lab3.lab.library.PasswordChecker;
import com.lab3.lab.library.PhoneValidator;
import com.lab3.lab.model.User;
import com.lab3.lab.repository.UserRepository;

public class UserServiceTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserService userService;

	private static User user;

	@BeforeAll
	public static void setup() {
		EmailValidator emailValidator = new EmailValidator();
		PhoneValidator phoneValidator = new PhoneValidator();
		PasswordChecker passwordChecker = new PasswordChecker();
		user = new User("Emilija", "Pavardyte", "+37062228574", "emilija@gmail.com", "Misko g. 11", "Emilija123!");
	}

	@Test
	void testAdd() {
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

		User added = userService.add(user);
		User expected = new User("Emilija", "Pavardyte", "+37062228574", "emilija@gmail.com", "Misko g. 11", "Emilija123!");
		verify(userRepository).save(Mockito.any(User.class));

		assertEquals(expected, added);
	}

	@Test
	void testGetAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(user);

		when(userRepository.findAll()).thenReturn(users);

		List<User> got = userService.getAllUsers();

		assertEquals(1, got.size());
	}

	@Test
	void testFindById() {
		when(userRepository.findById((long) Mockito.anyInt())).thenReturn(java.util.Optional.of(user));

		User found = userService.findById(1);

		assertEquals(user, found);
	}

	@Test
	void testDelete() {
		userService.deleteUser(1);

		((UserService) verify(userRepository)).deleteUser(Mockito.anyInt());
	}

}
