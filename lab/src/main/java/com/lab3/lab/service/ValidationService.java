package com.lab3.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab3.lab.library.EmailValidator;
import com.lab3.lab.library.PasswordChecker;
import com.lab3.lab.library.PhoneValidator;

@Service
public class ValidationService {

	public ValidationService() {
		// super();
	}

	@Autowired
	private EmailValidator emailValidator;
	@Autowired
	private PasswordChecker passwordChecker;
	@Autowired
	private PhoneValidator phoneValidator;

	public boolean validateEmail(String email) {
		return emailValidator.validateEmail(email);
	}

	public boolean validatePassword(String password) {
		return passwordChecker.validatePassword(password);
	}

	public boolean validateLithuanianPhoneNumber(String phoneNumber) {
		return phoneValidator.validateLithuanianPhoneNumber(phoneNumber);
	}

}
