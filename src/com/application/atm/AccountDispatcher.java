package com.application.atm;

import java.util.HashMap;
import java.util.Map;

import com.application.bank.Account;

public class AccountDispatcher
{
	private Map<Integer,AtmBanking> banks;
	
	
	public AccountDispatcher() {
		this.banks = new HashMap<Integer,AtmBanking>();
	}


	public Account getAccount(int id,int number)
	{
		if(banks.containsKey(id))
			return banks.get(id).getAccountById(number);
		
		else
			return null;
	}
	
	public void addBank(int id,AtmBanking bank)
	{
		banks.put(id, bank);
	}
}
