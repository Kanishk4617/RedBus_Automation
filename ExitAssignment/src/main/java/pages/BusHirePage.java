package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pagesUtils.HelperClass;

public class BusHirePage {
	public WebDriver driver;

	public BusHirePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	public WebElement busHireLink;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[5]/div[2]/object[1]")
	public WebElement frameWindow;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Outstation')]")
	public WebElement outStationMenu;

	@FindBy(how = How.XPATH, using = "//*[@class='slider round']")
	public WebElement sliderRound;

	@FindBy(how = How.ID, using = "locationTextFieldLocal")
	public WebElement pickUpInput;

	@FindBy(how = How.ID, using = "local_dest_name")
	public WebElement destinationInput;

	@FindBy(how = How.XPATH, using = "//*[@id='from_datepicker']/div/div/input")
	public WebElement fromDateAndTimeForOutstation;

	@FindBy(how = How.XPATH, using = "//*[@id='to_datepicker']/div/div/input")
	public WebElement toDateAndTimeForOutstation;

	@FindBy(how = How.XPATH, using = "//*[text() = 'OK']")
	public WebElement dateAndTimeOkButton;

	@FindBy(how = How.ID, using = "numberOfPax")
	public WebElement numberOfPassengerField;

	@FindBy(how = How.XPATH, using = "//button[@id='proceedButtonOutstation']")
	public WebElement proceedButtonOnOutstation;

	@FindBy(how = How.XPATH, using = "//*[text() = 'Local']")
	public WebElement localMenu;

	@FindBy(how = How.XPATH, using = "//*[@id='locationTextFieldLocal']")
	public WebElement pickUpLocationOnLocalMenu;

	@FindBy(how = How.XPATH, using = "//input[@type = 'radio' and @value = '4']")
	public WebElement selectPackage;

	@FindBy(how = How.XPATH, using = "//*[@class = 'MuiInputBase-input MuiInput-input']")
	public WebElement dateAndTimeOnLocalMenu;

	@FindBy(how = How.ID, using = "numberOfPax")
	public WebElement numberOfPassengersOnLocalMenu;

	@FindBy(how = How.ID, using = "proceedButtonLocal")
	public WebElement proceedButtonLocal;

	@FindBy(how = How.XPATH, using = "//*[text() = 'Airport']")
	public WebElement airPortMenu;

	@FindBy(how = How.XPATH, using = "//*[@class='select-selected']")
	public WebElement citySelect;

	@FindBy(how = How.ID, using = "locationTextFieldLocal")
	public WebElement destLocationFieldOnAirportMenu;

	@FindBy(how = How.XPATH, using = "//*[@id = 'ui-id-1']/li")
	public WebElement searchLocationResult;

	@FindBy(how = How.XPATH, using = "//*[@id='from_datepicker']/div/div/input")
	public WebElement fromDateAndTimeOnAirportMenu;

	@FindBy(how = How.ID, using = "numberOfPax")
	public WebElement numberOfPassengersOnAirportMenu;

	@FindBy(how = How.ID, using = "proceedButtonAirport")
	public WebElement proceedButtonOnAirportMenu;

	public void clickOnOutstationMenu() {

		driver.switchTo().frame(frameWindow);
		outStationMenu.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnSliderButton() {

		sliderRound.click();
	}

	public void enterPickUpLocation(String pickUpLocation) {

		pickUpInput.sendKeys(pickUpLocation);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pickUpInput.sendKeys(Keys.DOWN);
		pickUpInput.sendKeys(Keys.UP);
		pickUpInput.sendKeys(Keys.RETURN);
	}

	public void enterDropLocation(String dropLocation) {

		destinationInput.sendKeys(dropLocation);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		destinationInput.sendKeys(Keys.DOWN);
		destinationInput.sendKeys(Keys.UP);
		destinationInput.sendKeys(Keys.ENTER);
	}

	public void enterDateAndTimeForOutstation(String fromDateAndTimeVal, String tillDateAndTimeVal)
			throws InterruptedException {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", fromDateAndTimeForOutstation);

		// selecting date and time
		Thread.sleep(500);
		try {
			HelperClass.selectDateAndTimeAtBusHirePage(driver, fromDateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}
		toDateAndTimeForOutstation.click();
		// selecting date and time
		try {
			HelperClass.selectDateAndTimeAtBusHirePage(driver, tillDateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterNumberOfPassengers(String numberOfPassenger) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		Thread.sleep(100);

		numberOfPassengerField.clear();
		numberOfPassengerField.sendKeys(numberOfPassenger);
	}

	public void clickOnProceedButtonOnOutstationMenu() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", proceedButtonOnOutstation);
		proceedButtonOnOutstation.click();

		Thread.sleep(1000);

	}

	// Flow For Airport
	public void clickOnAirportMenu() {

		driver.switchTo().frame(frameWindow);
		airPortMenu.click();
	}

	// Flow For Local
	public void clickOnLocalMenu() {

		driver.switchTo().frame(frameWindow);
		localMenu.click();

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
