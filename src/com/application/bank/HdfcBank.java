package com.application.bank;

import com.application.atm.AtmBanking;

public class HdfcBank extends Bank implements AtmBanking
{

	public HdfcBank(int id) {
		super(id, " Hdfc Bank ");
		code="HD";
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
