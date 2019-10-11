package com;

import co.paralleluniverse.common.util.CheckedCallable;
import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.FiberAsync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2
{
	static ExecutorService executorService=Executors.newFixedThreadPool(2);
	static  CountDownLatch c=new CountDownLatch(1);
	public static void main(String[] args) throws InterruptedException
	{
		
		Str foo=foo();
		
		System.out.println(foo.a +"  ===== 1");
		//c.await();
		System.out.println(foo.a +"  ===== 2");
		c.await();
	}
	public static Str foo(){
		Str str = new Str();
		str.a ="bcd";
		new Fiber<String>(()->
		{
			
			System.out.println(123421);
			try
			{
				str.a = str.a+"ccc";
				//c.countDown();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}).start();
		
		System.out.println(123);

		return str;
	}
	private static class Str{
		String a ;
	}
}
