package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage
{
	@FindBy(xpath="//input[@name='Cust_ac_no']")
	private WebElement accountNumberTextField;
	
	@FindBy(xpath="//input[@name='Cust_ac_Id']")
	private WebElement CustomerIdTextField;
		
	@FindBy(xpath="//input[@name='reason']")
	private WebElement reasonTextField;
	
	@FindBy(xpath="//input[@name='delete']")
	private WebElement DeleteButton;
	
	
	
	public  DeleteCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void delete(String number, String Id, String reason) 
	{
		accountNumberTextField.sendKeys(number);
	
		CustomerIdTextField.sendKeys(Id);
	
		reasonTextField.sendKeys(reason);
	
		DeleteButton.click();
	}
	
	
}
