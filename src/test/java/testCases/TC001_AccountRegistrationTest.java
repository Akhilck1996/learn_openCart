package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.RegisterAccount;
import pageObjects.YourStore_HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"sanity"})
	public void test_AccountRegistration()
	{
		
		logger.info("*************starting TC001_AccountRegistrationTest ******************** ");
		YourStore_HomePage hp=new YourStore_HomePage(driver);
		
		logger.info("*************clicking my account and register ******************** ");
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegisterAccount rg= new RegisterAccount(driver);
		logger.info("************* filling personal details ******************** ");
		rg.fillPersonalDetails(generateRandomString(), generateRandomString(), generateRandomEmail(),generateRandomNumber());
		String password=generateRandomAlphaNumeric();
		
		rg.enterPassword(password);
		rg.clickCheckBox();
		rg.clickContinueBtn();
		logger.info("*************Finished TC001_AccountRegistrationTest ******************** ");
		
		Assert.assertEquals(rg.getConfirmationMsgAccCreated(), "Your Account Has Been Created!");
		
		
		
	}
	
	
}
