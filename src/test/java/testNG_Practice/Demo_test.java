package testNG_Practice;

import org.testng.annotations.Test;

import genric_utilities.BaseClass;

public class Demo_test extends BaseClass
{
	@Test (groups = "smoke")
	public void demo1()
	{
		System.out.println("testing demo 1");
	}
	
	@Test(groups = "regional")
	public void demo2()
	{
		System.out.println("testing demo 2");
	}
	@Test (groups = "smoke")
	public void demo3()
	{
		System.out.println("im demo 3");
	}
}
