package com.application.atm;

import java.util.Scanner;

import com.application.bank.Account;

public class Atm 
{
	private AtmDetails details;
	private AtmServices services;

	public Atm(AtmDetails details, AtmServices services)
	{
		this.details=details;
		this.services = services;
	}

	public void loginMenu()
	{
		String atmNumber;
		Account acc;
		Scanner sc=new Scanner(System.in);
		System.out.println("*********Login Menu**********\n");
		System.out.println("Enter your Atm number Number ");	
		atmNumber=sc.nextLine();
		if((acc=services.getAccount(atmNumber))!=null)
		{
			System.out.println("Enter your pin Number ");
			if(acc.getPin()==sc.nextInt())
			{
				if(acc.getBankCode()!=this.details.getBankCode())
					new UserConsole(services , details).sessionManager(acc);
				else
					new CustomerConsole(services , details).sessionManager(acc);
			}
			else
				System.out.println("Incorrect Pin number");

		}
		else
			System.out.println("Invalid Input can not find the Account");


	}

}
