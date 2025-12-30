package practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer
{
	int initialCount=0;
	int upperCount=3;
	@Override
	public boolean retry(ITestResult result) 
	{
		if(initialCount<upperCount)
		{
			initialCount++;
			return true;
		}
		
		return false;
	}
	
}
