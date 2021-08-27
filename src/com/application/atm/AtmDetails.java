package com.application.atm;

public class AtmDetails 
{
	private int atmId;
	private String location;
	private float totalAmmount;
	private String bankName;
	private String BankCode;
	
	public AtmDetails(int atmId, String location, float totalAmmount, String bankName, String bankCode)
	{
		this.atmId = atmId;
		this.location = location;
		this.totalAmmount = totalAmmount;
		this.bankName = bankName;
		BankCode = bankCode;
	}
	
	public String getLocation() {
		return location;
	}
	public float getTotalAmmount() {
		return totalAmmount;
	}
	public String getBankName() {
		return bankName;
	}
	public String getBankCode() {
		return BankCode;
	}
	public void setTotalAmmount(float amt) {
		this.totalAmmount=amt;
		
	}
	public int getAtmId() {
		return atmId;
	}
}
