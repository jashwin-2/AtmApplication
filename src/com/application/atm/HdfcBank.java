package com.application.atm;

import com.application.bank.Account;
import com.application.bank.Bank;

public class HdfcBank extends Bank implements AtmBanking
{

	private static int accCount=1;

	public HdfcBank(int id) {
		super(id, " Hdfc Bank ");
		code="HD";
	}
	
	public int getAccCount()
	{
		return accCount++;
	}
	
	@Override
	public Account getAccountById(int number) 
	{
		for(Account acc : accounts)
			if(acc.getAccNo()==number)
				return acc;
		return null;
	}

}
