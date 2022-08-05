package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.utilites.XLUils;

public class TC_LoginDDT_001 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			lp.clickLogout();
			
			driver.switchTo().alert().accept();//close the logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() {//user defined method to check alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	String [][]getData() throws IOException{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
		
		int rownum = XLUils.getRowCount(path, "sheet1");
		int cocount = XLUils.getCellCount(path,"sheet1",1);
		
		String logindata[][] = new String [rownum][cocount];
		
		for(int i =1; i<=rownum; i++) {
			
			for(int j=0; j<cocount;j++) {
				
				logindata[i-1][j]=XLUils.getCellData(path, "Sheet1", i, j);//1 0 2 dimentioanl array its starts from 0
			
			}
		}
		return logindata;
	
	}
}
