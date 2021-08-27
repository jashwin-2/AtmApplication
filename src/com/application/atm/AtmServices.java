package com.application.atm;

import java.util.List;

import com.application.bank.Account;
import com.application.bank.TransactionDetails;

public class AtmServices 
{
	private AccountDispatcher dispatcher;
	private AtmDetails details; 

	public AtmServices(AccountDispatcher dispatcher , AtmDetails details) 
	{
		this.details= details;
		this.dispatcher = dispatcher;
	}

	public Account getAccount(String atmNo)
	{
		return dispatcher.getAccount(atmNo);
	}
	
	public Account getAccount(String code,int accNo)
	{
		return dispatcher.getAccount(code , accNo);
	}

	public String withdraw(float ammount,Account acc)
	{
		
		if(ammount>0 && acc.getBalance()>=ammount)
		{
			acc.setBalance(acc.getBalance()-ammount);
			details.setTotalAmmount(details.getTotalAmmount()-ammount);
			acc.addTransactions(new TransactionDetails(ammount, acc.getBalance(), "Winthdrawn from "+details.getBankName(), "Debit"));
			return "The ammount "+ammount+" withdrawn succesfully \nCurrent Balance : "+acc.getBalance();
		}
		else
		{
			if(ammount<=0)
				return "Invalid input can not withdraw 0 or negative ammount";	
			else
				return "only "+acc.getBalance()+" in your account Can not withdraw "+ammount;
		}
	}

	public String transferMoney(float ammount,Account sender,Account receiver)
	{
		if(ammount>0 && sender.getBalance()>=ammount)
		{
			sender.setBalance(sender.getBalance()-ammount);
			receiver.setBalance(receiver.getBalance()+ammount);
			sender.addTransactions(new TransactionDetails(ammount, sender.getBalance(),"Transfered to "+receiver.getAccNo(), "Debit"));
			receiver.addTransactions(new TransactionDetails(ammount, sender.getBalance(),"Received from "+sender.getBankCode()+sender.getAccNo()+" from "+details.getBankName()+ammount, "Credit"));
			return "The ammount "+ammount+" transfered succesfully \nCurrent Balance : "+sender.getBalance();
		}
		else
		{
			if(ammount<=0)
				return "Invalid input can not withdraw 0 or negative ammount";	
			else
				return "only "+sender.getBalance()+" in your account Can not withdraw "+ammount;
		}
	}

	public List<TransactionDetails> miniStateMent(Account acc)
	{
		if(acc.getTransactions().size()<=5)
			return acc.getTransactions();
		else
		{
			int size=acc.getTransactions().size();
			return acc.getTransactions().subList(size-5,size);
		}
	}

}
