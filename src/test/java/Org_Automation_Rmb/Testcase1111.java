package Org_Automation_Rmb;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Org.GenericUtility.FetchDataFromExcel;
import Org.GenericUtility.FetchDataFromProperties;
import Org.GenericUtility.FrameworkConstants;
import Org.GenericUtility.JavaUtility;
import Org.GenericUtility.WebDriverUtility;
import Org_RMB_ObjectRepository.AdminCommonAction;
import Org_RMB_ObjectRepository.ApprovePendingAccountPage;
import Org_RMB_ObjectRepository.CommonAction;
import Org_RMB_ObjectRepository.OpenAccountPage;
import Org_RMB_ObjectRepository.StaffLoginPage;

public class Testcase1111
{

	public static void main(String[] args) throws InterruptedException, AWTException, Throwable
	{
		FetchDataFromProperties fetchDataFromProperties = new FetchDataFromProperties();
		FetchDataFromExcel fetchDataFromExcel = new FetchDataFromExcel();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		JavaUtility javaUtility = new  JavaUtility();	

		//Data from PropertyFile
		String url = fetchDataFromProperties.getDataFromProperty("url");
		String staffid =fetchDataFromProperties.getDataFromProperty("StaffId");
		String password =fetchDataFromProperties.getDataFromProperty("Password");



		//Data from ExcelSheet

		fetchDataFromExcel.openExcel(FrameworkConstants.EXCEL_PATH);
		 Map<String, String> map = fetchDataFromExcel.getDataFromExcelInMap("Sheet4");
		 
		WebDriver driver = webDriverUtility.openAndLaunchBrowser("Chrome", url);

		OpenAccountPage openAccountPage= new OpenAccountPage(driver);
		CommonAction comAction = new CommonAction(driver);
		StaffLoginPage staffLoginPage= new StaffLoginPage(driver);
		AdminCommonAction adminCommonAction= new AdminCommonAction(driver);
		ApprovePendingAccountPage approvePendingAccountPage= new ApprovePendingAccountPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		comAction.OpenAccount();

		 openAccountPage.createAccount(map, driver);
		String message = webDriverUtility.alertHandle(driver);
		String applicationNumber = javaUtility.fetchNumFromAlert(message);
		
		comAction.StaffLoginButton();
		
		staffLoginPage.loginAction(staffid, password);
		
		adminCommonAction.approvePendingAcountButton();
		
		approvePendingAccountPage.approveAccount( applicationNumber);
		webDriverUtility.explicitWaitMethodForAlert(driver);
		String message1 = webDriverUtility.alertHandle(driver);
		System.out.println(message);
		comAction.HomeButton();
		
		if(message1.contains("Account Created Successfully"))
		{
			System.out.println("Testcase Passed");
		}
		else
		{
			System.out.println("Testcase Failed");
		}

		webDriverUtility.closeBrowser(driver);


	}

}
