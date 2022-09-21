package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage
{
	@FindBy(xpath="//input[@name='staff_id']")
	private WebElement staffIdTextfield;
	
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextfiled;
	
	@FindBy(xpath="//input[@name='staff_login-btn']")
	private WebElement loginButton;
	
	public  StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginAction(String staffId, String password)
	{
		staffIdTextfield.sendKeys(staffId);
		passwordTextfiled.sendKeys(password);
		loginButton.click();
	}
}
