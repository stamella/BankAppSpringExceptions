package com.capgemini.bankappspring.service;

import com.capgemini.bankappspring.entities.Customer;
import com.capgemini.bankappspring.exceptions.PasswordChangeFailedException;
import com.capgemini.bankappspring.exceptions.UpdationFailedException;
import com.capgemini.bankappspring.exceptions.UserNotFoundException;

public interface CustomerService {

	public Customer authenticate(Customer customer) throws UserNotFoundException;
	public Customer updateProfile(Customer customer)throws UpdationFailedException;
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword)throws PasswordChangeFailedException;

}