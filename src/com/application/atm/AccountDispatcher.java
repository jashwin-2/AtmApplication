package com.application.atm;
import java.util.HashMap;
import java.util.Map;
import com.application.bank.Account;

public class AccountDispatcher
{
	private Map<String,OnlineBank> banks;


	public AccountDispatcher() {
		this.banks = new HashMap<String,OnlineBank>();
	}

	public Account getAccount(String code,int number)
	{
		if(banks.containsKey(code))
			return banks.get(code).getAccountById(number);

		else
			return null;
	}

	public Account getAccount(String atmNo)
	{ 
		try {
			String code="";
			int i=0;
			while(!Character.isDigit(atmNo.charAt(i)))
				code=code+atmNo.charAt(i++);
			return getAccount(code , Integer.parseInt(atmNo.substring(i, atmNo.length())) );
		}
		catch(Exception exception)
		{
			return null;
		}
	}

	public void addBank(String code,OnlineBank bank)
	{
		banks.put(code, bank);
	}

	public Map<String, OnlineBank> getBanks() {
		return banks;
	}

}
