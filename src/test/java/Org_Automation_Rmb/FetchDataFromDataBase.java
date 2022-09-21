package Org_Automation_Rmb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Org.GenericUtility.DataBaseUtility;
import Org.GenericUtility.FetchDataFromProperties;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws IOException, SQLException
	{
		FetchDataFromProperties fetchDataFromProperties=new  FetchDataFromProperties();
		
		String dburl = fetchDataFromProperties.getDataFromProperty("DBurl");
		String dbusername = fetchDataFromProperties.getDataFromProperty("DBusername");
		String dbpassword = fetchDataFromProperties.getDataFromProperty("DBpassword");
		String query="select * from students;";
		String col_num="address";
		
		DataBaseUtility dataBaseUtility= new DataBaseUtility();
		
		dataBaseUtility.openDataBase(dburl, dbusername, dbpassword);
		
		List<String> value = dataBaseUtility.getDataFromDataBase(query, col_num);
		
		System.out.println(value);
		
		
		boolean result = dataBaseUtility.verifyDataInDataBase(query, col_num, "Kadapur");
		
		System.out.println(result);
		
		
		
		 dataBaseUtility.addDataToDataBase("insert into students value(10,'Hari',77889966,'Andra Pradesh');");
		
		dataBaseUtility.closeDataBase();

	}

}
