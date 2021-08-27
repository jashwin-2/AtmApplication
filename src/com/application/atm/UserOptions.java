package com.application.atm;

public enum UserOptions {
	WITHDRAW,MONEY_TRANSFER,MINI_STATEMENT,EXIT;

	public String toString()
	{
		switch(this)
		{
		case WITHDRAW:
			return "WithDraw";
		case MONEY_TRANSFER:
			return "Money Transfer";
		case MINI_STATEMENT:
			return "Mini statement";
		case EXIT:
			return "Exit";
		}
		return null;
	}
}
