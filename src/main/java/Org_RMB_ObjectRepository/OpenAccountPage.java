package Org_RMB_ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.GenericUtility.JavaUtility;
import Org.GenericUtility.WebDriverUtility;

public class OpenAccountPage 
{
	//Declaration

	@FindBy(xpath="//input[@name='name']")
	private WebElement nameTextfiled;

	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobilenumberTextfiled;

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailidTextfiled;

	@FindBy(xpath="//input[@name='landline']")
	private WebElement landlinenumberTextfiled;

	@FindBy(xpath="//input[@name='pan_no']")
	private WebElement pannumberTextfiled;

	@FindBy(xpath="//input[@name='citizenship']")
	private WebElement citizenshipTextfiled;

	@FindBy(xpath="//input[@name='homeaddrs']")
	private WebElement homeadressTextfiled;

	@FindBy(xpath="//input[@name='officeaddrs']")
	private WebElement officeadressTextfiled;

	@FindBy(xpath="//input[@name='pin']")
	private WebElement pincodeTextfiled;

	@FindBy(xpath="//input[@name='arealoc']")
	private WebElement arealocationTextfiled;

	@FindBy(xpath="//input[@name='nominee_name']")
	private WebElement nomineenameTextfiled;

	@FindBy(xpath="//input[@name='nominee_ac_no']")
	private WebElement nomineeaccountnumberTextfiled;

	@FindBy(xpath="//input[@name='dob']")
	private WebElement dobDropDown;

	@FindBy(xpath="//select[@name='gender']")
	private WebElement genderDropDown;

	@FindBy(xpath="//select[@name='state']")
	private WebElement stateDropDown;

	@FindBy(xpath="//select[@name='city']")
	private WebElement cityDropDown;

	@FindBy(xpath="//select[@name='acctype']")
	private WebElement accounttype;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitButton;

	@FindBy(xpath="//input[@name='cnfrm-submit']")
	private WebElement confirmButton;

	//Initialisation

	public OpenAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Business Library

	public void createAccount(Map<String, String> map, WebDriver driver )
	{
	
	   
		
		nameTextfiled.sendKeys(map.get("Name"));
		mobilenumberTextfiled.sendKeys(map.get("Mobile No"));
		emailidTextfiled.sendKeys(map.get("EmailId"));
		landlinenumberTextfiled.sendKeys(map.get("Landline NO"));
		pannumberTextfiled.sendKeys(map.get("Pan NO"));
		citizenshipTextfiled.sendKeys(map.get("Citizenship"));
		homeadressTextfiled.sendKeys(map.get("Homeads"));
		officeadressTextfiled.sendKeys(map.get("Officeads"));
		pincodeTextfiled.sendKeys(map.get("Pincode"));
		arealocationTextfiled.sendKeys(map.get("Locality"));
		nomineenameTextfiled.sendKeys(map.get("NomanName"));
		nomineeaccountnumberTextfiled.sendKeys(map.get("Nom No."));
		
		dobDropDown.click();
		dobDropDown.sendKeys(map.get("DOB"));

		WebDriverUtility webDriverUtility = new WebDriverUtility();
		webDriverUtility.dropDownHandle(genderDropDown, "Male");
		webDriverUtility.dropDownHandle(stateDropDown, "Alaska");
		webDriverUtility.dropDownHandle(cityDropDown, "Olympia");
		webDriverUtility.dropDownHandle(accounttype, "Saving");
		
		submitButton.click();
		
		confirmButton.click();
		
		
	}





}
