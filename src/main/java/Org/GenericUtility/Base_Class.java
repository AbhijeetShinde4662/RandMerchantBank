package Org.GenericUtility;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Org_RMB_ObjectRepository.AdminCommonAction;
import Org_RMB_ObjectRepository.ApplyDebitCardPage;
import Org_RMB_ObjectRepository.ApprovePendingAccountPage;
import Org_RMB_ObjectRepository.CommonAction;
import Org_RMB_ObjectRepository.CreditCustomerPage;
import Org_RMB_ObjectRepository.DeleteCustomerPage;
import Org_RMB_ObjectRepository.IBRegistrationPage;
import Org_RMB_ObjectRepository.OpenAccountPage;
import Org_RMB_ObjectRepository.StaffLoginPage;

public class Base_Class 
{
	private FetchDataFromProperties fetchDataFromProperties;
	protected FetchDataFromExcel fetchDataFromExcel;
	protected WebDriverUtility webDriverUtility;
	protected JavaUtility javaUtility;
	public static JavaUtility sjavaUtility;
	private String url;
	protected String staffid;
	protected String password;
	protected WebDriver driver;
	public  static WebDriver sdriver;
	protected OpenAccountPage openAccountPage;
	protected CommonAction comAction;
	protected StaffLoginPage staffLoginPage;
	protected ApplyDebitCardPage applyDebitCardPage;
	protected AdminCommonAction adminCommonAction;
	protected ApprovePendingAccountPage approvePendingAccountPage;
	protected Map<String, String> map;
	protected CreditCustomerPage creditCustomerPage;
	protected DeleteCustomerPage deleteCustomerPage;
	protected IBRegistrationPage ibRegistrationPage;


	@BeforeSuite
	public void Testcase1()
	{
		Reporter.log("BeforeSuite Executed", true);
	}

	@BeforeTest
	public void Testcase3()
	{
		Reporter.log("BeforeTest Executed", true);
	}

	@BeforeClass
	public void Testcase2() throws IOException
	{



		fetchDataFromProperties = new FetchDataFromProperties();
		fetchDataFromExcel = new FetchDataFromExcel();
		webDriverUtility = new WebDriverUtility();
		javaUtility = new  JavaUtility();	
		sjavaUtility=javaUtility;

		url = fetchDataFromProperties.getDataFromProperty("url");
		staffid =fetchDataFromProperties.getDataFromProperty("StaffId");
		password =fetchDataFromProperties.getDataFromProperty("Password");


		fetchDataFromExcel.openExcel(FrameworkConstants.EXCEL_PATH);


		Reporter.log("BeforeClass Executed", true);
	}

	@BeforeMethod
	public void Testcase5()
	{
		map = fetchDataFromExcel.getDataFromExcelInMap("Sheet4");
		driver = webDriverUtility.openAndLaunchBrowser("Chrome", url);
		sdriver=driver;
		openAccountPage= new OpenAccountPage(driver);
		comAction = new CommonAction(driver);
		staffLoginPage= new StaffLoginPage(driver);
		adminCommonAction= new AdminCommonAction(driver);
		approvePendingAccountPage= new ApprovePendingAccountPage(driver);
		applyDebitCardPage = new ApplyDebitCardPage(driver);
		creditCustomerPage = new CreditCustomerPage(driver);
		deleteCustomerPage = new DeleteCustomerPage(driver);
		ibRegistrationPage = new IBRegistrationPage(driver);
		Reporter.log("BeforeMethod Executed", true);
	}




	@AfterMethod
	public void Testcase7()
	{
		webDriverUtility.closeBrowser(driver);
		Reporter.log("AfterMethod Executed", true);
	}

	@AfterClass
	public void Testcase9() throws IOException
	{
		Reporter.log("AfterClass Executed", true);


		fetchDataFromExcel.closeExcel();
	}

	@AfterTest
	public void Testcase8()
	{
		Reporter.log("AftreTest Executed", true);
	}

	@AfterSuite
	public void Testcase10()
	{
		Reporter.log("AftreSuite Executed", true);
	}

}		
