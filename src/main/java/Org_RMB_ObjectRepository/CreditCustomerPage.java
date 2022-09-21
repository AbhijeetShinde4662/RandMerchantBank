package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPage
{
	@FindBy(xpath="//input[@name='customer_account_no']")
	private WebElement accountNumberTextField;
	
	@FindBy(xpath="//input[@name='credit_amount']")
	private WebElement AmountTextField;
		
	@FindBy(xpath="//input[@name='credit_btn']")
	private WebElement creditAmountButton;
	

	
	public  CreditCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void credit(String number, String amount) 
	{
		accountNumberTextField.sendKeys(number);
	
		AmountTextField.sendKeys(amount);
		
	
		creditAmountButton.click();
	}
}
