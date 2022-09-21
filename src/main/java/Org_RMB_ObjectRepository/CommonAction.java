 package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonAction 
{
	@FindBy(xpath="//li[.='Open Account']")
	private WebElement openAccountButton;
	
	@FindBy(xpath="//li[.='Apply Debit Card']")
	private WebElement applyDebitCardButton;
	
	@FindBy(xpath="//div[@class='ebanking']")
	private WebElement InternetBankingButton;
	
	@FindBy(xpath="//li[.='Fund Transfer']")
	private WebElement fundTransperButton;
	
	@FindBy(xpath="//a[.='Staff Login']")
	private WebElement staffLoginButton;
	
	@FindBy(xpath="//a[.='Home']")
	private WebElement homeButton;
	
	@FindBy(xpath="//li[.='Login ']")
	private WebElement IBLoginButton;
	
	@FindBy(xpath="//li[.='Register']")
	private WebElement IBRegisterButton;
	
	public CommonAction(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	public void OpenAccount()
	{
		openAccountButton.click();
	}
	
	public void ApplyDebitCardButton()
	{
		applyDebitCardButton.click();
	}
	
	public WebElement internetBankButton()
	{
		return InternetBankingButton;
	}
	
	public void FundTransperButton()
	{
		fundTransperButton.click();
	}
	
	public void StaffLoginButton()
	{
		staffLoginButton.click();
	}
	
	public void HomeButton()
	{
		homeButton.click();
	}
	public void iBLoginButton()
	{
		IBLoginButton.click();
	}
	public void iBRegisterButton()
	{
		IBRegisterButton.click();
	}
}
