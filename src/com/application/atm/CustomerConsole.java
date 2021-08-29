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
		UserServiceType choice = null;
		int userInput=0 , userOptionsCount = UserServiceType.values().length;
		do {
			printUserOptions(acc);
			printUserOptions();
			userInput=Integer.parseInt(sc.nextLine());

			if(userInput <= userOptionsCount)
			{
				choice = UserServiceType.values()[userInput-1];
				if(!super.serviceController(choice, acc))
					return;
				choice = null;
			}

			else if(userInput <= userOptionsCount + CustomerServiceType.values().length)
				serviceController(CustomerServiceType.values()[userInput-userOptionsCount-1],acc);
			else
				System.out.println("Invalid input ");

		}while(choice==null || serviceController(choice,acc));
	}

	private void serviceController(CustomerServiceType choice, Account acc) 
	{
		if(choice.equals(CustomerServiceType.CHANGE_MOBILE_NO))	
		{
			System.out.println("Enter your new mobile number");
			acc.setMobileNo(Long.parseLong(sc.nextLine()));
		}
	}

	private void printUserOptions() {
		int ind = UserServiceType.values().length+1;
		for(CustomerServiceType option : CustomerServiceType.values())
			System.out.println(ind+"--> "+option);
	}
}
