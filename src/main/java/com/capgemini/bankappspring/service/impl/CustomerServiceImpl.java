package com.capgemini.bankappspring.service.impl;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.bankappspring.entities.Customer;
import com.capgemini.bankappspring.exceptions.PasswordChangeFailedException;
import com.capgemini.bankappspring.exceptions.UpdationFailedException;
import com.capgemini.bankappspring.exceptions.UserNotFoundException;
import com.capgemini.bankappspring.repository.CustomerRepository;
import com.capgemini.bankappspring.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer authenticate(Customer customer)throws UserNotFoundException {
		try {
		return customerRepository.authenticate(customer);
		}catch (DataAccessException ex) {
			UserNotFoundException u = new UserNotFoundException("Customer not found");
			u.initCause(ex);
			throw u;
		}
		
	}

	@Override
	public Customer updateProfile(Customer customer)throws UpdationFailedException {
		try {
	return customerRepository.updateProfile(customer);
	}catch (DataAccessException e) {
		UpdationFailedException updationFailedException = new UpdationFailedException(
				"failed to update the customer details");
		updationFailedException.initCause(e);
		throw updationFailedException;
	}
}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) throws PasswordChangeFailedException{
	   try {
		return customerRepository.updatePassword(customer, oldPassword, newPassword);
	} catch (DataAccessException e) {
		PasswordChangeFailedException passwordChangeFailedException = new PasswordChangeFailedException(
				"Failed to change the password");
		passwordChangeFailedException.initCause(e);
		throw e;
	}
}


}