package com.application.bank;

public class TransactionDetails 
{

	private int transactionNo;
	private float ammount;
	private float currBalanceAfterTransaction;
	private Account senderOrReceiver;
	private TransactionType type;
	private String sourceOfTransaction;
	
	public TransactionDetails(float ammount, float currBalanceAfterTransaction,TransactionType type, String source) {
		this.ammount = ammount;
		this.currBalanceAfterTransaction = currBalanceAfterTransaction;
		this.sourceOfTransaction=source;
		this.type = type;
	}
	
	public TransactionDetails(float ammount, float currBalanceAfterTransaction,TransactionType type,String source,Account acc) {
		this(ammount,currBalanceAfterTransaction,type,source);
		this.senderOrReceiver=acc;
	}	

	public float getAmmount() {
		return ammount;
	}

	public TransactionType getType() {
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
	public Account getSenderOrReceiver() {
		return senderOrReceiver;
	}
	public String getSourceOfTransaction() {
		return sourceOfTransaction;
	}
}
