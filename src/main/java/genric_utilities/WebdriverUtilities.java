package genric_utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtilities 
{
	
	//WebDriverWait ew =null;
	
//	public WebDriver launchBrowser(WebDriver driver,String Browser)
//	{
//		ChromeOptions chromeoptions = new ChromeOptions();
//		chromeoptions.addArguments("--disable-notification");
//		EdgeOptions edgoptions = new EdgeOptions();
//		edgoptions.addArguments("--disable-notification");
//		FirefoxOptions fireoptions = new FirefoxOptions();
//		fireoptions.addArguments("--disable-notification");
//		if(Browser.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver(chromeoptions);
//		}
//		if(Browser.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver(edgoptions);
//		}
//		if(Browser.equalsIgnoreCase("firefox"))
//		{
//			driver=new FirefoxDriver(fireoptions);
//		}
//		return driver;
//	}
	/**
	 * it is used to maximize the window
	 * @author PRATHEEP RAJ S
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to implicit wait
	 * @param driver
	 * @param sec
	 */
	public void implicitWait(WebDriver driver,Duration sec)
	{
		driver.manage().timeouts().implicitlyWait(sec);
	}
	
	/**
	 * object creation of webDriverWait
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param elem
	 * @param sec
	 * @return 
	 */
	public WebDriverWait explicitWait(WebDriver driver)
	{
		WebDriverWait ew = new WebDriverWait(driver, Duration.ofSeconds(20));
		return ew;
	}
	public void ew_VisibilityOfElement(WebDriver driver, WebElement elem, Duration sec)
	{
		//WebDriverWait ew = new WebDriverWait(driver,sec);
		explicitWait(driver).until(ExpectedConditions.visibilityOf(elem));
	}
	/**
	 * it will wait until the element is clickable
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param elem
	 * @param sec
	 */
	public void waitUntilTheElementIsDisappear(WebDriver driver, WebElement element)
	{
		explicitWait(driver).until(ExpectedConditions.stalenessOf(element));
	}
	
	public void waitUntilElementTobeVisible(WebDriver driver,WebElement element)
	{
		explicitWait(driver).until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void ew_ElementToBeClickable(WebDriver driver, WebElement elem, Duration sec)
	{
		// ew = new WebDriverWait(driver,sec);
		explicitWait(driver).until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	/**
	 * select class object creation
	 * @author PRATHEEP RAJ S
	 * @param ele
	 * @return
	 */
	public Select select(WebElement ele)
	{
		Select slt = new Select( ele );
		return slt;
	}
	
	/**
	 * it is used to select the option in the DropDown by visible text
	 * @author PRATHEEP RAJ S
	 * @param elem
	 * @param text
	 */
	public void selectByVisibleText(WebElement elem,String text)
	{
		select(elem).selectByVisibleText(text);
		
	}
	
	/**
	 * it is used to select the option in the DropDown by Index
	 * @author PRATHEEP RAJ S
	 * @param elem
	 * @param index
	 */
	public void selectByIndex(WebElement elem,int index)
	{
		select(elem).selectByIndex(index);
	}
	
	/**
	 * it is used to select the option in the DropDown by value
	 * @author PRATHEEP RAJ S
	 * @param DDelem
	 * @param value
	 */
	public void selectByValue(WebElement DDelem,String value)
	{
		select(DDelem).selectByValue(value);
	}
	
	/**
	 * To get the first Selected Opt
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 * @return
	 */
	public WebElement firstSelectedOpt(WebElement DDelement)
	{
		WebElement firstOpt = select(DDelement).getFirstSelectedOption();
		return firstOpt;
	}
	
	/**
	 * it is used To deselect All selected options
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 */
	public void deselectingAll(WebElement DDelement)
	{
		select(DDelement).deselectAll();
	}
	
	/**
	 * it is used To deselecting By Value
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 * @param value
	 */
	public void deselectingByValue(WebElement DDelement, String value)
	{
		select(DDelement).deselectByValue(value);
	}
	
	/**
	 * it is used To deselecting By Index
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 * @param index
	 */
	public void deselectingByIndex(WebElement DDelement, int index)
	{
		select(DDelement).deselectByIndex(index);
	}
	
	/**
	 * it is used to deSelecting By Visible Text
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 * @param text
	 */
	public void deselectingByVisibleText(WebElement DDelement, String text)
	{
		select(DDelement).deselectByValue(text);
	}
	/**
	 * it is used to verify that the dropdown is multiple or not
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 * @return
	 */
	public boolean ismultiple(WebElement DDelement)
	{
		boolean multyDD = select(DDelement).isMultiple();
		return multyDD;
	}
	
	/**
	 * it is used to get the wrapped Element
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 * @return
	 */
	public WebElement wrappedElement(WebElement DDelement)
	{
		WebElement wrapped = select(DDelement).getWrappedElement();
		return wrapped;
	}
	
	/**
	 * it is used to get all the options from the drop down
	 * @author PRATHEEP RAJ S
	 * @param DDelement
	 * @param element
	 * @return
	 */
	public ArrayList<String> getOptions(WebElement DDelement, WebElement element)
	{
		List<WebElement> options = select(DDelement).getOptions();
		ArrayList<String>list=new ArrayList<String>();
		for(WebElement opt:options)
		{
			String text = opt.getText(); 
			list.add(text);
		}
		return list;
	}
	
	/**
	 * creating Actions class
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @return
	 */
	public Actions actions(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	
	/**
	 * it is used to move the cursor to the element 
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 */
	public void movetoelement(WebDriver driver, WebElement element)
	{
		actions(driver).moveToElement(element).perform();
	}
	public void movetoelementAndClick(WebDriver driver, WebElement element)
	{
		actions(driver).moveToElement(element).click().perform();
	}
	/** it is used to drag and drop the element
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param ele1
	 * @param ele2
	 */
	public void dragAndDrop(WebDriver driver,WebElement ele1,WebElement ele2)
	{
		actions(driver).dragAndDrop(ele1, ele2).perform();
	}
	
	/**
	 * it is use to hold the element
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element)
	{
		actions(driver).clickAndHold(element).perform();
	}
	/**
	 * it is used to scroll to the location
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 */
	public void scrollByAmount(WebDriver driver, WebElement element)
	{
		Point loc = element.getLocation();
		int xAxis = loc.getX();
		int yAxis= loc.getY();
		actions(driver).scrollByAmount(xAxis, yAxis).perform();
	}
	/**
	 * it is used to double click on the element
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		actions(driver).doubleClick(element).perform();
	}
	/**
	 * it is used to double click on the element
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnBrowser(WebDriver driver,WebElement element)
	{
		actions(driver).doubleClick(element).perform();
	}
	//handling windows
	/**
	 * it is use to switch the control to the child window
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param expeTitle
	 */
	public void switchToChildWindow(WebDriver driver, String expeTitle)
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for(String window:allwindow)
		{
			@Nullable
			String actualTitle = driver.switchTo().window(window).getTitle();
			if(expeTitle.equals(actualTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * it is use to switch the control to the parent window
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param parentWindow
	 */
	public void switchToParentWindow(WebDriver driver, String parentWindow)
	{
		driver.switchTo().window(parentWindow);
	}
	
	//frames
	
	public void switchTochildFrameByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchTochildFrameByid(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	
	public void switchTochildFrameByElement(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void SwitchBackToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void SwitchBackToParentFrame(WebDriver driver,String id)
	{
		driver.switchTo().parentFrame();
	}
	
	//Handling popup
	public void acceptAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismisslertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextFromAlertPopUp(WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	public void enterValueToAlertPopUp(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	//java Script Executer methods 
	
	public JavascriptExecutor jspExecuter(WebDriver driver)
	{
		//type casting
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	public void scrollBottomOfWebpage(WebDriver driver)
	
	{
		jspExecuter(driver).executeScript("window.scrollBy(0,document.body.scrollbyHeight)");
		                                              //X-axis,Y-axis
	}
	
	/**
	 * this method is used to scroll till the element
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 */
	public void scrollUntillElementVisible(WebDriver driver,WebElement element)
	{
		jspExecuter(driver).executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * it is used to pass the Value By JavaSvcript
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void passValueByJavaSvcript(WebDriver driver,WebElement element, String value)
	{
		jspExecuter(driver).executeScript("arguments[0].value=arguments[1]",element,value);
	}
	
	/**
	 * it is used to click On Element By JavaSvcript
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void clickOnElementByJavaSvcript(WebDriver driver,WebElement element)
	{
		jspExecuter(driver).executeScript("arguments[0].click()",element);
	}
	
	/**
	 * it is used to scroll To Element Using X and Y CoOrdinats 
	 * @author PRATHEEP RAJ S
	 * @param driver
	 * @param element
	 */
	public void scrollToElementUsingXandYcoOrdinats(WebDriver driver,WebElement element)
	
	{
		Point loc = element.getLocation();
		int Xaxis = loc.getX();
		int Yaxis = loc.getY(); 
		jspExecuter(driver).executeScript("window.scrollBy("+Xaxis+","+Yaxis+")");
		
	}
	
	
}
