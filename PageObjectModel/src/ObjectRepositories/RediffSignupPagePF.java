package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffSignupPagePF {
	
	WebDriver driver;
	
	public  RediffSignupPagePF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[contains(@name,\"login\")]")
	WebElement desiredUserName;
	
	@FindBy(xpath="//input[@value='Check availability']")
	WebElement checkAvailablity;
	
	@FindBy(css="#check_availability > font > b")
	WebElement verifyText;
	
	public WebElement desiredUserName()
	{
		return desiredUserName;
	}
	
	public WebElement checkAvailablity()
	{
		return checkAvailablity;
	}
	
	public WebElement verifyText()
	{
		return verifyText;
	}
	


}
