package vtiger_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric_utilities.WebdriverUtilities;

public class Logout_page extends WebdriverUtilities
{
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")private WebElement administrator_icon;
	
	@FindBy(xpath = "//a[text()='Sign Out']") private WebElement SignOut_link;
	
	public Logout_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAdministrator_icon() {
		return administrator_icon;
	}

	public WebElement getSignOut_link() {
		return SignOut_link;
	}
	
	//business logic 
	public void logoutJSE(WebDriver driver,WebdriverUtilities wdu) throws InterruptedException
	{
		
		administrator_icon.click();
		wdu.waitUntilElementTobeVisible(driver, SignOut_link);
		Thread.sleep(2000);
		//wdu.clickOnElementByJavaSvcript(driver, SignOut_link);
		movetoelementAndClick(driver, SignOut_link);
	}
	public void logoutNormal(WebDriver driver,WebdriverUtilities wdu) throws InterruptedException
	{
		
		movetoelement(driver, administrator_icon);
		//administrator_icon.click();
		wdu.waitUntilElementTobeVisible(driver, SignOut_link);
		Thread.sleep(2000);
		wdu.clickOnElementByJavaSvcript(driver, SignOut_link);
		//movetoelementAndClick(driver, SignOut_link);
	}
}
