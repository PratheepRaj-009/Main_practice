package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToReadIntegerValue 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("honor",Keys.ENTER);
		List<WebElement> names = driver.findElements(By.xpath("//a[@class='GnxRXv']/following-sibling::a[@class='pIpigb']"));
		List<WebElement> listOfprice = driver.findElements(By.xpath("//a[@class='GnxRXv']/following-sibling::a[@class='fb4uj3']"));
		int namesize = names.size();
		int pricesize = listOfprice.size();
		ArrayList<String>nameal=new ArrayList();
		ArrayList<String>priceal=new ArrayList();
		FileInputStream fis = new FileInputStream("./src/test/resources/files/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Name And Price");
		
		for(WebElement name:names)
		{
			String text = name.getText();
			nameal.add(text);
			
			//System.out.println(nameal);
		}
		for(WebElement price:listOfprice)
		{
			String pricetext = price.getText();
			priceal.add(pricetext);
			//System.out.println(priceal);
		}
		for(int i=0; i<namesize ; i++)
		{
			Row row = sheet.createRow(i);
		
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(nameal.get(i));
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(priceal.get(i));
		
			
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/files/Testdata.xlsx");
		book.write(fos);
		book.close();
		
		driver.quit();
		
		
	
	}
}
