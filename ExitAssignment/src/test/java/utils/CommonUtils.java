package utils;

import java.util.HashMap;

import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import tests.BaseTest;


// includes common utilities required by all project

public class CommonUtils extends BaseTest {

	// function toCheckExecutionRequired
	public static void toCheckExecutionRequired(String executionRequired) {
		
		// if execution required field is no
		if(executionRequired.equals("no")) {
			throw new SkipException("Skipping this exception");
		}
		
		// if execution required field is empty
		if(executionRequired.equals("")) {

			throw new SkipException("Skipping this exception");
		}
	}
}
