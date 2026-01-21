package genric_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Spotify_Excel 
{
	public String getCredentials(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/files/Spotify_data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		String value = sheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public void writeMultipleDataInExcel(String sheetName,int row, int cell) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/files/Spotify_data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		sheet.getRow(row).createCell(cell).setCellValue("");
		//return value;
		
	}
}
