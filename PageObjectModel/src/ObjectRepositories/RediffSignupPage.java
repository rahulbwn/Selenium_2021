package ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffSignupPage {
	
	WebDriver driver;
	
	public  RediffSignupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By desiredUserName=By.cssSelector("#tblcrtac > tbody > tr:nth-child(7) > td:nth-child(3) > input[type=text]:nth-child(1)");
	By checkAvailablity=By.xpath("//input[@value='Check availability']");
	By verifyText=By.cssSelector("#check_availability > font > b");
	
	public WebElement desiredUserName()
	{
		return driver.findElement(desiredUserName);
	}
	
	public WebElement checkAvailablity()
	{
		return driver.findElement(checkAvailablity);
	}
	
	public WebElement verifyText()
	{
		return driver.findElement(verifyText);
	}
	


}
