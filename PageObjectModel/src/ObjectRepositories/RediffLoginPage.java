package ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	
	WebDriver driver;
	
	public  RediffLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By username=By.xpath("//input[@id=\"login1\"]");
	By password=By.id("password");
	By signin=By.name("proceed");
	By signupPage=By.xpath("//a[@title='Create new Rediffmail account']");
	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement submit()
	{
		return driver.findElement(signin);
	}
	public WebElement signupPage()
	{
		return driver.findElement(signupPage);
	}

}
