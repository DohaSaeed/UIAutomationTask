package Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * This class is the base class that contain constructor to initiate driver and  contain main methods I will use in another pages
 */


public class BasePage {




	/**
	 * First  (BasePage) is the constructor used to initialize driver .
	 * the constructor contain an  argument browser_object  driver 
	 * @param  browserobject initialize driver 
	 */

	public WebDriver browserobject;
	public  JavascriptExecutor jse ; 


	public BasePage(WebDriver browserobject)
	{

		this.browserobject=browserobject;
	}


	/**
	 * method (clickButton) when there  is button in the page it click on it 
	 * contain argument button of WebElement
	 * @param  button  button from WebElement to click on the button in the page 
	 */

	protected static void clickButton(WebElement button) 
	{
		button.click();
	}



	/**
	 * method (setTextElementText) take element locator and value and send value to search bar in the page and press enter 
	 * contain arguments textElement of WebElement and  value
	 * @param  textElement  contain element locator  
	 * @param  value  contain value send to search bar in the page  
	 */
	protected static void setTextElementText(WebElement textElement , String value) 
	{
		textElement.sendKeys(value,Keys.ENTER);
	}
	
	/**
	 * method (setTextElementTextwithoutenter) take element locator and value and send value to search bar in the page without press enter 
	 * contain arguments textElement of WebElement and  value
	 * @param  textElement  contain element locator  
	 * @param  value  contain value send to search bar in the page  
	 */
	protected static void setTextElementTextwithoutenter(WebElement textElement ,  String value) 
	{
		textElement.sendKeys(value);
	}


	/**
	 * method (scrollToBottom) scroll down to the bottom of the page  using java script  
	 */


	public  void scrollToBottom() 

	{
		jse.executeScript("window.scrollBy(0,1000)"); 
	}
	


}
