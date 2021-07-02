package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.SocialMediaHandlePage;
import utils.CommonUtils;

//includes test for social media handle
public class SocialMediaHandleTest extends BaseTest {

	private String sheetName = "SocialMediaHandleTest";

	@Test
	public void userClicksFacebookIcon() throws Throwable {
		String testName = "userClicksFacebookIcon";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedUrl = testData.get("Expected URL");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);
		extentTest = extent.startTest("Facebook button functionality test");

		SocialMediaHandlePage socialMedia = new SocialMediaHandlePage(driver);
		socialMedia.busTicketsClick();
		logger.info("Bus Tickets button is clicked");

		socialMedia.fbIconClick();
		logger.info("facebook button is clicked");
		Thread.sleep(2000);

		String str = driver.getCurrentUrl();
		if (str.equals(expectedUrl)) {
			Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
			logger.info("test case failed");
		}
	}

	@Test
	public void userClicksTwitterIcon() throws Throwable {
		String testName = "userClicksTwitterIcon";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedUrl = testData.get("Expected URL");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);
		extentTest = extent.startTest("Twitter button functionality test");

		SocialMediaHandlePage socialMedia = new SocialMediaHandlePage(driver);
		socialMedia.busTicketsClick();
		logger.info("Bus Tickets button is clicked");

		socialMedia.twitterIconClick();
		logger.info("twitter button is clicked");
		Thread.sleep(2000);

		String str = driver.getCurrentUrl();
		if (str.equals(expectedUrl)) {
			Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
			logger.info("test case failed");
		}
	}

}
