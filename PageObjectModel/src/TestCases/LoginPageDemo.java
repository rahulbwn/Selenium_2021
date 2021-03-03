package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositories.RediffLoginPage;
import ObjectRepositories.RediffSignupPage;

public class LoginPageDemo {
	
	@Test
	public void LoginPage() 
	{
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	RediffLoginPage rl=new RediffLoginPage(driver);
	rl.username().sendKeys("Hello");
	rl.password().sendKeys("Password");
	rl.submit().click();
	rl.signupPage().click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	RediffSignupPage rsign=new RediffSignupPage(driver);
	rsign.desiredUserName().sendKeys("middharkm7717");
	rsign.checkAvailablity().click();
	
	String ActualText=rsign.verifyText().getText();
	Assert.assertEquals(ActualText,"Yippie! The ID you've chosen is available.");
	}

}
