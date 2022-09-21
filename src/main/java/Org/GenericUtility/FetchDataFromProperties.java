package Org.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is used to fetch data from Property files
 * @author Shinde
 *
 */
public class FetchDataFromProperties
{
	public  String getDataFromProperty(String key) throws IOException {

		FileInputStream fis= new FileInputStream(FrameworkConstants.PROPERTIES_PATH);
		Properties prop= new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		
		return value;
	}
}