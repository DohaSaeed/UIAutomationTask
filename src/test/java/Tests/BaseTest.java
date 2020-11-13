package Tests;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.FailureScreenshot;



/**
 * This class is the BaseTest class contain annotation of testng that should be found before running test
 * before class ,after class , after method 
 * it contain before class that have properties of driver of chrome 
 */

public class BaseTest {
	public  WebDriver browserobject ; 
	ExtentReports extent;
	ExtentTest test;

	/**
	 * method  (beforClass)  contain all things we need before running test only once  like seting proprety of browser , maxmize windows  .
	 *  contain an  argument browserName and took chrome if there is no any choice here run only on chrome 
	 */

	@BeforeClass
	public void beforClass()
	{

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivres/chromedriver.exe");
		browserobject = new ChromeDriver(); 





	}

	/**
	 * method (screenshotOnFailure) after each method if test fail take screen shoot for failed test  and add it in screenshotFolder
	 * contain argument result return result of test cases if pass or failed found in testng 
	 * compare stauts of test with result if status equal filed take screenshot and getname method get name  of the test case running 
	 * @param  result  param send to function to search for this keyword 
	 * @throws IOException 
	 */

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) throws IOException 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			FailureScreenshot.captureScreenshot(browserobject, result.getName());
			test.log(LogStatus.FAIL, result.getName()+" FAIL with error " + result.getThrowable());

		}
	}

	/**
	 * method (config) before each test this function will run
	 * contain  path where your report needs to generate.
	 */

	@BeforeTest
	public void config()
	{
		extent = new ExtentReports(System.getProperty("user.dir") +"\\test-output\\ExtentStepLogs.html", true);

	}

	/**
	 * method (tearDown) after each test this function will run writing everything to document
	 * endTest(test) : It ends the current test and prepares to create HTML report
	 * flush() to write or update test information to your report.
	 * //close() - To close all the operation
	 */
	@AfterTest
	public void tearDown()
	{

		extent.endTest(test);
		extent.flush();
		extent.close();
	}




}
