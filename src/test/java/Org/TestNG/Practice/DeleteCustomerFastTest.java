package Org.TestNG.Practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;

public class DeleteCustomerFastTest extends Base_Class
{
	@Test (invocationCount = 5)
	public void deleteCustomer() throws InterruptedException
	{

		comAction.StaffLoginButton();

		staffLoginPage.loginAction(staffid, password);

		
		
	
			adminCommonAction.viewActiveCustomerButton();

			String accountNumber = driver.findElement(By.xpath("//th[.='#']/parent::tr/following::tr/td[4]")).getText();
			String customerID = driver.findElement(By.xpath("//th[.='#']/parent::tr/following::tr[1]/td[3]")).getText();

			adminCommonAction.adminHomeButton();
			adminCommonAction.deleteCustomerButton();
			deleteCustomerPage.delete(accountNumber, customerID, "The Account This inactive since 01 year");
			webDriverUtility.alertHandle(driver);

			System.out.println("Account deleted successfully"+accountNumber);
			Thread.sleep(2000);
		




	}
}
