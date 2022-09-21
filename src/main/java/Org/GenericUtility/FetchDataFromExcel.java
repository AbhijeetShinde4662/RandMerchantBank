package Org.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to fetch data from Excel sheet
 * @author Shinde
 *
 */
public class FetchDataFromExcel 
{


	private Workbook book;

	/**
	 * This method is used to open the excel workbook
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  void openExcel(String excelpath) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis= new FileInputStream(excelpath);
		book = WorkbookFactory.create(fis);

	}
	/**
	 * This method is created to fetch data from the excel sheet
	 * @param sheet
	 * @param row
	 * @param cellno
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable 
	 * @throws Exception
	 */
	public  String getDataFromExcel(String sheet, int rowno, int cellno)  
	{
		DataFormatter dataFormatter =new DataFormatter();
		org.apache.poi.ss.usermodel.Sheet sheetname = book.getSheet(sheet);
		String value = dataFormatter.formatCellValue(sheetname.getRow(rowno).getCell(cellno));

		return value;
	}

	/**
	 * This method is used to fetch data from excel in Map
	 * @param sheetName
	 * @return
	 */
	public  Map<String, String> getDataFromExcelInMap(String sheetName)  
	{
		Sheet sheet = book.getSheet(sheetName);
		Map<String, String>map= new HashMap<>();
		DataFormatter dataFormatter =new DataFormatter();
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			map.put(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)), dataFormatter.formatCellValue(sheet.getRow(i).getCell(1)));

		}
		return map;
	}
	/**
	 *  This method is used to fetch data from excel in List
	 * @param sheetName
	 * @return

	 */
	public  List<Map<String, String>> getDataFromExcelInList(String sheetName)  
	{
		Sheet sheet = book.getSheet(sheetName);
		List<Map<String, String>> list= new ArrayList<>();
		DataFormatter dataFormatter =new DataFormatter();
		for(int k=1; k<sheet.getRow(0).getLastCellNum(); k++)
		{
			Map<String, String>map= new HashMap<>();
			for(int i=0; i<=sheet.getLastRowNum(); i++)
			{
				map.put(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)), dataFormatter.formatCellValue(sheet.getRow(i).getCell(k)));

			}
			list.add(map);
		}
		return list;
	}
	/**
	 * This method is used to set the data into excel value
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param text
	 */
	public  void setDataIntoExcel(String sheetName, int row, int cell, String text) 
	{
		Sheet sheet = book.getSheet(sheetName);
		sheet.getRow(row).createCell(cell).setCellValue(text);
	}
	/**
	 * This method is used to save data into excel work book
	 * @param path
	 * @throws IOException
	 */
	public  void saveDataIntoExcel( String path) throws IOException 
	{

		FileOutputStream fout= new FileOutputStream(path);
		book.write(fout);
	}

	/**
	 * This method is used to close the excel workbook
	 * @throws IOException
	 */
	public  void closeExcel() throws IOException 
	{
		book.close();

	}
}
