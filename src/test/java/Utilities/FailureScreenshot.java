package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



/**
 * This class is the FailureScreenshot class that help when there is a failure in script took screenshot for an error 
 */
public class FailureScreenshot {

	/**
	 * method captureScreenshot take screen shot for an error when test case failed
	 * contain argument driver and name of screen shoot
	 * destintaion contain path and screenshot name  and save image in out variable . 
	 * @param  browserobject initialize driver
	 * @param  screenshotname name of screenhoot
	 */

	public static void captureScreenshot(WebDriver browserobject , String screenshotname) 
	{


		Path dest = Paths.get("./ScreenShots",screenshotname+".png"); 
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) browserobject).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot"+ e.getMessage());
		}
	}




}
