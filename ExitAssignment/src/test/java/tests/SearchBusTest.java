package tests;

import java.util.HashMap;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.SearchBusPage;
import utils.CommonUtils;

public class SearchBusTest extends BaseTest {
	private String sheetName = "SearchBusTest";
	@Test
	public void validSourceValidDestination() throws Throwable {
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
		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		search.enterSource(fromLocation);
		search.enterDest(toLocation);
		search.selectDate(dateVal);
		search.clicksearch();
		Thread.sleep(5000);

	}		
	
	@Test
	public void validSourceInvalidDestination() throws Throwable {
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
		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		search.enterSource(fromLocation);
		search.enterInvalidDestination(toLocation);
		search.selectDate(dateVal);
		search.clicksearch();
		Thread.sleep(5000);
	}		
	
	@Test
	public void InvalidSourceValidDestination() throws Throwable {
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
		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		search.enterInvalidSource(fromLocation);
		search.enterDest(toLocation);
		search.selectDate(dateVal);
		search.clicksearch();
		Thread.sleep(5000);

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
		SearchBusPage search = new SearchBusPage(driver);
		search.busTicketsClick();
		search.enterInvalidSource(fromLocation);
		search.enterInvalidDestination(toLocation);
		search.selectDate(dateVal);
		search.clicksearch();
		Thread.sleep(5000);

	}	
}
