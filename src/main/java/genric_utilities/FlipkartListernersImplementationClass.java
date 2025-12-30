package genric_utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FlipkartListernersImplementationClass implements ITestListener, ISuiteListener
{

	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("isuite onStart is executed");
		
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		
		System.out.println("Isuite onFinish is executed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("onTestFailedButWithinSuccessPercentage is executed");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		System.out.println("onTestFailedWithTimeout is executed");
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("ItestListeners onTestStart onTestStart is executed");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
	
		System.out.println("onTestSuccess is executed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
	
		System.out.println("onTestFailure is executed");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
	
		System.out.println(" onTestSkipped is executed");
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("ItestListeners onStart is executed");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("ItestListeners onFinish is executed");
		
	}
	
}
