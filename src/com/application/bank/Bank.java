package com.application.bank;

import java.util.ArrayList;
import java.util.List;

import com.application.atm.OnlineBank;

public class Bank implements OnlineBank
{
	private int accountCount;
	private int atmCount;
	protected String code;
	private String name;
	protected List<Account> accounts;


	public Bank(String name , String code) {
		accounts=new ArrayList<Account>();
		this.code=code;
		accountCount=1;
		setAtmCount(1);
		this.name = name;
	}

	public void addAccount(Account account)
	{
		account.setBankCode(this.code);
		accounts.add(account);
		account.setBankName(name);
		account.setAccNo(accountCount++);
		account.setAtmNumber(code+account.getAccNo());
	}

	@Override
	public Account getAccountById(int number) 
	{
		for(Account account : accounts)
			if(account.getAccNo()==number)
				return account;
		return null;
	}
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtmCount() {
		return atmCount;
	}

	public void setAtmCount(int atmCount) {
		this.atmCount = atmCount;
	}

}
