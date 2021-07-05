package tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BusHirePage;
import pages.HomepageFunctionality;
import utils.CommonUtils;

public class BusHirePageTest extends BaseTest{

	private String sheetName = prop.getProperty("BusHireSheet");

	@Test()
	public void whenUserEntersValidInformationForOutstation() throws InterruptedException {

		String testName = "whenUserEntersValidInformationForOutstation";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);
		extentTest = extent.startTest("Valid information for Outstation test");
		BusHirePage busHirePage = new BusHirePage(driver);

		HomepageFunctionality homePage = new HomepageFunctionality(driver);

		homePage.busHireClick();
		logger.info("Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
		logger.info(pickUpLocation+" location was entered");

		busHirePage.enterDropLocation(destinationLocation);
		logger.info(destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabelsummary']")).getText();
		logger.info("Actual Result : "+actualResult);
		
		if(actualResult.equals("Fill Contact Details"))
		{
			Assert.assertEquals("Fill Contact Details", actualResult);
			logger.info("test case passed");
		}
		else
		{
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals("Fill Contact Details", actualResult);
			logger.info("test case failed");
		}
	
	}

	// test case for invalid from location
	@Test()
	public void whenUserDoesNotEnterFromLocationForOutstation() throws InterruptedException {

		String testName = "whenUserDoesNotEnterFromLocationForOutstation";
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		//String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		extentTest = extent.startTest("user does not enter destination information for  test");


		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomepageFunctionality homePage = new HomepageFunctionality(driver);

		homePage.busHireClick();
		logger.info("Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");

		// doesn't enter from location

		busHirePage.enterDropLocation(destinationLocation);
		logger.info(destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}

	// test case for invalid to location
	@Test()
	public void whenUserDoesNotEnterToLocationForOutstation() throws InterruptedException {

		String testName = "whenUserDoesNotEnterToLocationForOutstation";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String pickUpLocation = testData.get("Pickup Location");
		//String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		extentTest = extent.startTest("user does not enter source information for  test");


		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomepageFunctionality homePage = new HomepageFunctionality(driver);

		homePage.busHireClick();
		logger.info("Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		logger.info("OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
		logger.info(pickUpLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		logger.info(numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		logger.info("Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
	}


	// test case for LocalMenu
	@Test()
	public void whenUserClickedOnLocalMenu() {

		String testName = "whenUserClickedOnLocalMenu";
		
		extentTest = extent.startTest("User clicks on Local menu test");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		BusHirePage busHirePage = new BusHirePage(driver);
		HomepageFunctionality homePage = new HomepageFunctionality(driver);

		homePage.busHireClick();
		logger.info("Bus Hire link was clicked");

		busHirePage.clickOnLocalMenu();
		logger.info("Local Menu was selected");

		
		try {
			
			Thread.sleep(5000);
		}
		catch(Exception e){
			
		}
		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
	}

	// test case for AirportMenu
	@Test()
	public void whenUserClickedOnAirportMenu() {

		extentTest = extent.startTest("User clicks on Airport menu test");

		String testName = "whenUserClickedOnAirportMenu";
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedResult = testData.get("Expected Result");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		HomepageFunctionality homePage = new HomepageFunctionality(driver);

		homePage.busHireClick();
		logger.info("Bus Hire link was clicked");

		busHirePage.clickOnAirportMenu();
		logger.info("Airport Menu was selected");
		
		try {
			
			Thread.sleep(5000);
		}
		catch(Exception e){
			
		}
		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		logger.info("Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
	}
}
