package Org_Automation_Rmb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Org.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpath
{
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, Throwable 
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
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.xpath("//input[@name='viewdet']")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.titleContains(""));
		String id = driver.getWindowHandle();
		driver.switchTo().window(id);
		String name="url";
		String username=null;
		List<WebElement> heading = driver.findElements(By.xpath("//th[.='Username']/following::tr/td[2]"));
		String custId = null;
		String actNo = null; 
		for (WebElement webElement : heading)
		{
			 username = webElement.getText();
			 
		}	
		if(username.equals(name))
			{
				 custId = driver.findElement(By.xpath("//th[.='Username']/following::tr[1]/td[3]")).getText();
				 actNo = driver.findElement(By.xpath("//th[.='Username']/following::tr[1]/td[4]")).getText();
				 driver.findElement(By.xpath("//input[@name='home']")).click();
					String id1 = driver.getWindowHandle();
					driver.switchTo().window(id1);				
					driver.findElement(By.xpath("//input[@name='del_cust']")).click();
					String id2 = driver.getWindowHandle();
					driver.switchTo().window(id2);
					driver.findElement(By.xpath("//input[@name='Cust_ac_Id']")).sendKeys(custId);
					driver.findElement(By.xpath("//input[@name='Cust_ac_no']")).sendKeys(actNo);
					driver.findElement(By.xpath("//input[@name='reason']")).sendKeys("The Account is Fake");
					driver.findElement(By.xpath("//input[@name='delete']")).click();
					System.out.println(actNo+  "   The Account Deleted Successfully");
				
			}
			else
			{
				System.out.println("The Account Not Found By This Name");
			
			}
			
		
		
		
		
		driver.quit();
	}

}
	










////th[.='Username']/parent::tr

////th[.='Username']/ancestor::tr//following-sibling::th[.='Username']
