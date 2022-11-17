package org.Thajudeen.RegSuite;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;
import Org_RMB_ObjectRepository.ColumnElements;
import Org_RMB_ObjectRepository.PageTitle;

public class ApplyDebitCard_CheckinActiveCustomer_Test extends Base_Class {
	@Test
	public void TestCase2Test() {
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
		adminCommonAction.adminLogoutButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_LOGIN_PAGE);
		comAction.HomeButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.CUSTOMER_HOME_PAGE);
		comAction.ApplyDebitCardButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.APPLY_DEBIT_CARD);
		applyDebitCardPage.applyDbCard(map, accno);
		String debitCardAlert = webDriverUtility.alertHandle(driver);
		String debitCardNo = javaUtility.FetchDebitCardNumber(debitCardAlert);
		comAction.StaffLoginButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_LOGIN_PAGE);
		
		staffLoginPage.loginAction(staffid, password);
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.STAFF_HOME_PAGE);
		adminCommonAction.viewActiveCustomerButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.VIEW_ACTIVE_CUSTOMER_PAGE);
		List<WebElement> columnElements = viewActiveCustomerPage.GetTableColumnElements();
		int count = viewActiveCustomerPage.CheckDataInViewCustomerPage(driver, debitCardNo, columnElements, ColumnElements.DEBIT_CARD_NO);
		javaUtility.AssertionCheckTrue(count==1);
	}

}
