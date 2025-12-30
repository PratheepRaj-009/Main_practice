package practice;

import org.testng.annotations.Test;

public class DataProvider2_Test 
{
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "storedata")
	public void testing(String ToolName,String TestType)
	{
		System.out.println(ToolName+"  "+TestType);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "Softwares")
	public void getSubject(String sftwre, String version)
	{
		System.out.println(sftwre+" "+version);
	}
}
