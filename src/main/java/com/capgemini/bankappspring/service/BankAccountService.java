package com.capgemini.bankappspring.service;

import org.springframework.stereotype.Service;

import com.capgemini.bankappspring.exceptions.LowBalanceException;

public interface BankAccountService {

	public double getBalance(long accountId);

	public double withdraw(long accountId, double amount) throws LowBalanceException;

	public double deposit(long accountId, double amount);

	public boolean fundTransfer(long fromAccount, long toAccount, double balance) throws LowBalanceException;

}
