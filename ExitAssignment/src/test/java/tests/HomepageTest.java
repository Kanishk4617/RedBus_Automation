package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomepageFunctionality;
import utils.CommonUtils;

public class HomepageTest extends BaseTest {
	// sheet name which is used by all tests
	private String sheetName = "HomePageFunctionality";
	@Test
	public void whenUserClicksOnrpoolLink() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnrpoolLink";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("rPool button Functionality test");

		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.rpoolClick();
		logger.info("rPool button is clicked");
		Thread.sleep(2000);
		
		String str = driver.getTitle();
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}
	
	@Test
	public void whenUserClicksOnBusHireLink() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnBusHireLink";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Bus Hire button Functionality test");

		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.busHireClick();
		logger.info("Bus Hire link is clicked");
		Thread.sleep(2000);
		
		String str = driver.getTitle();
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}
	
	@Test
	public void whenUserClicksOnRedBusLogoLink() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnRedBusLogoLink";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("RedBus logo button Functionality test");

		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.redBusLogoClick();
		logger.info("RedBus logo button is clicked");
		Thread.sleep(2000);
		
		String str = driver.getTitle();
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}
	
	@Test
	public void whenUserClicksOnBusTicketsLink() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnBusTicketsLink";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Bus Tickets button Functionality test");

		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.busTicketsClick();
		logger.info("Bus Tickets button is clicked");
		Thread.sleep(2000);
		
		String str = driver.getTitle();
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}
	
	@Test
	public void whenUserClicksOnHelp() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnHelp";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Help button Functionality test");

		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.clickHelp();
		logger.info("Help button is clicked");

		hm.changeWindow();
		logger.info("Current window is help window");
		Thread.sleep(3000);

		hm.clickCross();
		logger.info("Cross Button is clicked");
		String str = driver.getTitle();
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
		hm.closeWindow();
		logger.info("Help window is closed");
	}
}
