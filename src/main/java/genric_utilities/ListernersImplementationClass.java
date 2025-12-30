 package genric_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernersImplementationClass implements ITestListener
{
	
	ExtentReports report;
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result)
	{
		
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		extentTest.set(test);
		extentTest.get().log(Status.INFO, methodName+"Execution Starts");
		//Reporter.log(methodName+"--onstart");
	}

	@Override
	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
	
		extentTest.get().log(Status.PASS, methodName+"Execution Success");
		// 
		//000Reporter.log(methodName+"--pass");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName);
		String filename = methodName+new javautils().systemdate();
		
		try {
		TakesScreenshot ts=(TakesScreenshot) BaseClass.wdriver.get();
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(".\\Screenshot\\"+filename+".png");
		
		
			FileUtils.copyFile(temp, perm);
			String path = perm.getAbsolutePath();
			extentTest.get().addScreenCaptureFromPath(path);
			
			extentTest.get().log(Status.FAIL, result.getThrowable());
			extentTest.get().log(Status.FAIL,methodName+"---->failed");
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"---->Skipped");
		
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		//creating the report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReport\\report."+new javautils().systemdate()+".html");
		htmlReport.config().setDocumentTitle("TP-30");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTiger");
		
		// passing the data into the report
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser: ", "Chrome");
		
		report.setSystemInfo("Base platform: ", "windows");
		report.setSystemInfo("Base Url: ", "http://localhost:8888");
		report.setSystemInfo("Reporter Name: ", "Raj.S");
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}
