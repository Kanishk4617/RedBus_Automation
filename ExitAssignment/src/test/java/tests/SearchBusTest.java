package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.SearchBusPage;
import utils.CommonUtils;
//includes tests for search page

public class SearchBusTest extends BaseTest {
	// sheet name which is used by all tests
	private String sheetName = "SearchBusTest";

	@Test
	public void validSourceValidDestination() throws Throwable {
		// testcase name
		String testName = "validSourceValidDestination";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Valid source and valid destination search bus test");
		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		logger.info("Bus Ticket Button is clicked");

		search.enterSource(fromLocation);
		logger.info("Source location is entered");

		search.enterDest(toLocation);
		logger.info("Destination location is entered");

		search.selectDate(dateVal);
		logger.info(dateVal + " date is entered");

		search.clicksearch();
		logger.info("search buses button is clicked");
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
	public void validSourceInvalidDestination() throws Throwable {
		// testcase name
		String testName = "validSourceInvalidDestination";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Valid source and invalid destination search bus test");

		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		logger.info("Bus Ticket Button is clicked");

		search.enterSource(fromLocation);
		logger.info("Source location is entered");

		search.enterInvalidDestination(toLocation);
		logger.info("Invalid Destination location is entered");

		search.selectDate(dateVal);
		logger.info(dateVal + " date is entered");

		search.clicksearch();
		logger.info("search buses button is clicked");
		Thread.sleep(2000);

		String str = driver.getTitle();
		System.out.println(str);
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case valid");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}

	@Test
	public void InvalidSourceValidDestination() throws Throwable {
		// testcase name
		String testName = "InvalidSourceValidDestination";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Invalid source and Valid destination search bus test");

		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		logger.info("Bus Ticket Button is clicked");

		search.enterInvalidSource(fromLocation);
		logger.info("Invalid Source location is entered");

		search.enterDest(toLocation);
		logger.info("Valid Destination location is entered");

		search.selectDate(dateVal);
		logger.info(dateVal + " date is entered");

		search.clicksearch();
		logger.info("search buses button is clicked");
		Thread.sleep(2000);

		String str = driver.getTitle();
		System.out.println(str);
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case valid");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}

	@Test
	public void InvalidSourceInvalidDestination() throws Throwable {
		String testName = "InvalidSourceInvalidDestination";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String dateVal = testData.get("Date");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Invalid source and Invalid destination search bus test");

		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		logger.info("Bus Ticket Button is clicked");

		search.enterInvalidSource(fromLocation);
		logger.info("Invalid Source location is entered");

		search.enterInvalidDestination(toLocation);
		logger.info("Valid Destination location is entered");

		search.selectDate(dateVal);
		logger.info(dateVal + " date is entered");

		search.clicksearch();
		logger.info("search buses button is clicked");
		Thread.sleep(2000);

		String str = driver.getTitle();
		System.out.println(str);
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case valid");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}

	}
}
