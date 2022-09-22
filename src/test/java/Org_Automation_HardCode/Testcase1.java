package Org_Automation_HardCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1 {
		static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, AWTException, Throwable
	{
		String browser="Firefox";
		if(browser.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();	
		}
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String staffid = prop.getProperty("StaffId");
		String password = prop.getProperty("Password");
		
		
		FileInputStream fiss= new FileInputStream("");
		Workbook book = WorkbookFactory.create(fiss);
		Sheet sheet = book.getSheet("");
		String name = sheet.getRow(0).getCell(1).getStringCellValue();
		String mob = sheet.getRow(0).getCell(1).getStringCellValue();
		String email = sheet.getRow(0).getCell(1).getStringCellValue();
		String pancard = sheet.getRow(0).getCell(1).getStringCellValue();
		String citizenship = sheet.getRow(0).getCell(1).getStringCellValue();
		String homeads = sheet.getRow(0).getCell(1).getStringCellValue();
		String pincode = sheet.getRow(0).getCell(1).getStringCellValue();
		String arealoc = sheet.getRow(0).getCell(1).getStringCellValue();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		
		
		
		driver.findElement(By.name("name")).sendKeys("haris");
		WebElement gender = driver.findElement(By.name("gender"));
		Select sg = new Select(gender);
		sg.selectByVisibleText("Male");
		driver.findElement(By.name("mobile")).sendKeys("6380616096");
		driver.findElement(By.name("email")).sendKeys("haris@gmail.com");
		
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
		
		
		driver.findElement(By.name("pan_no")).sendKeys("HARIS12");
		driver.findElement(By.name("citizenship")).sendKeys("Har77");
		driver.findElement(By.name("homeaddrs")).sendKeys("chennai");
		WebElement state = driver.findElement(By.name("state"));
		Select ss = new Select(state);
		ss.selectByVisibleText("California");
		WebElement city = driver.findElement(By.name("city"));
		Select sc = new Select(city);
		sc.selectByVisibleText("Orlando");
		driver.findElement(By.name("pin")).sendKeys("560045");
		driver.findElement(By.name("arealoc")).sendKeys("koyambedu");
		WebElement acctype = driver.findElement(By.name("acctype"));
		Select sty = new Select(acctype);
		sty.selectByVisibleText("Saving");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();
		
		
		String text = driver.switchTo().alert().getText();
		
		System.out.println(text);
		String appno = "";
		for(int i=0; i<text.length(); i++) 
		{
			if(text.charAt(i)>='0'&& text.charAt(i)<='9') {
				appno = appno + text.charAt(i);
			}
		}
		System.out.println(appno);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys(staffid);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("apprvac")).click();
		driver.findElement(By.name("application_no")).sendKeys(appno);
		driver.findElement(By.name("search_application")).click();
		driver.findElement(By.name("approve_cust")).click();
		Alert accno = driver.switchTo().alert();
		String accountNo = accno.getText();
		System.out.println(accountNo);
		accno.accept();
		
		
		
		if(accountNo.contains("Account Created Successfully"))
		{
			System.out.println("Testcase1 passed and account created successfully");
		}
		driver.quit();
	}

}
