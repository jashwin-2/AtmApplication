package com.application.atm;

import com.application.bank.Account;
import com.application.bank.Bank;

public class Main {

	public static void main(String[] args)
	{
		Bank stateBank= new Bank("State Bank","SB");
		Bank hdfcBank= new Bank("HDFC","HD");
		Bank indianBank= new Bank("Indian Bank","IB");
		
		AccountDispatcher dispatcher= new AccountDispatcher();
		dispatcher.addBank(stateBank.getCode(),stateBank);
		dispatcher.addBank(hdfcBank.getCode(),hdfcBank);
		dispatcher.addBank(indianBank.getCode(),indianBank);

		Atm sbiAtm=getAtm(stateBank, "Chennai", 15000, dispatcher);
		Atm hdmiAtm=getAtm(hdfcBank, "Coimbatore", 15000, dispatcher);

		Account account1=new Account("Jashwin", 12000, 1234,173645635);
		Account account2=new Account("Ram", 12000, 1234,723646734);
		Account account3=new Account("kumar", 12000, 1234,651365327);
		Account account4=new Account("Kannan", 12000, 1234,17123123);
		Account account5=new Account("Kishore", 12000, 1234,723646734);
		Account account6=new Account("Ruban", 12000, 1237,651365327);

		stateBank.addAccount(account1);
		stateBank.addAccount(account2);
		hdfcBank.addAccount(account3);
		hdfcBank.addAccount(account4);
		indianBank.addAccount(account5);
		indianBank.addAccount(account6);

		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
		System.out.println(account4);
		System.out.println(account5);
		System.out.println(account6);
		while(true)
			sbiAtm.loginMenu();
	}

	public static Atm getAtm(Bank bank, String location , float initialAmmount ,AccountDispatcher dispatcher)
	{
		AtmDetails details=new AtmDetails(bank.getAtmCount(), location , initialAmmount, bank.getName(), bank.getCode());
		AtmServices service=new AtmServices(dispatcher,details);
		bank.setAtmCount(bank.getAtmCount()+1);
		return new Atm(details, service);
	}

}
