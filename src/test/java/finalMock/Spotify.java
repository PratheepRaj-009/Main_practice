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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genric_utilities.Spotify_Excel;

public class Spotify 
{
	public static void main(String[] args) throws Exception
	{
		Spotify_Excel spo = new Spotify_Excel();
		String username = spo.getCredentials("userCredentials",0, 2);
		String singer = spo.getCredentials("Artist",0, 0);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://open.spotify.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[.='Log in']")).click();
		driver.findElement(By.id("username")).sendKeys(username,Keys.ENTER);
		//Thread.sleep(20);
		WebDriverWait exw=new WebDriverWait(driver, Duration.ofMinutes(2));
		exw.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@data-testid='search-input']"))));
		driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys(singer,Keys.ENTER);
		driver.findElement(By.xpath("//span[.='Artist']/../preceding-sibling::a//span[.='"+singer+"']")).click();
		FileInputStream fis = new FileInputStream("./src/test/resources/files/Spotify_data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Artist");
		List<WebElement> songs = driver.findElements(By.xpath("//a[@data-testid='internal-track-link']/div|//div[@class='qev2KFBSKCHkeXT4fDTl']/div[@data-encore-id='text']"));
		int count = songs.size();
		System.out.println(count);
		int i=0;
		int j=1;
		int k=1;
		for(WebElement song:songs)
		{
			
			i++;
			
			for(;i<=count;)
			{
				
				
				if(i%2==1)
				{
					String name = song.getText();
					System.out.println(name);
					sheet.createRow(j).createCell(0).setCellValue(name);
					j++;
				}
				else if(i%2==0)
				{
					String ratings = song.getText();
					System.out.println(ratings);
					sheet.getRow(k).createCell(1).setCellValue(ratings);
					k++;
				}
				break;
		}
	}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/files/Spotify_data.xlsx");
		book.write(fos);
		book.close();
		driver.quit();
	}
}
