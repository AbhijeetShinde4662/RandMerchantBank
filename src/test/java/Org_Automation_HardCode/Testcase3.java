package Org_Automation_HardCode;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3 {
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, Throwable {
		
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
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
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
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("cnfrm-submit")).click();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		String appno = "";
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i)>='0'&& text.charAt(i)<='9') {
				appno = appno + text.charAt(i);
			}
		}
		System.out.println("AppNo=" + appno);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("apprvac")).click();
		driver.findElement(By.name("application_no")).sendKeys(appno);
		driver.findElement(By.name("search_application")).click();
		driver.findElement(By.name("approve_cust")).click();
		Alert accalert = driver.switchTo().alert();
		String alrt = accalert.getText();
		System.out.println(alrt);
		accalert.accept();
		String accno = "";
		for(int i=0; i<alrt.length(); i++) {
			if(alrt.charAt(i)>='0'&& alrt.charAt(i)<='9') {
				accno = accno + alrt.charAt(i);
			}
		}
		System.out.println("accno=" + accno);
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("credit_cust_ac")).click();
		driver.findElement(By.name("customer_account_no")).sendKeys(accno);
		driver.findElement(By.name("credit_amount")).sendKeys("1000");
		driver.findElement(By.name("credit_btn")).click();
		Alert credit = driver.switchTo().alert();
		String credittext = credit.getText();
		System.out.println(credittext);
		credit.accept();
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("view_cust_by_ac")).click();
		driver.findElement(By.name("account_no")).sendKeys(accno);
		driver.findElement(By.name("submit_view")).click();
	    driver.quit();
	}

}
