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
import Org.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase22 {
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, AWTException, Throwable
	{
		FetchDataFromProperties fetchDataFromProperties = new FetchDataFromProperties();
		FetchDataFromExcel fetchDataFromExcel = new FetchDataFromExcel();
		
		
		
		//Data from PropertyFile
		String url = fetchDataFromProperties.getDataFromProperty("url");
		String staffid =fetchDataFromProperties.getDataFromProperty("StaffId");
		String password =fetchDataFromProperties.getDataFromProperty("Password");
		
		
		
		//Data from ExcelSheet
		int i=2;
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

		String browser="Firefox";
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
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
		Select sty = new Select(acctype);
		sty.selectByVisibleText("Saving");

		WebElement gender = driver.findElement(By.name("gender"));
		Select sg = new Select(gender);
		sg.selectByVisibleText("Male");

		WebElement state = driver.findElement(By.name("state"));
		Select ss = new Select(state);
		ss.selectByVisibleText("California");

		WebElement city = driver.findElement(By.name("city"));
		Select sc = new Select(city);
		sc.selectByVisibleText("Orlando");

		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();


		Alert alt = driver.switchTo().alert();
		String alertmsege = alt.getText();
		alt.accept();
		System.out.println( alertmsege);

		String aplctnno = "";

		for(int j=0; j<alertmsege.length(); j++) 
		{
			char ch = alertmsege.charAt(j);

			if((ch>=48)&&(ch<=57)) 
			{
				aplctnno = aplctnno + ch;
			}
		}
		System.out.println(aplctnno);

		

		driver.findElement(By.linkText("Staff Login")).click();

		driver.findElement(By.name("staff_id")).sendKeys(staffid);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("staff_login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("apprvac")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("application_no")).sendKeys(aplctnno);
		Thread.sleep(2000);
		driver.findElement(By.name("search_application")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("approve_cust")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String accountNo = alert.getText();
		System.out.println(accountNo);
		
		
		String acuntno = "";

		for(int j=0; j<accountNo.length(); j++) 
		{
			char ch = accountNo.charAt(j);

			if((ch>=48)&&(ch<=57)) 
			{
				acuntno = acuntno + ch;
			}
		}
		System.out.println(acuntno);

		alert.accept();
		
		
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();;
		driver.findElement(By.name("holder_name")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@name='dob']")).click();
		driver.findElement(By.xpath("//input[@name='dob']")).click();
		
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
		
		
		driver.findElement(By.name("pan")).sendKeys(pancard);
		driver.findElement(By.name("mob")).sendKeys(mob);
		driver.findElement(By.name("acc_no")).sendKeys(acuntno);
		Thread.sleep(3000);
		driver.findElement(By.name("dbt_crd_submit")).click();
		Alert debalert = driver.switchTo().alert();
		
		
		String card = debalert.getText();
		System.out.println(card);
		
		String debitcarddetails = "";
		String cardno ="";
		String cardpin ="";
		
		for(int k=0; k<card.length(); k++) {
			if(card.charAt(k)>='0'&& card.charAt(k)<='9') {
				debitcarddetails= debitcarddetails + card.charAt(k);
			}
		}
		for(int l =0; l<debitcarddetails.length(); l++) {
			if(l<=11) {
				cardno = cardno + debitcarddetails.charAt(l);
			}
			else{
				cardpin = cardpin + debitcarddetails.charAt(l);
			}
		}
		System.out.println("card no = " + cardno);
		System.out.println("card pin=" + cardpin);
		debalert.accept();


		if(card.contains("Debit Card issued successfully."))
		{
			System.out.println("Testcase12 passed and account created successfully");
		}


		driver.quit();



	}

}
