package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(css="input[type=submit]")
	WebElement submit;

	public WebElement putEmail()
	{
		return email;
	}
	
	public WebElement putPassword()
	{
		return password;
	}
	
	public WebElement login()
	{
		return submit;
	}

}
