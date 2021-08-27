package com.application.atm;

import java.util.List;

import com.application.bank.Account;

public class AtmTransactions 
{
	private AccountDispatcher dispatcher;

	public AtmTransactions(AccountDispatcher dispatcher) 
	{
		this.dispatcher = dispatcher;
	}

	public Account getAccount(int bankId,int accNo)
	{
		return dispatcher.getAccount(bankId, accNo);
	}

	public String withdraw(float ammount,Account acc,String atmName, Float totalAmmount)
	{
		if(ammount>0 && acc.getBalance()>=ammount)
		{
			acc.setBalance(acc.getBalance()-ammount);
			totalAmmount-=ammount;
			acc.addInPassBook("Withdrawn from  "+atmName+"	        	"+ammount +" 	    	" +acc.getBalance());
			return "1";
		}
		else
		{
			if(ammount<=0)
				return "Invalid input can not withdraw 0 or negative ammount";	
			else
				return "only "+acc.getBalance()+" in your account Can not withdraw "+ammount;
		}
	}

	public String transferMoney(float ammount,Account sender,Account receiver,String atmName)
	{
		if(ammount>0 && sender.getBalance()>=ammount)
		{
			sender.setBalance(sender.getBalance()-ammount);
			receiver.setBalance(receiver.getBalance()+ammount);
			sender.addInPassBook("transfered to "+receiver.getCode()+receiver.getAccNo()+" from "+atmName+" 		"+ammount +" 		" +sender.getBalance());
			receiver.addInPassBook("Received from "+sender.getCode()+sender.getAccNo()+" from "+atmName+ammount+"		 		" +receiver.getBalance());
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

	public List<String> miniStateMent(Account acc)
	{
		if(acc.getPassBook().size()<=5)
			return acc.getPassBook();
		else
		{
			int size=acc.getPassBook().size();
			return acc.getPassBook().subList(size-5,size);
		}
	}

}
