package testNG_Practice;

import org.testng.annotations.Test;

import genric_utilities.BaseClass;

public class Disp_test extends BaseClass
{
	@Test(groups = "smoke")
	public void disp1()
	{
		System.out.println("testing disp1");
	}
	@Test(groups = "regional", invocationCount = 2)
	public void disp2()
	{
		System.out.println("testing disp2");
	}
	
}
