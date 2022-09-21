package Org_RMB_ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage
{
	@FindBy(xpath="//input[@name='holder_name']")
	private WebElement nameTextField;

	@FindBy(xpath="//input[@name='dob']")
	private WebElement dobTextField;

	@FindBy(xpath="//input[@name='pan']")
	private WebElement pancardTextField;

	@FindBy(xpath="//input[@name='mob']")
	private WebElement mobileNumberTextField;

	@FindBy(xpath="//input[@name='acc_no']")
	private WebElement accountNumberTextField;

	@FindBy(xpath="//input[@name='dbt_crd_submit']")
	private WebElement submitQueryButton;

	public  ApplyDebitCardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void applyDbCard(Map<String, String> map,String accountNumber) throws InterruptedException
	{
		nameTextField.sendKeys(map.get("Name"));

		dobTextField.click();
	
		dobTextField.sendKeys(map.get("DOB"));
	
		pancardTextField.sendKeys(map.get("Pan NO"));

		mobileNumberTextField.sendKeys(map.get("Mobile No"));

		accountNumberTextField.sendKeys(accountNumber);

		submitQueryButton.click();
	}
}
