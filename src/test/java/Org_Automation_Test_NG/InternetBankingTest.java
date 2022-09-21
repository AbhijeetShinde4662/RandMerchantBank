package Org_Automation_Test_NG;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;

public class InternetBankingTest extends Base_Class
{
	@Test
	public void accountOpening() throws InterruptedException 
	{

		comAction.OpenAccount();

		openAccountPage.createAccount(map, driver);
		String message = webDriverUtility.alertHandle(driver);
		String applicationNumber = javaUtility.fetchNumFromAlert(message);

		comAction.StaffLoginButton();

		staffLoginPage.loginAction(staffid, password);

		adminCommonAction.approvePendingAcountButton();

		approvePendingAccountPage.approveAccount( applicationNumber);
		//webDriverUtility.explicitWaitMethodForAlert(driver);
		String message1 = webDriverUtility.alertHandle(driver);
		String accountNumber = javaUtility.fetchNumFromAlert(message1);

		webDriverUtility.verifyAccountNumber(driver, accountNumber);
		adminCommonAction.adminLogoutButton();
		comAction.HomeButton();
		comAction.ApplyDebitCardButton();
		applyDebitCardPage.applyDbCard(map, accountNumber);
		
		String message2 = webDriverUtility.alertHandle(driver);
		System.out.println(message2);
		
		String debitInfo = javaUtility.fetchNumFromAlert(message2);
		System.out.println(debitInfo);
		
		String debitCardNumber = javaUtility.FetchDebitCardNumber(debitInfo);
		System.out.println(debitCardNumber);

		String debitCardPinNumber = javaUtility.FetchDebitCardPin(debitInfo);
		System.out.println(debitCardPinNumber);

		comAction.HomeButton();

		WebElement ibButton = comAction.internetBankButton();

		webDriverUtility.mouseHoverAction(driver, ibButton);

		comAction.iBRegisterButton();
		ibRegistrationPage.createAccount(map, accountNumber, debitCardNumber, debitCardPinNumber);






	}

}
