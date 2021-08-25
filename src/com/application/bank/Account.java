package com.application.bank;

import java.util.ArrayList;
import java.util.List;

public class Account
{
	private int accNo;
	private String accHolderName;
	private float balance;
	private int pin;
	private String code;
	private int bankId;
	private String bankName;
	private List<String> passBook;
	
	public Account(String accHolderName, float balance, int pin) 
	{
		passBook=new ArrayList<>();
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.pin = pin;
	}
	
	@Override
	public String toString() {
		return "acc No :"+accNo+" Name : "+accHolderName+" Bank Name "+this.bankName+" Bank Id :"+bankId;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public void addInPassBook(String str)
	{
		passBook.add(str);
	}
	
	public String getAccHolderName() {
		return accHolderName;
	}
	
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getAccNo() {
		return accNo;
	}
	public List<String> getPassBook() {
		return passBook;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
}
