package com.application.bank;

public class TransactionDetails 
{
	
	private int transactionNo;
	private float ammount;
	private float currBalanceAfterTransaction;
	private String description;
	private String type;
	public TransactionDetails(float ammount, float currBalanceAfterTransaction, String description, String type) {
		this.ammount = ammount;
		this.currBalanceAfterTransaction = currBalanceAfterTransaction;
		this.description = description;
		this.type = type;
	}

	private Account reciver;
	
	
	
	public Account getReciver() {
		return reciver;
	}
	public void setReciver(Account reciver) {
		this.reciver = reciver;
	}
	
	public float getAmmount() {
		return ammount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}

	public int getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(int transactionNo) {
		this.transactionNo = transactionNo;
	}

	public float getCurrBalanceAfterTransaction() {
		return currBalanceAfterTransaction;
	}
}
