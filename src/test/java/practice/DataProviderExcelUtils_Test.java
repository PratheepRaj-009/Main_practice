package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genric_utilities.ExcelUtilities;

public class DataProviderExcelUtils_Test 
{
	
	@Test(dataProvider ="getData" )
	public void execute(String sftName,String sftVersion)
	{
		System.out.println(sftName+""+sftVersion);
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtilities xlU = new ExcelUtilities();
		Object[][] data = xlU.excelDataProvider("Softwares");
		return data;
	}
}
