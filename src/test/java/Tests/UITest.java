package Tests;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.Scenrios;


/**
 * This class is the OrderTest class extends from  BaseTest class it contain the  test scenerio
 */

public class UITest extends BaseTest {
	Scenrios scenrioclas;
	

	
	
	/**
	 * method  (runTestscenrio) is the method that run all the scenrios 
	 */
	@Test
	public void runTestscenrio()
	{
		test = extent.startTest("Log Steps Statuts");
		browserobject.navigate().to("http://www.way2automation.com/protractor-angularjs-practice-website.html#");
		test.log(LogStatus.PASS,"Browser is Opened now Successfully");
		scenrioclas = new Scenrios(browserobject);
		scenrioclas.Scenrioo_One();
		test.log(LogStatus.PASS,"First Scenrio is done successfully");
		scenrioclas.Scenrioo_Two();
		test.log(LogStatus.PASS,"Second Scenrio is done successfully");
		scenrioclas.Scenrioo_Thre();
		test.log(LogStatus.PASS,"third Scenrio is done successfully");
		
		
	}

}
