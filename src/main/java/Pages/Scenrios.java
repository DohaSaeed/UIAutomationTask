package Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * This class is the Scenrios class that contain constructor to initiate driver and  contain first  ,second  and third scenrio
 */
public class Scenrios extends BasePage{

	public Scenrios(WebDriver browserobject) {
		super(browserobject);
		// TODO Auto-generated constructor stub
		jse = (JavascriptExecutor) browserobject; 
	}
	
	By Banking=By.xpath("//a[@href='http://www.way2automation.com/angularjs-protractor/banking']");
	By Bankingbutton= By.xpath("//button[contains(.,'Bank Manager Login')]");
	By butttoncustomer = By.xpath("//button[contains(.,'Add Customer')]");
	By Fieldfristname= By.xpath("//input[@placeholder='First Name']");
	By fieldlastname = By.xpath("//input[@placeholder='Last Name']");
	By fieldPostcode = By.xpath("//input[@placeholder='Post Code']");
	By buttonAlert= By.cssSelector("button.btn.btn-default");
	By buttonCustomers= By.xpath("//button[contains(.,'Customers')]");
	By tableCustomers = By.xpath("//table[@class='table table-bordered table-striped']/tbody");
	By lastRow = By.tagName("tr");
	By Assertsize= By.xpath("//td[contains(.,'Doha')]");
	String firstName ="Doha";
	String LirstName ="Saeed";
	String PostlCode ="1234";
	String alertMessage;
	String alertMessage1;
	
	By openAccountButtom= By.xpath("//button[contains(.,'Open Account')]");
	By selectUser= By.id("userSelect");
	By selectCurrency = By.id("currency");
	By submitButton = By.xpath("//button[contains(.,'Process')]");
	By accountNumber = By.xpath("//td[contains(.,'1016')]");
	By selectCell =By.xpath("//table/tbody/tr[6]/td[5]");
	
	/**
	 * method (Scenrioo_One) this method add customers and assert that customer found in table 
	 */

	
	public void Scenrioo_One()
	{
		
		scrollToBottom();
		String Bankinglink= browserobject.findElement(Banking).getAttribute("href");
		browserobject.get(Bankinglink);
		WebDriverWait wait4=new WebDriverWait(browserobject, 12);
		wait4.until(ExpectedConditions.elementToBeClickable(Bankingbutton));
		clickButton(browserobject.findElement(Bankingbutton));
		WebDriverWait wait5=new WebDriverWait(browserobject, 12);
		wait5.until(ExpectedConditions.elementToBeClickable(butttoncustomer));
		clickButton(browserobject.findElement(butttoncustomer));
		WebDriverWait wait6=new WebDriverWait(browserobject, 12);
		wait6.until(ExpectedConditions.visibilityOfElementLocated(Fieldfristname));
		setTextElementTextwithoutenter(browserobject.findElement(Fieldfristname),firstName);
		WebDriverWait wait7=new WebDriverWait(browserobject, 12);
		wait7.until(ExpectedConditions.visibilityOfElementLocated(fieldlastname));
		setTextElementTextwithoutenter(browserobject.findElement(fieldlastname),LirstName);
		WebDriverWait wait8=new WebDriverWait(browserobject, 12);
		wait8.until(ExpectedConditions.visibilityOfElementLocated(fieldPostcode));
		setTextElementTextwithoutenter(browserobject.findElement(fieldPostcode),PostlCode);
		clickButton(browserobject.findElement(buttonAlert));
		Alert alert = browserobject.switchTo().alert();
		alertMessage=browserobject.switchTo().alert().getText();
		System.out.println(alertMessage);
		String substring = alertMessage.substring(46);
		System.out.println(" Customer Id : " + substring);
		alert.accept();	
		WebDriverWait wait9=new WebDriverWait(browserobject, 12);
		wait9.until(ExpectedConditions.elementToBeClickable(buttonCustomers));
		clickButton(browserobject.findElement(buttonCustomers));
		WebDriverWait wait10=new WebDriverWait(browserobject, 12);
		wait10.until(ExpectedConditions.visibilityOfElementLocated(tableCustomers));
		WebElement rowsCount = browserobject.findElement(tableCustomers);
		List<WebElement>TotalRowsList = rowsCount.findElements(lastRow);
		int sizeTable= TotalRowsList.size();
		String siz=String.valueOf(sizeTable);
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		Assert.assertEquals(substring, siz);
		WebElement col=  browserobject.findElement(Assertsize);
		String valueIneed = col.getText();
		System.out.println( "  the added customer is : " + valueIneed);
		Assert.assertEquals(valueIneed, firstName );

	}
	
	
	
	/**
	 * method (Scenrioo_two) this method check account number found in table 
	 */
	
	public void Scenrioo_Two()
	{
		WebDriverWait wait11=new WebDriverWait(browserobject, 12);
		wait11.until(ExpectedConditions.elementToBeClickable(openAccountButtom));
		clickButton(browserobject.findElement(openAccountButtom));
		WebDriverWait wait12=new WebDriverWait(browserobject, 12);
		wait12.until(ExpectedConditions.elementToBeClickable(selectUser));
		Select s = new Select(browserobject.findElement(selectUser));
		s.selectByVisibleText("abo Saeed");
		WebDriverWait wait13=new WebDriverWait(browserobject, 12);
		wait13.until(ExpectedConditions.elementToBeClickable(selectCurrency));
		Select s1 = new Select(browserobject.findElement(selectCurrency));
		s1.selectByVisibleText("Dollar");
		WebDriverWait wait14=new WebDriverWait(browserobject, 12);
		wait14.until(ExpectedConditions.elementToBeClickable(submitButton));
		clickButton(browserobject.findElement(submitButton));
		Alert alert1 = browserobject.switchTo().alert();
		alertMessage1=browserobject.switchTo().alert().getText();
		System.out.println(alertMessage1);
		String substring1 = alertMessage1.substring(50);
		System.out.println(" the account number from the alert  : " + substring1);
		alert1.accept();
		WebDriverWait wait15=new WebDriverWait(browserobject, 12);
		wait15.until(ExpectedConditions.elementToBeClickable(buttonCustomers));
		clickButton(browserobject.findElement(buttonCustomers));
		WebElement col1=  browserobject.findElement(accountNumber);
		String valueIneed1 = col1.getText();
		System.out.println(" the account number of added customer in table " + valueIneed1);
		Assert.assertEquals(valueIneed1, substring1 );
		
	}
	
	
	
	/**
	 * method (Scenrioo_three) this method delete customer from table of customers 
	 */
	
	
	public void Scenrioo_Thre()
	{
		
		clickButton(browserobject.findElement(selectCell));
		WebElement rowsCount1 = browserobject.findElement(tableCustomers);
		List<WebElement>TotalRowsList1 = rowsCount1.findElements(lastRow);
		int sizeTable1= TotalRowsList1.size();
		System.out.println("Total number of Rows in the table are : "+sizeTable1);
		Assert.assertEquals(sizeTable1, 5);

	}

}
