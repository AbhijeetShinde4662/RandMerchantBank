package Org.GenericUtility;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility
{
	Connection connection;

	
	 public void openDataBase(String DBurl, String DBusername, String DBpassword) throws SQLException
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		connection=DriverManager.getConnection(DBurl, DBusername, DBpassword);

	}

	public List<String> getDataFromDataBase( String query, String Col_name) throws SQLException
	{

		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list= new ArrayList<String>();
		while(result.next())
		{

			list.add(result.getString(Col_name));
		}


		return list;
	}
	public void addDataToDataBase( String query) throws SQLException 
	{

		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		System.out.println("Data Updated  "+result);

	}

	public boolean verifyDataInDataBase(String query, String Col_name,String expecteddata ) throws SQLException 
	{
		List<String> list = getDataFromDataBase(query, Col_name);
		boolean flag = false;
		for (String actualdata : list) 
		{
			if(actualdata.equalsIgnoreCase(expecteddata))
			{
				flag=true;
				
			}
		}
		return flag;
	}

	
	
	public void closeDataBase() throws SQLException
	{

		connection.close();

	}
}
