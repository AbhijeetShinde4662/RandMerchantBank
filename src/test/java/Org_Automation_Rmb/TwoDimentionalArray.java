package Org_Automation_Rmb;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TwoDimentionalArray {

	public static void main(String[] args) throws Throwable, Throwable
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/RMB.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet5");
		DataFormatter dt=new DataFormatter();
		
		String [][] arr= new String[sheet.getLastRowNum()+1][sheet.getRow(sheet.getLastRowNum()).getLastCellNum()];
		
		for (int i = 0; i <=sheet.getLastRowNum(); i++) 
		{
			for (int 	j= 0; j < sheet.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=dt.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
		
	
		
		for (int i = 0; i <=sheet.getLastRowNum() ; i++) 
		{
			
			for (int j = 0;j < sheet.getRow(i).getLastCellNum(); j++) 
			{
				System.out.print(arr[i][j]+"                 ");
			}
			System.out.println();
		}
		
	
		
		book.close();
	}

}
