package com.test.main.source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ValidateInvocationHandler implements InvocationHandler
{

	private static Map<Integer, String> map = new HashMap();
	static
	{
		map.put(MainClass.VISA, "com.test.main.source.Visa");
		map.put(MainClass.MASTER, "com.test.main.source.MasterCard");
		map.put(MainClass.MASTRO, "com.test.main.source.MastroCard");
		map = Collections.unmodifiableMap(map);
	}
	private int cardType;
	private int currency;
	public ValidateInvocationHandler(int cardType, int currency)
	{
		this.cardType = cardType;
		this.currency = currency;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable
	{
		String beanInterfaceName = method.getDeclaringClass().getSimpleName();
		System.out.println(beanInterfaceName);
		if (!checkifCurrencySupported(cardType, currency))
		{
			throw new Exception("Currency not Supported");
		}
		Class cardclass = Class.forName(map.get(cardType));
		return method.invoke(cardclass.newInstance(), arg);
	}

	private boolean checkifCurrencySupported(int cardType, int currency)
	{
		// Check if currecny suppored by card
		return true;
	}

}
