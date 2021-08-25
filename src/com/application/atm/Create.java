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
		dispatcher.addBank(stateBank.getId(), (AtmBanking)stateBank);
		dispatcher.addBank(hdfcBank.getId(), (AtmBanking)hdfcBank);
		AtmTransactions tran=new AtmTransactions(dispatcher);
		
		Atm atm=new Atm("State BankAtm", 10000, tran);
		Account acc=new Account("Jashwin", 12000, 1234);
		Account acc1=new Account("ashwin", 12000, 1234);
		Account acc2=new Account("kumar", 12000, 1237);
		
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
