package com.test.main.source;

public class Visa implements CreditCard
{

	@Override
	public boolean pay(Double amount)
	{
		System.out.print("Visa");
		return false;
	}

}
