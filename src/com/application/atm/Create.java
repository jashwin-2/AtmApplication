package com.application.atm;

import com.application.bank.Account;
import com.application.bank.Bank;
import com.application.bank.HdfcBank;
import com.application.bank.StateBank;

public class Create {

	public static void main(String[] args)
	{
		Bank stateBank= new StateBank(1);
		Bank hdfcBank= new HdfcBank(2);
		AccountDispatcher dispatcher= new AccountDispatcher();
		dispatcher.addBank(stateBank.getCode(), (AtmBanking)stateBank);
		dispatcher.addBank(hdfcBank.getCode(), (AtmBanking)hdfcBank);
		
		AtmDetails details=new AtmDetails(1, "Chennai", 15000, stateBank.getName(), stateBank.getCode());
		AtmServices tran=new AtmServices(dispatcher,details);
		Atm atm=new Atm(details,tran);
		Account acc=new Account("Jashwin", 12000, 1234,173645635);
		Account acc1=new Account("ashwin", 12000, 1234,723646734);
		Account acc2=new Account("kumar", 12000, 1237,651365327);
		
		stateBank.addAccount(acc);
		hdfcBank.addAccount(acc1);
		hdfcBank.addAccount(acc2);
		System.out.println(acc);
		System.out.println(acc1);
		System.out.println(acc2);
		while(true)
			atm.loginMenu();
	}

}
