package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingLoginPage
{
	@FindBy(xpath="//input[@name='customer_id']")
	private WebElement CustomerIdTextfield;
	
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement PasswordTextfiled;
	
	@FindBy(xpath="//input[@name='login-btn']")
	private WebElement loginButton;
	
	public  InternetBankingLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void IBloginAction(String staffId, String password)
	{
		CustomerIdTextfield.sendKeys(staffId);
		PasswordTextfiled.sendKeys(password);
		loginButton.click();
	}
}
