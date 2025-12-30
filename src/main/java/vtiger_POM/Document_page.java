package vtiger_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Document_page 
{
	//declaration
	@FindBy(xpath = "//img[@title='Create Document...']") private WebElement createDocLookup_btn;
	@FindBy(name="delete")private WebElement delete_btn;
	@FindBy(xpath = "//a[@title='Documents' and text()='Cusromer']/../preceding-sibling::td/input[@type='checkbox']") private List<WebElement> mulCheckbox;
	@FindBy(id="currentPageRec_selectall1") private WebElement allCheckBox;
	//initialization
	public Document_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//creating public service methods-getters
	public WebElement getCreateDocLookup_btn() {
		return createDocLookup_btn;
	}
	
	public WebElement getDelete_btn() {
		return delete_btn;
	}
	
	//business logic
	public void deleteSingleDocument(WebDriver driver,String expDocName)
	{
		driver.findElement(By.xpath("//a[@title='Documents' and text()='"+expDocName+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
		delete_btn.click();
		driver.switchTo().alert().accept();
		
	}
	public void deleteAllDocument()
	{
		allCheckBox.click();
		delete_btn.click();
		
	}
	
}
