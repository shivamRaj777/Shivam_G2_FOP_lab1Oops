package com.gl.email.service;

import java.util.Random;

import com.gl.email.model.Employee;

public class CredentialServiceImpl implements CredentialService {
	String Capital_Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String Lower_Chars = "abcdefghijklmnopqrstuvwxyz";
	String numbers = "0123456789";
	String symbols = "!@#$%^&*_=+-/.?<>)";

	@Override
	public String generateEmailAddress(String firstName, String lastName, String department) {
		// TODO Auto-generated method stub
		return firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "abc.com";
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		String values = Capital_Chars + Lower_Chars + numbers + symbols;
		Random random = new Random();

		char[] password = new char[8]; // makes an empty char array
		for (int i = 0; i < 8; i++) {
			// use of charAt()method: to get character values
			// use of nextint()as it is scanning the value as int
			password[i] = values.charAt(random.nextInt(values.length()));
		}
		return String.valueOf(password);
	}

	@Override
	public void showCredentials(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Dear " + employee.getFirstName() + "your generated credentials are as follows");
		System.out.println("Email\t\t" + employee.getEmail());
		System.out.println("Password\t" + employee.getPassword());
	}

}
