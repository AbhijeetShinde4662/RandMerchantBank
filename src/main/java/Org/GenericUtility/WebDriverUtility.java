package Org.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;
/**
 * This class is used to perform driver related operations in project.
 * @author Shinde
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method is used to open the browser based on argument passed.
	 * @param browser
	 * @return
	 */
	public WebDriver OpenBrowser( String browser)
	{
		WebDriver driver=null;
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
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public  void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}


	/**
	 * This method is used to launch Url of application
	 * @param driver
	 * @param url
	 */
	public  void launchUrl(WebDriver driver, String url)
	{
		driver.get(url);
	}

	/**
	 * This method is used to open the browser and launch url and maximise the browser
	 * @param browser
	 * @param url
	 * @return
	 */
	public  WebDriver openAndLaunchBrowser(String browser,String url)
	{
		WebDriver driver=OpenBrowser(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		maximiseWindow(driver);
		launchUrl(driver,url);
		return driver;
	}

	/**
	 * This method is used to handle the dropdown of the application by passing index number
	 * @param element
	 * @param index
	 */

	public  void dropDownHandle(WebElement element, int index )
	{

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to handle the dropdown of the application by passing visible text
	 * @param element
	 * @param index
	 */

	public  void dropDownHandle(WebElement element, String value )
	{

		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	/**
	 * This method is used to handle the alert in the application
	 * @param driver
	 * @return
	 */
	public  String alertHandle(WebDriver driver)
	{

		Alert alert = driver.switchTo().alert();
		String alertmsege = alert.getText();

		alert.accept();
		return alertmsege;
	}
	/**
	 * This method is developed for explicit wait method
	 * @param driver
	 */
	public void explicitWaitMethodForAlert(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());

	}


	/**

	 *This method is used to validation of testcase validation 
	 * @param actualCondition
	 * @param expectedCondition
	 */
	public void testCaseValidationUsingString(String actualCondition, String expectedCondition)
	{
		org.testng.Assert.assertEquals(actualCondition, expectedCondition);
	}

	/**
	 * This method is used to validation of testcase validation
	 * @param actualCondition
	 * @param expectedCondition
	 */
	public void testCaseValidationUsingSoftAssert(String actualCondition, String expectedCondition)
	{
		SoftAssert soft= new SoftAssert();
		soft.assertTrue(actualCondition.contains(expectedCondition));
		soft.assertAll();
	}
	/**
	 * This method is used to verify account creation
	 * @param driver
	 * @param expectedCondition
	 */
	public void verifyAccountNumber(WebDriver driver,  String expectedCondition)
	{
		List<WebElement> list = driver.findElements(By.xpath("//th[.='#']/parent::tr/following::tr/td[4]"));

		for (WebElement webElement : list)
		{
			String actualCondition = webElement.getText();
			Assert.assertEquals(actualCondition, expectedCondition);
		}
		System.out.println("Account found in DataBase");
	}
	/**
	 * This method is used to get screen shot from the testcase
	 * @param driver
	 * @param javaUtility
	 * @param classname
	 * @throws IOException
	 */
	public void getScreenShot(WebDriver driver, JavaUtility javaUtility,String classname) throws IOException
	{
		String currentTime = javaUtility.currentTime();
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+classname+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);
	}

	/**
	 * This method is used to get base64 string format
	 * @param driver
	 * @return
	 * @throws IOException
	 */

	public String getScreenShot(WebDriver driver)
	{

		TakesScreenshot tss=(TakesScreenshot)driver;
		String tempPath = tss.getScreenshotAs(OutputType.BASE64);
		return tempPath;

	}

	public void mouseHoverAction(WebDriver driver, WebElement element)
	{

		Actions actions= new Actions(driver);
		actions.moveToElement(element).perform();

	}


	/**
	 * This method is used to  close the browser
	 * @param driver
	 */

	public  void closeBrowser(WebDriver driver)
	{

		driver.quit();
	}
	
	public String GetCurrentPageTitleMethod(WebDriver driver) {
		return driver.getTitle();
	}



}

