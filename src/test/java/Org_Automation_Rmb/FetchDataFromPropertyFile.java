package Org_Automation_Rmb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile
{
	public static void main(String[] args) throws IOException {
		
	
	FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
	
	
	 Properties prop= new Properties();
	 
	 prop.load(fis);
	
	 String url = prop.getProperty("url");
	String staffid = prop.getProperty("StaffId");
	 String password = prop.getProperty("Password");
	 
	 System.out.println(url);
	 System.out.println(staffid); 
	 System.out.println( password);
	 
	
	}	 
}

