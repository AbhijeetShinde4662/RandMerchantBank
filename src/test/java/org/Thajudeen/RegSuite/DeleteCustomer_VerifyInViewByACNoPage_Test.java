package org.Thajudeen.RegSuite;


import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;
import Org_RMB_ObjectRepository.PageTitle;

public class DeleteCustomer_VerifyInViewByACNoPage_Test extends Base_Class {
	@Test
	public void TestCase4() {
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
		String customerId = javaUtility.FetchCustomerId(accno);
		adminCommonAction.deleteCustomerButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.DELETE_CUSTOMER);
		deleteCustomerPage.delete(accno, customerId, "fake");
		String deleteText = webDriverUtility.alertHandle(driver);
		System.out.println(deleteText);
		adminCommonAction.adminHomeButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_HOME_PAGE);
		adminCommonAction.viewCustomerbyAccountNoButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.VIEW_BY_CUSTOMER_ACC_NO);
		viewCustomerByAccNoPage.ViewCustomerByAccNoMethod(accno);
		String checkText = webDriverUtility.alertHandle(driver);
		System.out.println(checkText);
		javaUtility.AssertionContainsTwoString(checkText, "Incorrect");
	}
}
