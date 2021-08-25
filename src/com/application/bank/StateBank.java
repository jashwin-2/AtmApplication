package com.application.bank;

import com.application.atm.AtmBanking;

public class StateBank extends Bank implements AtmBanking
{
	static int accCount=1;
	public StateBank(int id) {
		super(id, "State Bank ");
		code="SB";
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
