package Org_RMB_ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.GenericUtility.JavaUtility;
import Org.GenericUtility.WebDriverUtility;

public class IBRegistrationPage 
{
	//Declaration

	@FindBy(xpath="//input[@name='holder_name']")
	private WebElement nameTextfiled;

	@FindBy(xpath="//input[@name='accnum']")
	private WebElement AccountnumberTextfiled;

	@FindBy(xpath="//input[@name='dbtcard']")
	private WebElement DebitCardTextfiled;

	@FindBy(xpath="//input[@name='dbtpin']")
	private WebElement DebitCardPinTextfiled;

	@FindBy(xpath="//input[@name='mobile']")
	private WebElement MobilenumberTextfiled;

	@FindBy(xpath="//input[@name='pan_no']")
	private WebElement PanTextfiled;

	@FindBy(xpath="//input[@name='dob']")
	private WebElement DobTextfiled;

	@FindBy(xpath="//input[@name='last_trans']")
	private WebElement LastTransactionTextfiled;

	@FindBy(xpath="//input[@name='password']")
	private WebElement PasswordTextfiled;

	@FindBy(xpath="//input[@name='cnfrm_password']")
	private WebElement cnfPasswordTextfiled;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement SubmitButton;

	

	//Initialisation

	public IBRegistrationPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Business Library

	public void createAccount(Map<String, String> map, String accountnumber, String debitcardNumber, String debitPinNumber ) throws InterruptedException
	{
	

		
		nameTextfiled.sendKeys(map.get("Name"));
		Thread.sleep(2000);
		AccountnumberTextfiled.sendKeys(accountnumber);
		DebitCardTextfiled.sendKeys(debitcardNumber);
		DebitCardPinTextfiled.sendKeys(debitPinNumber);
		MobilenumberTextfiled.sendKeys(map.get("Mobile No"));
		Thread.sleep(2000);
		PanTextfiled.sendKeys(map.get("Pan NO"));
		Thread.sleep(2000);
		LastTransactionTextfiled.sendKeys("0");
		Thread.sleep(2000);
		DobTextfiled.click();
		DobTextfiled.sendKeys(map.get("DOB"));
		Thread.sleep(2000);
		PasswordTextfiled.sendKeys("Abhi@12345");
		Thread.sleep(2000);
		cnfPasswordTextfiled.sendKeys("Abhi@12345");
		Thread.sleep(2000);
		SubmitButton.click();
		
		
		
		
		
		SubmitButton.click();
		Thread.sleep(2000);
		
		
		
		
	}





}
