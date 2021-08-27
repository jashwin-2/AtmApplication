package com.application.atm;

import com.application.bank.Account;

public interface OnlineBank 
{
	Account getAccountById(int id);
	String getName();
}
