package Org_Automation_Test_NG;

import java.time.Duration;
import java.util.Map;

import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;

public class AccountOpeningTest extends Base_Class
{
	@Test
	public void accountOpening() throws Throwable
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

		comAction.HomeButton();

		webDriverUtility.verifyAccountNumber(driver, accountNumber);
		webDriverUtility.testCaseValidationUsingSoftAssert(message1, "Account Created Successfully");




	}

}
