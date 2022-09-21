package Org_Automation_Test_NG;

import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;

public class DeleteCustomerTest extends Base_Class
{
	@Test
	public void deleteCustomer() throws InterruptedException
	{
		comAction.OpenAccount();

		openAccountPage.createAccount(map, driver);
		String message = webDriverUtility.alertHandle(driver);
		String applicationNumber = javaUtility.fetchNumFromAlert(message);

		comAction.StaffLoginButton();

		staffLoginPage.loginAction(staffid, password);

		adminCommonAction.approvePendingAcountButton();

		approvePendingAccountPage.approveAccount( applicationNumber);
		
		String message1 = webDriverUtility.alertHandle(driver);
		System.out.println(message1);
		String accountNumber = javaUtility.fetchNumFromAlert(message1);
		System.out.println(accountNumber);
		webDriverUtility.verifyAccountNumber(driver, accountNumber);
		
		String customerID = javaUtility.FetchCustomerId(accountNumber);
		System.out.println(customerID);
		
		adminCommonAction.adminHomeButton();
		adminCommonAction.deleteCustomerButton();
		deleteCustomerPage.delete(accountNumber, customerID, "The Account This inactive since 01 year");

		
		
		String message2 = webDriverUtility.alertHandle(driver);
		System.out.println(message2);
		
		webDriverUtility.testCaseValidationUsingSoftAssert(message2, "Customer Deleted Successfully");

		
		

	}
}
