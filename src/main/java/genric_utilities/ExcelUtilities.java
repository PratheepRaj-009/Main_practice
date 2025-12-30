package genric_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities 
{
	/**
	 * used to read the Data From Excel 
	 * @author PRATHEEP RAJ S
	 * @param sheetNm
	 * @param ro
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetNm, int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(PathsConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetNm);
		String value = sheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	/**
	 * used to read Multiple Data From Excel
	 * @author PRATHEEP RAJ S
	 * @param sheetNm
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  ArrayList<String> readMultipleDataFromExcel(String sheetNm) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream(PathsConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetNm);
		Row row = sheet.getRow(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount=row.getLastCellNum();
		ArrayList<String>list= new ArrayList<String>();
		for(int i=0; i<=rowCount;i++)
		{
			for(int j=0; j<cellCount;j++)
			{
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		return list;
	}
	/**
	 * used to get last Row count
	 * @author PRATHEEP RAJ S
	 * @param sheetNm
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowcount(String sheetNm) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(PathsConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetNm);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * used to get get Last Cell count
	 * @author PRATHEEP RAJ S
	 * @param sheetNm
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void getLastCell(String sheetNm) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(PathsConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetNm);
		Row row = sheet.getRow(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount=row.getLastCellNum();
	}
	
	public Object[][] excelDataProvider(String sheetName) throws EncryptedDocumentException, IOException
	{
		 FileInputStream fis = new FileInputStream(PathsConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()+1;
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][cellCount];
		
		for(int i=0; i<rowCount; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}

	
}
