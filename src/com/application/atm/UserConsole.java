package com.application.atm;
import java.util.Map.Entry;
import java.util.Scanner;
import com.application.bank.Account;
import com.application.bank.TransactionDetails;
import com.application.bank.TransactionType;

public class UserConsole 
{
	protected AtmDetails details;
	private AtmServices services;
	protected Scanner sc;

	public UserConsole(AtmServices services,AtmDetails details) 
	{
		this.details=details;
		this.services = services;
		sc=new Scanner(System.in);
	}

	public void sessionManager(Account acc)
	{
		UserServiceType choice = null;
		do {
			printUserServices(acc);

			try {
				choice=UserServiceType.values()[Integer.parseInt(sc.nextLine())-1];
			}
			catch(ArrayIndexOutOfBoundsException excep)
			{
				System.out.println("Invalid input ");
			}

		}while(choice==null || serviceController(choice,acc));
	}


	protected void printUserServices(Account acc) {

		System.out.println("\n************* Customer Menu************\n");
		System.out.println("Name :"+acc.getAccHolderName()+"  Bank :"+acc.getBankName()+" Current Balance:"+acc.getBalance()+" Registered Mobile no : "+acc.getMobileNo());
		System.out.println("Enter your choice ");
		int ind=1;
		for(UserServiceType opt : UserServiceType.values())
			System.out.println(ind+++"--> "+opt);		

	}

	public boolean serviceController(UserServiceType choice,Account acc)
	{

		switch(choice)
		{
		case WITHDRAW:
			this.withdraw(acc);
			break;


		case MONEY_TRANSFER:
			this.moneyTransfer(acc);
			break;

		case MINI_STATEMENT:
			this.printMinistateMent(acc);
			break;

		case EXIT:
			System.out.println("******* Thanks for Banking With Us*******\n");
			return false;
		default:
			System.out.println("Invalid Input ");
		}
		return true;

	}

	public void withdraw(Account acc)
	{
		System.out.println("Enter the ammount you want to widhdraw");
		float ammount=Float.parseFloat(sc.nextLine());

		if(details.getTotalAmmount()>=ammount)
			System.out.println(services.withdraw(ammount,acc));
		else
			System.out.println("Not enough money in the ATM only "+details.getTotalAmmount()+" in the ATM");
	}

	public void moneyTransfer(Account acc)
	{
		Account receiver;
		String code = details.getBankCode();
		System.out.println("\nEnter your choice ");
		System.out.println("1 -->  To " + details.getBankName()+" Accounts \n2 --> To Other Bank Accounts");
		if(Integer.parseInt(sc.nextLine())==2)
		{
			printAvailbleBanksCode();
			System.out.println("PRESS Q To Cancel\nEnter receivers Bank Code \\ Q (Quit)");
			code=sc.nextLine();
			if(code.equalsIgnoreCase("Q"))
				return;
		}
		System.out.println("Enter receivers Account Number ");
		int accNo=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the ammount you want to transfer");
		float amt=Float.parseFloat(sc.nextLine());

		if((receiver=services.getAccount(code, accNo))!=null && receiver!=acc)
			System.out.println(services.transferMoney(amt, acc, receiver));
		else
			System.out.println("Invalid Input can not find the Account");
	}

	public void printMinistateMent(Account acc)
	{
		System.out.println("************* Mini StateMent **********");
		System.out.println("Description                 "+"     "+"     Credit Or  Debit "+"          "+"CurrBalance");
		for(TransactionDetails transaction : services.miniStateMent(acc))
		{
			if(transaction.getType().equals(TransactionType.WITHDRAW) || transaction.getType().equals(TransactionType.DEPOSITE))
				System.out.println(transaction.getType()+" from "+transaction.getSourceOfTransaction()+"        "+transaction.getAmmount()+"  "+transaction.getType().getResult()+"         "+transaction.getCurrBalanceAfterTransaction());
			else
				System.out.println(transaction.getType()+" "+transaction.getSenderOrReceiver().getBankCode()+transaction.getSenderOrReceiver().getAccNo()+" from "+transaction.getSourceOfTransaction()+"   "+transaction.getAmmount()+"  "+transaction.getType().getResult()+"         "+transaction.getCurrBalanceAfterTransaction());
		}
		System.out.println("*****************************************\n");
	}


	private void printAvailbleBanksCode()
	{
		System.out.println("*******Available Banks and Codes **********");
		System.out.println("Bank Name           Bank Code ");
		for(Entry<String, String> entry : services.getAvilableBanks().entrySet())
			if(!entry.getKey().equals(details.getBankCode()))
				System.out.println(entry.getValue()+"	--->  "+entry.getKey());
	}

}
