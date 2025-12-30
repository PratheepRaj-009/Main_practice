package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email_page 
{
	//declaration
	
	@FindBy(xpath="//a[text()='Compose']")private WebElement compose_link;
	@FindBy(xpath = "//a[contains(.,'Qualified M')]")private WebElement qualified_mails_link;
	@FindBy(xpath="//a[contains(.,'Incoming ')]")private WebElement incom_mail_settings_link;
	@FindBy(xpath="//a[contains(.,'All Mails')]")private WebElement all_mails_link;
	@FindBy(xpath="//a[contains(.,'To Contacts')]")private WebElement To_Contacts_link;
	@FindBy(xpath="//a[contains(.,'To Organizations')]")private WebElement To_Organizations_link;
	@FindBy(xpath="//a[contains(.,'To Leads')]")private WebElement To_Leads_link;
	@FindBy(xpath="//a[contains(.,'To Users')]")private WebElement To_Users_link;
	@FindBy(name="find")private WebElement find_btn;
	@FindBy(name="search_text")private WebElement search_txt_fld;
	@FindBy(xpath = "//select[@id='search_field']")private WebElement search_DD;
	//initialization
	
	public Email_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step:3 creating public service methods
	
	public WebElement getCompose_link() {
		return compose_link;
	}

	public WebElement getQualified_mails_link() {
		return qualified_mails_link;
	}

	public WebElement getIncom_mail_settings_link() {
		return incom_mail_settings_link;
	}

	public WebElement getAll_mails_link() {
		return all_mails_link;
	}

	public WebElement getTo_Contacts_link() {
		return To_Contacts_link;
	}

	public WebElement getTo_Organizations_link() {
		return To_Organizations_link;
	}

	public WebElement getTo_Leads_link() {
		return To_Leads_link;
	}

	public WebElement getTo_Users_link() {
		return To_Users_link;
	}

	public WebElement getFind_btn() {
		return find_btn;
	}

	public WebElement getSearch_txt_fld() {
		return search_txt_fld;
	}

	public WebElement getSearch_DD() {
		return search_DD;
	}
	
	
}
