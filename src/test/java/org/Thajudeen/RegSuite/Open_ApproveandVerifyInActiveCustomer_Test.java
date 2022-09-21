package org.Thajudeen.RegSuite;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;
import Org_RMB_ObjectRepository.ColumnElements;
import Org_RMB_ObjectRepository.PageTitle;

public class Open_ApproveandVerifyInActiveCustomer_Test extends Base_Class {
	@Test
	public void TestCase1() {
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
		adminCommonAction.viewCustomerbyAccountNoButton();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(driver), PageTitle.VIEW_ACTIVE_CUSTOMER_PAGE);
		List<WebElement> columnElements = viewActiveCustomerPage.GetTableColumnElements();
		int count = viewActiveCustomerPage.CheckDataInViewCustomerPage(driver, accno, columnElements, ColumnElements.ACCOUNTNO);
		javaUtility.AssertionCheckTrue(count==1);
		adminCommonAction.adminHomeButton();
		adminCommonAction.adminLogoutButton();
	}

}

