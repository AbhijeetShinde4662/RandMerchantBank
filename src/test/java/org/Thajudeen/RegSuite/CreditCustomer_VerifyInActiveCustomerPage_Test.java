package org.Thajudeen.RegSuite;

import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;
import Org_RMB_ObjectRepository.PageTitle;

public class CreditCustomer_VerifyInActiveCustomerPage_Test extends Base_Class{
	@Test
	public void TestCase3() {
		comAction.OpenAccount();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.OPEN_ACCOUNT);
		openAccountPage.createAccount(map, driver);
		String openAccountText = webDriverUtility.alertHandle(driver);
		String appNo = javaUtility.fetchNumFromAlert(openAccountText);
		comAction.StaffLoginButton();
		
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_LOGIN_PAGE);
		
		staffLoginPage.loginAction(staffid, password);
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_HOME_PAGE);
		adminCommonAction.approvePendingAcountButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.APPROVE_PENDING_ACCOUNT);
		approvePendingAccountPage.approveAccount(appNo);
		String accText = webDriverUtility.alertHandle(driver);
		String accno = javaUtility.fetchNumFromAlert(accText);
		System.out.println("AccountNumber="+accno);
		adminCommonAction.adminHomeButton();
		
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_HOME_PAGE);
		adminCommonAction.creditCustomerButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.CREDIT_CUSTOMER);
		creditCustomerPage.credit(accno, "1000");
		String creditText = webDriverUtility.alertHandle(driver);
		System.out.println(creditText);
		adminCommonAction.adminHomeButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_HOME_PAGE);
		adminCommonAction.viewCustomerbyAccountNoButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.VIEW_BY_CUSTOMER_ACC_NO);
		viewCustomerByAccNoPage.ViewCustomerByAccNoMethod(accno);
		System.out.println(viewCustomerByAccNoPage.getAmountGetText().getText());
		javaUtility.AssertionContainsTwoString("1000", viewCustomerByAccNoPage.getAmountGetText().getText());
	}
}
