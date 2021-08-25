package com.application.bank;

import java.util.ArrayList;
import java.util.List;

public abstract class Bank 
{
	private int id;
	protected String code;
	public String getCode() {
		return code;
	}

	private String name;
	protected List<Account> accounts;
	public Bank(int id, String name) {
		accounts=new ArrayList<Account>();
		this.id = id;
		this.name = name;
	}
	
	public void addAccount(Account acc)
	{
		acc.setCode(this.code);
		accounts.add(acc);
		acc.setBankName(name);
		acc.setAccNo(getAccCount());
	}
	
	abstract public int getAccCount();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
