package com.application.bank;

import java.util.ArrayList;
import java.util.List;

public class Account
{
	private int accNo;
	private String accHolderName;
	private float balance;
	private int pin;
	private String bankCode;
	private String bankName;
	private List<TransactionDetails> transactions;
	private int transactionCount;
	
	public Account(String accHolderName, float balance, int pin) 
	{
		transactions=new ArrayList<>();
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.pin = pin;
		this.transactionCount=1;
	}
	
	@Override
	public String toString() {
		return "acc No :"+accNo+" Name : "+accHolderName+" Bank Name "+this.bankName+" Bank Code :"+bankCode;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
	public List<TransactionDetails> getTransactions() 
	{
		return transactions;
	}

	public void addTransactions(TransactionDetails obj)
	{
		obj.setTransactionNo(transactionCount++);
		transactions.add(obj);
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
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBanCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCode() {
		
		return this.bankCode;
	}
	
}
