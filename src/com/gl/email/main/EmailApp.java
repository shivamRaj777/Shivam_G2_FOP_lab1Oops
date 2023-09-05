package com.gl.email.main;

import com.gl.email.service.CredentialServiceImpl;

import java.util.Scanner;

import com.gl.email.model.Employee;
import com.gl.email.service.CredentialService;

public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CredentialService service = new CredentialServiceImpl();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter First Name");
		String firstName = in.next();
		System.out.println("Enter Last Name");
		String lastName = in.next();

		Employee employee = new Employee(firstName, lastName);
		System.out.println("Please Enter the department from the following ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		int option = in.nextInt();
		String department = ""; // for storing the department prefixes
		switch (option) {
		case 1:
			department = "tech";
			break;
		case 2:
			department = "ad";
			break;
		case 3:
			department = "hr";
			break;
		case 4:
			department = "lg";
			break;
		default:
			System.out.println("please enter the Correct Choice....:");
		}
		String email = service.generateEmailAddress(firstName, lastName, department);
		employee.setEmail(email);

		String password = service.generatePassword();
		employee.setPassword(password);

		service.showCredentials(employee);

	}

}
