package Org_RMB_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerByAccNoPage {
	@FindBy(name = "view_cust_by_ac") private WebElement viewCustomerByAccNoLink;
	@FindBy(name = "account_no") private WebElement viewCustomerAccTextField;
	@FindBy(name = "submit_view") private WebElement submitButton;
	@FindBy(xpath = "//label[contains(text(),'Available Balance')]") private WebElement amountGetText;
	public ViewCustomerByAccNoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAmountGetText() {
		return amountGetText;
	}
	
	public void ViewCustomerByAccNoLinkClick() {
		viewCustomerByAccNoLink.click();;
	}
	public void ViewCustomerByAccNoMethod(String AccountNo) {
		viewCustomerAccTextField.sendKeys(AccountNo);
		submitButton.click();
	}
}
