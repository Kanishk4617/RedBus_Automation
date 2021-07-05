package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import utils.Screenshots;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ScreenshotJar.Screenshots;
//import ScreenshotJar.Screenshots;
import utils.BrowserUtils;
import utils.ExcelFileIO;
public class BaseTest {

	protected static WebDriver driver;
	public static Logger logger = Logger.getLogger(BaseTest.class);
	public static RemoteWebDriver remotedriver;
	public static String LOG_FILE = ".\\Resources\\log4j.properties";
	static FileInputStream logfile = null;
	static File file = new File(".\\Resources\\config.properties");
	static FileInputStream fis = null;
	protected static Properties prop = new Properties();
	public static ExcelFileIO reader = null;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	static {
		try {
			fis = new FileInputStream(file);
			logfile = new FileInputStream(LOG_FILE);
			PropertyConfigurator.configure(logfile);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
			prop.load(logfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {

			reader = new ExcelFileIO(".\\Resources\\testDataExcel.xlsx");
		}
		catch(Exception e) {

			logger.error(e.getMessage());
		}
	}
	@BeforeSuite
	public static void setExtent() {

		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@AfterMethod
	public void attachScreenshots(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath =Screenshots.takeScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Passed successfully");
		}
		extent.endTest(extentTest);
	}

@BeforeMethod
public void initializeBrowser() throws MalformedURLException, InterruptedException {
	String browser = prop.getProperty("browser").toLowerCase();
	boolean headlessMode = Boolean.parseBoolean(prop.getProperty("headlessMode"));
	boolean runOnDocker = Boolean.parseBoolean(prop.getProperty("runOnDocker"));
	if(runOnDocker) {

		if(headlessMode) {
			
			 driver = BrowserUtils.openBrowserInHeadlessInDocker(browser);
		}
		else {
			
			driver = BrowserUtils.openBrowserInNonHeadlessInDocker(browser);
		}
	}
	else {

		if(headlessMode) {
			System.out.println("---- headless---");
			
			driver = BrowserUtils.openBrowserInHeadlessInLocal(browser);
		}
		else {
			System.out.println("---- Nonheadless---");
			
			driver = BrowserUtils.openBrowserInNonHeadlessInLocal(browser);
		}
	}
}
@BeforeMethod(dependsOnMethods = "initializeBrowser")
public void setUp() {

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	if(!prop.getProperty("browser").equals("firefox")) {
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("globalWait")), TimeUnit.SECONDS);
		
	}
	// implicit wait will be for all elements 
	
	driver.get(prop.getProperty("testUrl"));
	
	logger.info(prop.getProperty("testUrl")+" page opened...");
}
public static RemoteWebDriver runInDocker() throws MalformedURLException {
	final ChromeOptions options = new ChromeOptions();
//	options.addArguments("--headless");
	options.addArguments("--disable-gpu");
	options.addArguments("--disable-dev-shm-usage");
	options.addArguments("--no-sandbox");
	options.addArguments("--allow-insecure-localhost");
	options.addArguments("window-size=1920,1080");
	options.addArguments("user-agent=Chrome/91.0.4472.124");
	URL url = new URL("http://localhost:4449/wd/hub");
	remotedriver = new RemoteWebDriver(url,options);
//	remotedriver.manage().window().maximize();
//	remotedriver.get("https://www.redbus.in/");
	remotedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return remotedriver;
}
public static WebDriver runInHeadless() {
	ChromeOptions chromeOptions = null;
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("headless");
	chromeOptions.addArguments("window-size=1920,1080");
	chromeOptions.addArguments("user-agent=Chrome/91.0.4472.124");
	driver = new ChromeDriver(chromeOptions);
	return driver;
}
@AfterMethod
public void closeBrowser() {
	extent.endTest(extentTest);
	logger.info("Browser is closed");
	driver.quit();
}
}
