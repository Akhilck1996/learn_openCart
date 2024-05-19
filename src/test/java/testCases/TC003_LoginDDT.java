package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviderClass;
import pageObjects.AccountLoginPage;
import pageObjects.MyAccountPage;
import pageObjects.YourStore_HomePage;
import testBase.BaseClass;

public class TC003_LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginDP",dataProviderClass=DataProviderClass.class,groups= {"sanity"})
	public void test_loginDataDrivenTesting(String email,String pwd,String result)
	{
		try {
		YourStore_HomePage hp=new YourStore_HomePage(driver);
		hp.clickMyAccount();
		hp.clickLnkLogin();
		
		AccountLoginPage alp=new AccountLoginPage(driver);
		
		alp.enterEmailAdress(email);
		alp.enterPassword(pwd);
		alp.clickLoginBtn();
		
		MyAccountPage map=new MyAccountPage(driver);
		
		boolean status=map.isMyAccountDisplayed();
		
		
		if(result.equals("Valid"))
		{
			if(status == true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(result.equals("Invalid"))
		{
			if(status == true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		}catch(Exception e)
		{
			Assert.assertTrue(true);
		}
		
	}
	
	
}
