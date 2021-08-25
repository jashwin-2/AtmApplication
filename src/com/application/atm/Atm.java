package com.application.atm;

import java.util.Scanner;

import com.application.bank.Account;

public class Atm 
{
	private String location;
	private float totalAmmount;
	private AtmTransactions transaction;
	public Atm(String location, float totalAmmount, AtmTransactions transaction)
	{
		this.location = location;
		this.totalAmmount = totalAmmount;
		this.transaction = transaction;
	}

	public void loginMenu()
	{
		int bankId,accNo;
		Account acc;
		Scanner sc=new Scanner(System.in);
		System.out.println("*********Login Menu**********\n");
		System.out.println("Enter your Account Number ");
		accNo=sc.nextInt();
		System.out.println("Enter your Bank Id ");
		bankId=sc.nextInt();
		if((acc=transaction.getAccount(bankId, accNo))!=null)
		{
			System.out.println("Enter your pin Number ");
			if(acc.getPin()==sc.nextInt())
				menu(acc);
			else
				System.out.println("Incorrect Pin number");

		}
		else
			System.out.println("Invalid Input can not find the Account");
		

	}
	public void menu(Account acc)
	{
		boolean cho=true;
		Scanner sc=new Scanner(System.in);
		while(cho)
		{
			System.out.println("\n************* Customer Menu************\n");
			System.out.println("Name :"+acc.getAccHolderName()+"  Bank :"+acc.getBankName()+" Current Balance:"+acc.getBalance());
			System.out.println("Enter your Choice 1.WithDraw   2.Tranfer Money   3.Mini StateMent   4.exit");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the ammount you want to widhdraw");
				float ammount=sc.nextFloat();
				if(totalAmmount>=ammount)
					System.out.println(transaction.withdraw(ammount, acc, location,this.totalAmmount));
				else
					System.out.println("Not enough money in the ATM only "+totalAmmount+" in the ATM");
				break;
			

			case 2:
				Account receiver;
				System.out.println("Enter the ammount you want to transfer");
				float amt=sc.nextFloat();
				System.out.println("Enter receivers Account Number ");
				int accNo=sc.nextInt();
				System.out.println("Enter receivers Bank Id");
				int bankId=sc.nextInt();

				if((receiver=transaction.getAccount(bankId, accNo))!=null)
					System.out.println(transaction.transferMoney(amt, acc, receiver, location));
				else
					System.out.println("Invalid Input can not find the Account");
				break;

			case 3:
			
				System.out.println("************* Mini StateMent **********");
				System.out.println("Description                 "+"     "+"   Credit "+"     "+"Debit "+"              "+"CurrBalance");
				for(String str : acc.getPassBook())
					System.out.println(str);
				System.out.println("*****************************************\n");
				break;
			
			case 4:
				System.out.println("******* Thanks for Banking With Us*******\n");
				cho = false;
				break;
			default:
				System.out.println("Invalid Input ");
			}
		}
	}
}
