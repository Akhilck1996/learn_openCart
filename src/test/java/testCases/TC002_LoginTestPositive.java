package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.MyAccountPage;
import pageObjects.YourStore_HomePage;
import testBase.BaseClass;

public class TC002_LoginTestPositive extends BaseClass{

	@Test(groups={"sanity"})
	public void test_LoginFuntionality()
	{
		YourStore_HomePage hp=new YourStore_HomePage(driver);
		hp.clickMyAccount();
		hp.clickLnkLogin();
		
		AccountLoginPage alp=new AccountLoginPage(driver);
		
		alp.enterEmailAdress(rb.getString("email"));
		alp.enterPassword(rb.getString("password"));
		alp.clickLoginBtn();
		
		MyAccountPage map=new MyAccountPage(driver);
		
		boolean status=map.isMyAccountDisplayed();
		
		Assert.assertEquals(status, true);
		
	}
	
	
}
