package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page 
{
	//step:1 declaration
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']") private WebElement home_btn;
	
	@FindBy(xpath="//a[text()='Calendar']") private WebElement calendar_btn;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Organizations']")private WebElement Org_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Contacts']")private WebElement contacts_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Opportunities']")private WebElement opportunities_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Products']")private WebElement products_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Documents']")private WebElement doc_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Email']")private WebElement email_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Trouble Tickets']")private WebElement tTicket_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Dashboard']")private WebElement dashboard_link;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Leads']")private WebElement leads_link;
	
	@FindBy(className ="searchBox") private WebElement search_txt_fld;
	
	@FindBy(xpath = "//img[@src='themes/images/arrow_down_black.png']") private WebElement unified_search_DD;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement admin_icon;
	
	@FindBy(xpath = "//a[text()='My Preferences']") private WebElement myPreferance_link;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/info.PNG']") private WebElement info_btn;
	
	@FindBy(xpath = "//a[text()='More']") private WebElement more_link;
	
	@FindBy(xpath = "//a[text()='Recycle Bin']")private WebElement recycleBin_link;
	
	@FindBy(id="qccombo") private WebElement quickk_create;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/mainSettings.PNG']") private WebElement settings_icon;
	
	@FindBy(xpath = "//a[text()='CRM Settings']") private WebElement crm_settings_link;
	
	@FindBy(xpath = "//a[text()='Sign Out']") private WebElement Sign_Out_link;
	
	//step:2 initialization 
	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step:3 creating public service methods
	
	public WebElement getHome_btn() {
		return home_btn;
	}

	public WebElement getCalendar_btn() {
		return calendar_btn;
	}

	public WebElement getOrg_link() {
		return Org_link;
	}

	public WebElement getContacts_link() {
		return contacts_link;
	}

	public WebElement getOpportunities_link() {
		return opportunities_link;
	}

	public WebElement getProducts_link() {
		return products_link;
	}

	public WebElement getDoc_link() {
		return doc_link;
	}

	public WebElement getEmail_link() {
		return email_link;
	}

	public WebElement gettTicket_link() {
		return tTicket_link;
	}

	public WebElement getDashboard_link() {
		return dashboard_link;
	}

	public WebElement getLeads_link() {
		return leads_link;
	}

	public WebElement getSearch_txt_fld() {
		return search_txt_fld;
	}

	public WebElement getUnified_search_DD() {
		return unified_search_DD;
	}

	public WebElement getAdmin_icon() {
		return admin_icon;
	}

	public WebElement getInfo_btn() {
		return info_btn;
	}

	public WebElement getMore_link() {
		return more_link;
	}

	public WebElement getQuickk_create() {
		return quickk_create;
	}

	public WebElement getSettings_icon() {
		return settings_icon;
	}

	public WebElement getCrm_settings_link() {
		return crm_settings_link;
	}

	public WebElement getSign_Out_link() {
		return Sign_Out_link;
	}
	
	
	//Business logic
	
	public void clickHome()
	{
		home_btn.click();
	}
	
	public void clickCzlendarBtn()
	{
	calendar_btn.click();
	}
	
	public void clickOrg()
	{
		Org_link.click();
	}
	
	public void clickContat()
	{
	contacts_link.click();
	}
	public void opportunities()
	{
		opportunities_link.click();
	}
	public void clickAdmin()
	{
		admin_icon.click();
	}
	
	public void product_link()
	{
		products_link.click();
		
	}
	
	public void mypreferance()
	{
		admin_icon.click();
		myPreferance_link.click();
	}
	public void clickOnCrmSetting()
	{
		settings_icon.click();
		crm_settings_link.click();
		
	}
	
	public void clickOnDocLink()
	{
		doc_link.click();
	}
	
}
