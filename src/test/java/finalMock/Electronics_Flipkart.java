package finalMock;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Electronics_Flipkart 
{
	@Test
	public void test() throws InterruptedException, EncryptedDocumentException, IOException
	
	{
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act =new Actions(driver);
		WebElement elec = driver.findElement(By.xpath("//span[contains(.,'Electronics')]"));
		act.moveToElement(elec).perform();
		WebElement lapAcc = driver.findElement(By.xpath("//a[text()='Laptop Accessories']"));
		act.moveToElement(lapAcc).perform();
		WebElement mouse = driver.findElement(By.xpath("//a[text()='Mouse']"));
		act.moveToElement(mouse).click().perform();
		
		List<WebElement> values = driver.findElements(By.xpath("(//div[@class='nZIRY7'])[3]/div[3]//a[@class='pIpigb']|(//div[@class='nZIRY7'])[3]/div[3]/descendant::div[@class='MKiFS6']|(//div[@class='nZIRY7'])[3]/div[3]//div[@class='hZ3P6w']"));
		
		for(WebElement value:values)	
		{
			
			System.out.println(value.getText());
		}
//		System.out.println(driver.findElement(By.xpath("(//div[@class='nZIRY7'])[3]/div[3]/descendant::div[@class='MKiFS6']")).getText());
//		System.out.println(driver.findElement(By.xpath("(//div[@class='nZIRY7'])[3]/div[3]//div[@class='hZ3P6w']")).getText());
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}
}










//FileInputStream fis = new FileInputStream("./src/test/resources/files/Testdata.xlsx");
//Workbook book = WorkbookFactory.create(fis);
//Sheet sheet = book.getSheet("flipkart");
//sheet
