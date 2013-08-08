package com.test.main.source;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass
{
	public static final int VISA = 0;
	public static final int MASTER = 1;
	public static final int MASTRO = 2;

	public static final int USD = 0;
	public static final int INR = 1;

	public static CreditCard getCreditCard(int card, int currency)
	{
		ValidateInvocationHandler handler = new ValidateInvocationHandler(card, currency);
		return (CreditCard) Proxy.newProxyInstance(MainClass.class.getClassLoader(), new Class[] { CreditCard.class }, handler);
	}

	public static void proxyProgram()
	{
		Double amount = 112.0;
		CreditCard creditCard = getCreditCard(VISA, USD);
		boolean isPaymentSuccess = creditCard.pay(amount);
		System.out.println();
		if (!isPaymentSuccess)
		{
			System.out.print("Payment Not Success");
		}
		else
		{
			System.out.print("Payment Success");
		}
	}

	public static void main(String[] args) throws Exception
	{
		proxyProgram();
	}

}
