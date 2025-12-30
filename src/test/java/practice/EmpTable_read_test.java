package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EmpTable_read_test
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/files/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("EmpTbl");
		int lastrow = sheet.getLastRowNum();
		short lastcell = sheet.getRow(0).getLastCellNum();
		for(int i=0; i<=lastrow; i++)
		{
			for (int j=0; j<lastcell;j++)
			{
			 String sw = sheet.getRow(i).getCell(j).toString();
			 
			System.out.print(sw+" ");
			}
			System.out.println();
		}
		book.close();
	}
}
