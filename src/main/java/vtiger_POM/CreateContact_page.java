package vtiger_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric_utilities.WebdriverUtilities;

public class CreateContact_page 
{
	@FindBy(xpath = "//input[@name='lastname']") private WebElement lastName_Txtfld;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement save_btn;
	@FindBy(xpath = "//input[@id='search_txt']") private WebElement search_txtfld;
	@FindBy(xpath = "//img[@alt='Select']") private WebElement selectOrgLookup_btn;
	
	
	
	public CreateContact_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastName_Txtfld() {
		return lastName_Txtfld;
	}
	

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getSearch_txtfld() {
		return search_txtfld;
	}

	public WebElement getSelectOrgLookup_btn() {
		return selectOrgLookup_btn;
	}
	
	public void enterValueIntoTextfield(String lastName, WebDriver driver)
	{
		lastName_Txtfld.sendKeys(lastName);
	//	save_btn.click();
//		WebdriverUtilities wdu = new WebdriverUtilities();
//		wdu.waitUntilTheElementIsDisappear(driver,save_btn);
	}
	public void selectOrganization(WebdriverUtilities wdu,WebDriver driver,String exptitle,String orgName, String parentId) throws InterruptedException
	{
		selectOrgLookup_btn.click();
		wdu.switchToChildWindow(driver,exptitle);
		search_txtfld.sendKeys(orgName,Keys.ENTER);
		//search_btn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		try
		{
		driver.switchTo().alert().accept();
		wdu.switchToParentWindow(driver, parentId);
		}
		catch (Exception e) 
		{	
			
			wdu.switchToParentWindow(driver, parentId);
		}
	}
	public void save(WebDriver driver)
	{
		
		save_btn.click();
//		WebdriverUtilities wdu = new WebdriverUtilities();
//		wdu.waitUntilTheElementIsDisappear(driver, save_btn);
	}
	
}
