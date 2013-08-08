package com.test.main.source;

public class MasterCard implements CreditCard
{

	@Override
	public boolean pay(Double amount)
	{
		System.out.print("MasterCard");
		return false;
	}

}
