package Org_Automation_Rmb;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTwoExcel
{	
	public static void main(String[] args) throws Throwable
	{
		 FileInputStream fis= new FileInputStream("./src/test/resources/RMB.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		DataFormatter df= new DataFormatter();
		
		for(int i=0; i<=sheet.getLastRowNum();i++)
		{
			
			for(int j=0; j<=sheet.getRow(i).getLastCellNum();j++)
			{
			
			Cell cell = sheet.getRow(i).getCell(j);
			
			 String value = df.formatCellValue(cell);
			
				
				System.out.print(value+"       ");
				
			}
			System.out.println();
		}
		 
	}

	
}
