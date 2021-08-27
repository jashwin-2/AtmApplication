package com.application.atm;

import java.util.HashMap;
import java.util.Map;

import com.application.bank.Account;

public class AccountDispatcher
{
	private Map<String,AtmBanking> banks;
	
	
	public AccountDispatcher() {
		this.banks = new HashMap<String,AtmBanking>();
	}


	public Account getAccount(String code,int number)
	{
		if(banks.containsKey(code))
			return banks.get(code).getAccountById(number);
		
		else
			return null;
	}
	
	public Account getAccount(String atmNo)
	{
		
		return null;
	}
	
	public void addBank(String code,AtmBanking bank)
	{
		banks.put(code, bank);
	}


	
}
