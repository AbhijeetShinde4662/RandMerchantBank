package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprovePendingAccountPage
{
	@FindBy(xpath="//input[@name='application_no']")
	private WebElement applicationNumberTextField;

	@FindBy(xpath="//input[@name='search_application']")
	private WebElement searchButton;


	@FindBy(xpath="//input[@name='approve_cust']")
	private WebElement approveButton;



	public  ApprovePendingAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void approveAccount(String application_num) throws InterruptedException
	{
		applicationNumberTextField.sendKeys(application_num);

		searchButton.click();
		Thread.sleep(2000);
		approveButton.click();
		Thread.sleep(3000);
	}

}
