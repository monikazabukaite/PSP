package com.lab3.lab;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lab3.lab.model.User;
import com.lab3.lab.service.UserService;
import com.lab3.lab.service.ValidationService;

@SpringBootApplication
public class LabApplication implements CommandLineRunner {
	@Autowired
	private ValidationService validationService;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(validationService.validateEmail("namesurname@gmail.com"));
		System.out.println(validationService.validatePassword("Password123!"));
		System.out.println(validationService.validateLithuanianPhoneNumber("+37061234567"));

		System.out.print("Vartotojų sąrašas: ");
		userService.add(new User("Emilija", "Pavardaite", "+37062228574", "pavardaite@gmail.com", "Misko g. 11",
				"Emilija123!"));
		userService.add(
				new User("Rusne", "Pavardyte", "+37068420193", "pavardyte@gmail.com", "Vilniaus g. 31", "Rusne&12"));
		System.out.println(userService.getAllUsers());
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Pasirinkite veiksmą");
			System.out.println("1 - PRIDĖTI, 2 - REDAGUOTI, 3 - IŠTRINTI");
			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				System.out.println("Įveskite vardą: ");
				String name = scanner.nextLine();
				System.out.println("Įveskite pavardę: ");
				String surname = scanner.nextLine();
				System.out.println("Įveskite telefono numerį");
				String number = scanner.nextLine();
				System.out.println("Įveskite el. paštą: ");
				String email = scanner.nextLine();
				System.out.println("Įveskite adresą");
				String address = scanner.nextLine();
				System.out.println("Įveskite slaptažodį: ");
				String password = scanner.nextLine();

				if (validationService.validateEmail(email) && validationService.validatePassword(password)
						&& validationService.validateLithuanianPhoneNumber(number)) {
					userService.add(new User(name, surname, number, email, address, password));
					System.out.println("Pridėta!");
					System.out.print("Vartotojų sąrašas: ");
					System.out.println(userService.getAllUsers());
				} else
					System.out.println("Įvesti duomenys nėra korektiški!");
			}
			if (choice.equals("2")) {
				System.out.println(userService.getAllUsers());
				System.out.println("Kurio vartotojo informaciją norite redaguoti?");
				long id = Long.parseLong(scanner.nextLine());

				System.out.println("Įveskite vardą: ");
				String correctedName = scanner.nextLine();
				System.out.println("Įveskite pavardę: ");
				String correctedSurname = scanner.nextLine();
				System.out.println("Įveskite telefono numerį: ");
				String correctedNumber = scanner.nextLine();
				System.out.println("Įveskite el. paštą: ");
				String correctedEmail = scanner.nextLine();
				System.out.println("Įveskite adresą: ");
				String correctedAddress = scanner.nextLine();
				System.out.println("Įveskite slaptažodį: ");
				String correctedPassword = scanner.nextLine();

				if (validationService.validateEmail(correctedEmail)
						&& validationService.validatePassword(correctedPassword)
						&& validationService.validateLithuanianPhoneNumber(correctedNumber)) {
					userService.updateUser(id, new User(correctedName, correctedSurname, correctedNumber,
							correctedEmail, correctedAddress, correctedPassword));
					System.out.println("Atnaujinta!");
					System.out.print("Dabartinis vartotojų sąrašas: ");
					System.out.println(userService.getAllUsers());
				} else
					System.out.println("Įvesti duomenys nėra korektiški!");
			}
			if (choice.equals("3")) {
				System.out.println(userService.getAllUsers());
				System.out.println("Kurį vartotoją norite ištrinti?");
				long id = Long.parseLong(scanner.nextLine());
				userService.deleteUser(id);
				System.out.println("Ištrinta!");
				System.out.print("Dabartinis vartotojų sąrašas: ");
				System.out.println(userService.getAllUsers());
			}
		}
	}
}
