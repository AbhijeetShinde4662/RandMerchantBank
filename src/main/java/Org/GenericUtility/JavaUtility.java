
package Org.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;

/**
 * This class is used to fetch data from alert message
 * @author Shinde
 *
 */
public class JavaUtility 
{
	public  String fetchNumFromAlert(String alertmsege)
	{

		String number="";

		for(int j=0; j<alertmsege.length(); j++) 
		{
			char ch = alertmsege.charAt(j);

			if((ch>=48)&&(ch<=57)) 
			{
				number = number + ch;
			}
		}

		return number;
	}

	/**
	 * This method is used to fetch debit card number from the method
	 * 
	 * @param debitcarddetails
	 * @return
	 */
	public  String FetchDebitCardNumber(String debitcarddetails)
	{

		String cardno ="";

		for(int l =0; l<debitcarddetails.length(); l++)
		{
			if(l<=11) 
			{
				cardno = cardno + debitcarddetails.charAt(l);
			}


		}
		return cardno;
	}	

	/**
	 * This method is used to fetch debit card pin 
	 * @param debitcarddetails
	 * @return
	 */

	public  String FetchDebitCardPin(String debitcarddetails)
	{

		String cardpin ="";

		for(int l =0; l<debitcarddetails.length(); l++)
		{
			if(l>11) 
			{
				cardpin = cardpin + debitcarddetails.charAt(l);
			}


		}
		return cardpin;
	}

	/**
	 * This method is used fetch customer Id from the method
	 * @param accountnumber
	 * @return
	 */

	public  String FetchCustomerId(String accountnumber)
	{

		String customer_Id ="";

		for(int l =0; l<accountnumber.length(); l++)
		{
			if(l>=6) 
			{
				customer_Id = customer_Id + accountnumber.charAt(l);
			}


		}
		return customer_Id;
	}
	/**
	 * This method is used to generate random Number
	 * @return
	 */
	public int generateRandomNumber()
	{
		Random random = new Random();
		int num = random.nextInt();
		return num;
		
	}
	
	
	/**
	 * This method is used to generate simple Date format
	 * @return
	 */
	public String currentTime()
	{
		Date date= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualDate = sdf.format(date);
		return actualDate;
	}
}
