package Org_Automation_Test_NG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Org.GenericUtility.WebDriverUtility;

public class MavenPratctice1Test 
{
	@Test
	public void sample()
	{
		String browser= System.getProperty("b");
		String url= System.getProperty("u");
		
		
		
		System.out.println("The name of the browser is= "+browser);
		System.out.println("The url is"+url); 
		
		
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		webDriverUtility.openAndLaunchBrowser(browser, url);
		
		
	}
}
