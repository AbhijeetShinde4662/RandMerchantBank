package Org_Automation_Rmb;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import Org.GenericUtility.FetchDataFromExcel;
import Org.GenericUtility.FrameworkConstants;

public class ExcelPractice
{

	public static void main(String[] args) throws InterruptedException, AWTException, Throwable
	{

		FetchDataFromExcel fetchDataFromExcel = new FetchDataFromExcel();

		fetchDataFromExcel.openExcel(FrameworkConstants.EXCEL_PATH);
		List<Map<String, String>> list = fetchDataFromExcel.getDataFromExcelInList("Sheet4");
		
		System.out.println(list);

		//Map<String, String> map = fetchDataFromExcel.getDataFromExcelInMap("Sheet4");

		//System.out.println(map);
	}

}
