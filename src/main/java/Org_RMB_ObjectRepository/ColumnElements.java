package Org_RMB_ObjectRepository;

public enum ColumnElements {
	USERNAME("Username"), CUSTOMERID("Customer ID"), ACCOUNTNO("Account No."), MOBILENO("Mobile No."),EMAILID("Email ID"), DOB("DOB"), CURRENT_BALANCE("Current Balance"), PAN("PAN"),
	CITIZENSHIP("Citizenship"), DEBIT_CARD_NO("Debit Card No."), LAST_LOGIN("Last_Login"), LAST_TRANSACTION("LastTransaction"), ACCOUNT_STATUS("Account Status");
	private String columnElements;
	private ColumnElements(String columnElements) {
		this.columnElements = columnElements;
	}
	public String getColumnElements() {
		return columnElements;
	}
}
