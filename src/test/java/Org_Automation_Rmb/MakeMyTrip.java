package Org_Automation_Rmb;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip
{
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, Throwable 
	{
		FileInputStream fis= new FileInputStream("");
		Workbook book = WorkbookFactory.create(fis);
		String from = book.getSheet("MakeMyTrip").getRow(0).getCell(0).getStringCellValue();
		String to = book.getSheet("MakeMyTrip").getRow(0).getCell(0).getStringCellValue();
		
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
		driver.get("https://www.makemytrip.com/");
		
		
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[.='27']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		driver.quit();
	}

}
