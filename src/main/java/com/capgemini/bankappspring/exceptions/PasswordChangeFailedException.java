package com.capgemini.bankappspring.exceptions;

public class PasswordChangeFailedException extends RuntimeException {
	
	public PasswordChangeFailedException(String message) {
		
		super(message);
		
	}

}
