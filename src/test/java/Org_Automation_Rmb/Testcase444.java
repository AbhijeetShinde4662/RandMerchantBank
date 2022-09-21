package Org_Automation_Rmb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import Org.GenericUtility.FetchDataFromExcel;
import Org.GenericUtility.FetchDataFromProperties;
import Org.GenericUtility.JavaUtility;
import Org.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase444
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
		int i=5;
		
		String name = fetchDataFromExcel.getDataFromExcel("Sheet1", i, 0);
		String mob = fetchDataFromExcel.getDataFromExcel("Sheet1", i, 1);
		String email =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 2);
		String landline =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 3);
		String pancard =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 4);
		String citizenship =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 5);
		String homeads =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 6);
		String Officeads =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 7);
		String pincode =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 8);
		String locality =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 9);
		String nomename =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 10);
		String nimaccnt =  fetchDataFromExcel.getDataFromExcel("Sheet1", i, 11);
		

		WebDriver driver = webDriverUtility.openAndLaunchBrowser("Chrome", url);




		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("mobile")).sendKeys(mob);
		driver.findElement(By.name("email")).sendKeys(email);

		driver.findElement(By.name("pan_no")).sendKeys(pancard);
		driver.findElement(By.name("citizenship")).sendKeys(citizenship);
		driver.findElement(By.name("homeaddrs")).sendKeys(homeads);
		driver.findElement(By.name("pin")).sendKeys(pincode);
		driver.findElement(By.name("arealoc")).sendKeys(locality);
		
//		 WebElement dob = driver.findElement(By.xpath("//input[@name='dob']"));
//		 dob.click();
//		 dob.sendKeys("10-12-1993");
	
		
		driver.findElement(By.xpath("//input[@name='dob']")).click();
		driver.findElement(By.xpath("//input[@name='dob']")).click();
		Robot rbt= new Robot();
		rbt.keyPress(KeyEvent.VK_1);
		rbt.keyRelease(KeyEvent.VK_1);
		rbt.keyPress(KeyEvent.VK_1);
		rbt.keyRelease(KeyEvent.VK_1);
		rbt.keyPress(KeyEvent.VK_1);
		rbt.keyRelease(KeyEvent.VK_1);
		rbt.keyPress(KeyEvent.VK_0);
		rbt.keyRelease(KeyEvent.VK_0);
		rbt.keyPress(KeyEvent.VK_1);
		rbt.keyRelease(KeyEvent.VK_1);
		rbt.keyPress(KeyEvent.VK_9);
		rbt.keyRelease(KeyEvent.VK_9);
		rbt.keyPress(KeyEvent.VK_9);
		rbt.keyRelease(KeyEvent.VK_9);
		rbt.keyPress(KeyEvent.VK_9);
		rbt.keyRelease(KeyEvent.VK_9);



		WebElement acctype = driver.findElement(By.name("acctype"));
		webDriverUtility.dropDownHandle(acctype, 2);

		WebElement gender = driver.findElement(By.name("gender"));
		webDriverUtility.dropDownHandle(gender, 2);


		WebElement state = driver.findElement(By.name("state"));
		webDriverUtility.dropDownHandle(state, 4);

		WebElement city = driver.findElement(By.name("city"));
		webDriverUtility.dropDownHandle(city, 3);

		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();

		String alertmessage = webDriverUtility.alertHandle(driver);




		String aplctnno=javaUtility.fetchNumFromAlert(alertmessage);

		System.out.println(aplctnno);

		Thread.sleep(5000);

		driver.findElement(By.linkText("Staff Login")).click();

		driver.findElement(By.name("staff_id")).sendKeys(staffid);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("staff_login-btn")).click();

		driver.findElement(By.name("apprvac")).click();

		driver.findElement(By.name("application_no")).sendKeys(aplctnno);
		Thread.sleep(2000);
		driver.findElement(By.name("search_application")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("approve_cust")).click();
		Thread.sleep(5000);


		String alertmessage1 = webDriverUtility.alertHandle(driver);


		System.out.println(alertmessage1);

		String accountnumber=javaUtility.fetchNumFromAlert(alertmessage1);

		System.out.println(accountnumber);

		String cust_Id=javaUtility.FetchCustomerId(accountnumber);
		System.out.println(cust_Id);




		driver.findElement(By.xpath("//input[@name='home']")).click();
		driver.findElement(By.name("del_cust")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Cust_ac_no")).sendKeys(accountnumber);
		driver.findElement(By.name("Cust_ac_Id")).sendKeys(cust_Id);
		driver.findElement(By.name("reason")).sendKeys("Suspect List");
		Thread.sleep(2000);
		driver.findElement(By.name("delete")).click();

		String alertmessage11 = webDriverUtility.alertHandle(driver);

		if(alertmessage11.contains("Customer Deleted Successfully"))
		{
			System.out.println("Testcase444 passed and account created successfully");
		}


		driver.quit();


	}

}
