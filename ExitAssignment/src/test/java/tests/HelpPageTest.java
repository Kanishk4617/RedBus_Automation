package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HelpPage;
import utils.CommonUtils;

public class HelpPageTest extends BaseTest {
	// sheet name which is used by all tests
	private String sheetName = prop.getProperty("HelpPageSheet");
	@Test
	public void WhenuserClicks_New_Bus_booking_help() throws Throwable {
		// testcase name
		String testName = "WhenuserClicks_New_Bus_booking_help";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedHeader = testData.get("Expected Header");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("New Bus Booking feature test");
		
		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		logger.info("Help button is clicked");
		
		hp.changeWindow();
		logger.info("Window is changed to help window");
		Thread.sleep(4000);

		hp.clickCross();
		logger.info("cross button is clicked");

		hp.clickNewBusBookingHelp();
		logger.info("New Bus Booking Help is clicked");
		Thread.sleep(2000);
		
		String str = hp.isNeedHelpDisaplyed();
		if (str.equals(expectedHeader)) {
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case failed");
		}
		hp.closeWindow();
		logger.info("Help window is closed");

	}
	
	@Test
	public void WhenuserClicks_Covid19_travel_Advisory() throws Throwable {
		// testcase name
		String testName = "WhenuserClicks_Covid19_travel_Advisory";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedHeader = testData.get("Expected Header");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Covid19 travel Advisory feature test");

		
		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		logger.info("Help button is clicked");

		hp.changeWindow();
		logger.info("Window is changed to help window");
		Thread.sleep(4000);
		
		hp.clickCross();
		logger.info("cross button is clicked");

		Assert.assertEquals(driver.getTitle(), "red:Care");
		hp.clickCovidTravelAdvisory();
		logger.info("Covid19 travel Advisory is clicked");
		Thread.sleep(2000);
		String str = hp.getTextfromTravelAdvisory();
		if (str.equals(expectedHeader)) {
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case failed");
		}
		hp.closeWindow();
		logger.info("Help window is closed");
	}
	
	@Test
	public void WhenuserClicks_safety_Feature() throws Throwable {
		// testcase name
		String testName = "WhenuserClicks_safety_Feature";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedHeader = testData.get("Expected Header");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Safety feature test");

		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		logger.info("Help button is clicked");

		hp.changeWindow();
		logger.info("Window is changed to help window");
		Thread.sleep(4000);
		
		hp.clickCross();
		logger.info("cross button is clicked");

		hp.clickSafetyFeature();
		logger.info("Safety feature is clicked");
		Thread.sleep(2000);
		String str = hp.getTextfromTravelAdvisory();
		if (str.equals(expectedHeader)) {
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case failed");
		}
		hp.closeWindow();
		logger.info("Help window is closed");
	}
	
	@Test
	public void WhenuserClicks_Technical_Issue_Option() throws Throwable {
		// testcase name
		String testName = "WhenuserClicks_Technical_Issue_Option";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedHeader = testData.get("Expected Header");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Technical issue feature test");

		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		logger.info("Help button is clicked");

		hp.changeWindow();
		logger.info("Window is changed to help window");
		Thread.sleep(4000);
		
		hp.clickCross();
		logger.info("cross button is clicked");

		hp.clickTechnicalIssue();
		logger.info("Technical issue option is clicked");
		Thread.sleep(2000);

		String str = hp.getTextfromTechnicalIssue();
		if (str.equals(expectedHeader)) {
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedHeader, str);
			logger.info("test case failed");
		}
		hp.closeWindow();
		logger.info("Help window is closed");
	}
}
