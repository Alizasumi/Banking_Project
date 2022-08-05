package com.inetbanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.Add_CustomerPage;
import com.inetbanking.pageobject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		Add_CustomerPage addcust = new Add_CustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		addcust.custName("Aliza");
		addcust.custgender("female");
		addcust.custdob("1987","07","23");
		Thread.sleep(3000);
		addcust.custaddress("Canada");
		addcust.custcity("Scarborough");
		addcust.custstate("ON");
		addcust.custpinno("75446899");
		addcust.custtelepheno("9877900777");
		
		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
//		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res =driver.getPageSource().contains("Connection failed: Access denied for user 'root'@'localhost' (using password: NO)");
		if(res==true) {
			Assert.assertTrue(true);
		}else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
