package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_And_Logout_Vtiger 
{
	
	//step:1 declaration 
	@FindBy(name ="user_name" ) private WebElement UN_txt;
	@FindBy(name ="user_password" ) private WebElement PWD_txt;
	@FindBy(id ="submitButton" ) private WebElement login_btn;
	@FindBy(xpath = "//td[@class='genHeaderSmall']/following-sibling::td[@class='small']/img[@src='themes/softed/images/user.PNG']")private WebElement administrator_icon;
	@FindBy(xpath = "//a[text()='Sign Out']") private WebElement SignOut_link;
	//@FindBy(id ="submitButton" ) private WebElement login_btn;
	
	//step:2 initialization 
	
	public Login_And_Logout_Vtiger(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//step:3 utilization
	public WebElement getUN_txt() {
		return UN_txt;
	}
	
	public WebElement getPWD_txt() {
		return PWD_txt;
	}
	
	public WebElement getLogin_btn() {
		return login_btn;
	}

	public WebElement getAdministrator_icon() {
		return administrator_icon;
	}

	public WebElement getSignOut_link() {
		return SignOut_link;
	}
	public void login(String un, String pwd)
	{
		UN_txt.sendKeys(un);
		PWD_txt.sendKeys(pwd);
		login_btn.click();
	}
	public void signOut(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(administrator_icon).click().perform();
		SignOut_link.click();
		
	}


	
}
