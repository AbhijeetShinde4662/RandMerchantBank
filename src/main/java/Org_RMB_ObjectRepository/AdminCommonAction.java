package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is used to create object repository of adminpage common actions
 * 
 * @author Shinde
 *
 */
public class AdminCommonAction 
{
	@FindBy(xpath="//input[@name='viewdet']")
	private WebElement ViewActiveCustomerButton;
	
	@FindBy(xpath="//input[@name='view_cust_by_ac']")
	private WebElement ViewCustomerbyAccountNoButton;
	
	@FindBy(xpath="//input[@name='apprvac']")
	private WebElement ApprovePendingAcountButton;
	
	@FindBy(xpath="//input[@name='del_cust']")
	private WebElement DeleteCustomerButton;
	
	@FindBy(xpath="//input[@name='credit_cust_ac']")
	private WebElement CreditCustomerButton;
	
	@FindBy(xpath="//input[@name='home']")
	private WebElement AdminHomeButton;
	
	@FindBy(xpath="//input[@name='logout_btn']")
	private WebElement AdminLogoutButton;
	
	public AdminCommonAction(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void viewActiveCustomerButton()
	{
		ViewActiveCustomerButton.click();
	}
	
	public void viewCustomerbyAccountNoButton()
	{
		ViewCustomerbyAccountNoButton.click();
	}
	
	public void approvePendingAcountButton()
	{
		 ApprovePendingAcountButton.click();
	}
	public void deleteCustomerButton()
	{
		DeleteCustomerButton.click();
	}
	
	public void creditCustomerButton()
	{
		CreditCustomerButton.click();
	}
	
	
	
	public void adminHomeButton()
	{
		AdminHomeButton.click();
	}
	
	public void adminLogoutButton()
	{
		AdminLogoutButton.click();
	}
}
