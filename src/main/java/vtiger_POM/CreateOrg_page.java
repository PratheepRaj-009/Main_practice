package vtiger_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric_utilities.WebdriverUtilities;

public class CreateOrg_page 
{
	//declaration
	@FindBy(name="accountname") private WebElement orgName_txtfld;
	
	@FindBy(id="email1") private WebElement email1_txt_fld;
	
	@FindBy(name="industry") private WebElement industry_DD;
	
	@FindBy(name="phone") private WebElement phone_txt_fld;
	
	@FindBy(xpath = "//img[@alt='Select']") private WebElement selectOrgLookup_btn;
	
	@FindBy(name = "search_text")private WebElement search_txtfld;
	
	@FindBy(name = "search") private WebElement search_btn;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement save_btn;
	
	//initialization
	public CreateOrg_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step:3 creating public service methods

	public WebElement getOrgName_txtfld() {
		return orgName_txtfld;
	}

	public WebElement getSearch_txtfld() {
		return search_txtfld;
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}

	public WebElement getOrgName_txt_field() {
		return orgName_txtfld;
	}

	public WebElement getEmail1_txt_fld() {
		return email1_txt_fld;
	}

	public WebElement getIndustry_DD() {
		return industry_DD;
	}

	public WebElement getPhone_txt_fld() {
		return phone_txt_fld;
	}

	public WebElement getSelectOrgLookup_btn() {
		return selectOrgLookup_btn;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}
	
	
	
	//business logics *******
	
	public void mandAndDDvalue(WebdriverUtilities wdu, String orgName,String DDvalue)
	{
		orgName_txtfld.sendKeys(orgName);
		wdu.selectByValue(industry_DD, DDvalue);
		
	}
	
	public void selectOrganization(WebdriverUtilities wdu,WebDriver driver,String exptitle,String orgName, String parentId) throws InterruptedException
	{
		selectOrgLookup_btn.click();
		wdu.switchToChildWindow(driver,exptitle);
		search_txtfld.sendKeys(orgName);
		search_btn.click();
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
