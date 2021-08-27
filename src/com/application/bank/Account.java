package com.application.bank;

import java.util.ArrayList;
import java.util.List;

public class Account
{
	private int accNo, pin;
	private String accHolderName,bankCode,bankName;
	private float balance;
	private String atmNumber;
	private long mobileNo;
	private List<TransactionDetails> transactions;
	private int transactionCount;
	
	public Account(String accHolderName, float balance, int pin ,long mobileNo) 
	{
		this.setMobileNo(mobileNo);
		transactions=new ArrayList<>();
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.pin = pin;
		this.transactionCount=1;
	}
	
	@Override
	public String toString() {
		return "acc No :"+accNo+" Name : "+accHolderName+" Bank Name "+this.bankName+" Bank Code :"+bankCode+" Mobile No :" +"Atm Number : "+atmNumber;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
	public String getAtmNumber() {
		return atmNumber;
	}

	public void setAtmNumber(String atmNumber) {
		this.atmNumber = atmNumber;
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
	
	public int getAccNo() {
		return accNo;
	}
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
