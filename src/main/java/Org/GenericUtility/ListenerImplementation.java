package Org.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{
	ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest  stest;



	@Override
	public void onTestStart(ITestResult result)
	{
		test = reports.createTest(result.getMethod().getMethodName());
		stest=test;
	}

	@Override //AfterMethod
	public void onTestSuccess(ITestResult result) 
	{
		test.pass(result.getMethod().getMethodName()+"Passed");

	}

	@Override//AfterMethod
	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getMethod().getMethodName()+"Failed");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		
		WebDriverUtility webDriverUtility= new WebDriverUtility();
		String path = webDriverUtility.getScreenShot(Base_Class.sdriver);
		test.addScreenCaptureFromBase64String(path);
	}

	@Override//AfterMethod
	public void onTestSkipped(ITestResult result) 
	{
		test.skip(result.getMethod().getMethodName()+"Skipped");

	}

	@Override//AfterMethod
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	@Override//BeforeTest
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark= new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("RMB_BFSI_SDET40");
		spark.config().setReportName("Reporter Name- Abhijeet N S");
		spark.config().setTheme(Theme.STANDARD);
		reports= new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Abhijeet N S");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Version", "21H2");
		reports.setSystemInfo("Browser", "Chrome");

	}

	@Override//AfterTest
	public void onFinish(ITestContext context) {
		reports.flush();

	}

}
