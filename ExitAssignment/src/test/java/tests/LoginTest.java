package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void invalidPhone() throws Throwable {
		extentTest = extent.startTest("invalid login functionality test");
		LoginPage login = new LoginPage(driver);
		login.iconClick();
		login.signInClick();
//		login.switchIframe();
		login.enterContact("123456");
		if(login.checkVisibility())
		{
			System.out.println("passed");
		}
	}
	
	@Test
	public void invalidCountryCode() throws Throwable {
		extentTest = extent.startTest("invalid country code functionality test");
		LoginPage login = new LoginPage(driver);
		login.iconClick();
		
		login.signInClick();
		login.enterContact("1234567890");
		logger.info("contact is enetered");
		login.selectCountry();
		logger.info("country is selected");
		login.clickCaptcha();
		logger.info("captcha is clicked");
		login.getOtp();
		logger.info("otp is clicked");
		if(login.getError())
		{
			System.out.println("passed");
		}
	}

}
