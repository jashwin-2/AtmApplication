package com.application.atm;

public enum CustomerOptions 
{
	CHANGE_MOBILE_NO;
	
	public String toString()
	{
		if(this.equals(CHANGE_MOBILE_NO))
			return "Change Mobile Number";
		return null;
	}
	
}
