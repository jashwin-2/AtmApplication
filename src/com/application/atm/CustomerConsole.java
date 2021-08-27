package com.application.atm;

import com.application.bank.Account;

public class CustomerConsole extends UserConsole
{
	public CustomerConsole(AtmServices services, AtmDetails details)
	{
		super(services, details);

	}

	public void sessionManager(Account acc)
	{
		UserOptions choice = null;
		int userInput=0 , userOptionsCount = UserOptions.values().length;
		do {
			printUserOptions(acc);
			printUserOptions();
			userInput=Integer.parseInt(sc.nextLine());

			if(userInput <= userOptionsCount)
			{
				choice = UserOptions.values()[userInput-1];
				if(!super.serviceController(choice, acc))
					return;
				choice = null;
			}

			else if(userInput <= userOptionsCount + CustomerOptions.values().length)
				serviceController(CustomerOptions.values()[userInput-userOptionsCount-1],acc);
			else
				System.out.println("Invalid input ");

		}while(choice==null || serviceController(choice,acc));
	}

	private void serviceController(CustomerOptions choice, Account acc) 
	{
		sc.nextLine();
		if(choice.equals(CustomerOptions.CHANGE_MOBILE_NO))	
		{
			System.out.println("Enter your new nmwe");
			acc.setAccHolderName(sc.nextLine());
		}
	}

	private void printUserOptions() {
		int ind = UserOptions.values().length+1;
		for(CustomerOptions option : CustomerOptions.values())
			System.out.println(ind+"--> "+option);
	}
}
