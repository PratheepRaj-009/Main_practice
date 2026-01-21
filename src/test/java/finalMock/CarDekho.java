package finalMock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CarDekho 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notification");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.cardekho.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act =new Actions(driver);
		WebElement newcarDD = driver.findElement(By.xpath("//span[contains(.,'NEW CARS ') and @class='innerSpan']"));
		WebElement electric_Car = driver.findElement(By.xpath("//span[contains(.,'Electric Cars ') and @class='innerSpan']"));
		act.moveToElement(newcarDD).perform();
		act.moveToElement(electric_Car).perform();
		driver.findElement(By.xpath("//span[contains(.,'All Electric Cars')]")).click();
		driver.findElement(By.xpath("//li[@title='Brand']")).click();
		driver.findElement(By.xpath("//input[@id='bmvBrand']")).click();
		driver.findElement(By.xpath("//li[@data-value='Kia']")).click();
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//input[@id='bmvBrand']/../../following-sibling::li[.='Search']")).click();
		List<WebElement> NameAndPrice = driver.findElements(By.xpath("//div[@class='card card_new ']//h3/a|//div[@class='card card_new ']//div[@class='price']/span"));
		int count = NameAndPrice.size();
		FileInputStream fis = new FileInputStream("./src/test/resources/files/TestData2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("cardekho");

		int i=1;
		int j=0;
		int k=0;

		for(WebElement NP:NameAndPrice)
		{
			for(;i<=count;)
			{
				i++;
				if(i%2==0)
				{
					
					String name = NP.getText();
					System.out.println(name);
					sheet.getRow(0).createCell(j).setCellValue(name);
					j++;

				}
				if(i%2==1)
				{
					
					String price = NP.getText();
					System.out.println(price);
					sheet.getRow(1).createCell(k).setCellValue(price);
					k++;
				}
				break;
			}

			
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/files/TestData2.xlsx");
		book.write(fos);
		book.close();
		driver.quit();
	}
}


