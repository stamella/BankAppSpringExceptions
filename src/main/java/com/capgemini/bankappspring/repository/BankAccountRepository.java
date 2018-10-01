package com.capgemini.bankappspring.repository;

import org.springframework.stereotype.Repository;

public interface BankAccountRepository {

	public double getBalance(long accountId);

	public boolean updateBalance(long accountId, double newBalance);

}