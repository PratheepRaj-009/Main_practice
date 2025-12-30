package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreatAndReadData_Excel_test 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/files/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("subject");
		Row row0 = sheet.createRow(0);
		Cell cell0 = row0.createCell(0);
		cell0.setCellValue("selenium");
		Cell cell1 = row0.createCell(1);
		cell1.setCellValue("basic");
		Cell cell2 = row0.createCell(2);
		cell2.setCellValue("Advance");
		//cell2.setCellValue("complete");
	
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/files/Testdata.xlsx");
		book.write(fos);
		book.close();
	
	
	
	}
}
