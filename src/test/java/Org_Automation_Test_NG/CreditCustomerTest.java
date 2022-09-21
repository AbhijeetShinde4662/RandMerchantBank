package Org_Automation_Test_NG;

import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;

public class CreditCustomerTest extends Base_Class
{
	@Test
	public void OpenAccountTest() throws InterruptedException
	{
		comAction.OpenAccount();

		openAccountPage.createAccount(map, driver);
		String message = webDriverUtility.alertHandle(driver);
		String applicationNumber = javaUtility.fetchNumFromAlert(message);

		comAction.StaffLoginButton();

		staffLoginPage.loginAction(staffid, password);

		adminCommonAction.approvePendingAcountButton();

		approvePendingAccountPage.approveAccount( applicationNumber);
		webDriverUtility.explicitWaitMethodForAlert(driver);
		String message1 = webDriverUtility.alertHandle(driver);
		String accountNumber = javaUtility.fetchNumFromAlert(message1);
		webDriverUtility.verifyAccountNumber(driver, accountNumber);
		
		adminCommonAction.adminHomeButton();

		adminCommonAction.creditCustomerButton();

		creditCustomerPage.credit(accountNumber, "1500");
		
		String message2 = webDriverUtility.alertHandle(driver);
		System.out.println(message2);
		
		webDriverUtility.testCaseValidationUsingSoftAssert(message2, "Amount credited Successfully to customer account");
		
		
	
		

	}
}
