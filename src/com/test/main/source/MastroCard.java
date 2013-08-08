package com.test.main.source;

public class MastroCard implements CreditCard
{

	@Override
	public boolean pay(Double amount)
	{
		System.out.print("MastroCard");
		return false;
	}

}
