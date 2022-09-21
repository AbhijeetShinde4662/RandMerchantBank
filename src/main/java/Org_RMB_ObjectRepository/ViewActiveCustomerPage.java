package Org_RMB_ObjectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewActiveCustomerPage {
	@FindBy(name = "viewdet") private WebElement viewActiveCustomerLink;
	@FindBy(xpath = "//div[@class='active_customers_container']/descendant::tr/th") private List<WebElement> getTableColumnElements;
	
	public ViewActiveCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ViewActiveCustomerLinkClick() {
		viewActiveCustomerLink.click();
	}
	public List<WebElement> GetTableColumnElements() {
		return getTableColumnElements;
	}
	public int CheckDataInViewCustomerPage(WebDriver driver,String check, List<WebElement> ColumnElemets, ColumnElements columnElement) {
		List<WebElement> AccountNumberCheck = new ArrayList<WebElement>();
		int count = 0;
		for(int i=0; i<ColumnElemets.size(); i++) {
			String ColumnName = ColumnElemets.get(i).getText();
			if(ColumnName.equals(columnElement.getColumnElements())) {
				AccountNumberCheck = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td["+(i+1)+"]"));
				break;
			}
		}
		for(int i =0; i<AccountNumberCheck.size(); i++) {
			if((AccountNumberCheck.get(i).getText()).equals(check)) {
				count++;
				break;
			}
		}
		return count;
	}
}
