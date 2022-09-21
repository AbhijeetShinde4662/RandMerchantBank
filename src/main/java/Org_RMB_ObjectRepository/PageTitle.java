package Org_RMB_ObjectRepository;


public enum PageTitle {
	CUSTOMER_HOME_PAGE("Online Banking System"), OPEN_ACCOUNT("Registration Form"), APPLY_DEBIT_CARD("Apply Debit Card"), 
	INTERNET_BANKING_LOGIN("Login Page"), INTERNET_BANKING_REGISTRATION("Internet Banking Registration"),
	FUND_TRANSFER("Login Page"), STAFF_LOGIN_PAGE("Staff Page"), STAFF_HOME_PAGE("Staff Home"),
	VIEW_ACTIVE_CUSTOMER_PAGE("Active Customers"), VIEW_BY_CUSTOMER_ACC_NO("Customer Details"), 
	DELETE_CUSTOMER("Delete Customer"), CREDIT_CUSTOMER("Staff Home"), APPROVE_PENDING_ACCOUNT("Pending Customers");
	
	private String pageTitle;
	private PageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public String getPageTitle() {
		return pageTitle;
	}
}
