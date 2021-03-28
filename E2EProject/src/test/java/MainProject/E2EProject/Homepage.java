package MainProject.E2EProject;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class Homepage extends TestBase {
	HomePage home;
	LoginPage login;
	
	@BeforeTest
	public void preRequisite() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("baseURL"));
		home=new HomePage(driver);
		
		// Waiting for News Letter pop-up and closing it
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(home.newsLetterPopup()));
		home.noThanksBtn().click();
		
		//Performing some assertions
		Assert.assertEquals(home.tagLine().getText(), "An Academy to learn Everything about Testing".toUpperCase());
		Assert.assertTrue(home.floatingMsgBar().isDisplayed(),"Floating Message bar is not displayed");
		
		////Moved to login Page
		home.Loginbutton().click();
		login = new LoginPage(driver);
	}
	@Test(dataProvider="testdata")
	public void loginTest(String email,String password) throws IOException
	{
	
		login.putEmail().sendKeys(email);
		login.putPassword().sendKeys(password);
		login.login().click();
	}
	
	@DataProvider(name="testdata")
	public Object[][] getData()
	{
		// Row specify different sets of test data
		// Column Specify no. of data in each data set
		Object[][] data=new Object[3][2];  // 3 datasets, each is having 2 values
		
		// 1st data set
		data[0][0]="abc@gmail.com";
		data[0][1]="1236";
		
		//2nd data set
		data[1][0]="qw@fdhj.com";
		data[1][1]="4589";
		
		//3rd data set
		data[2][0]="hgjds@gsahj.com";
		data[2][1]="612";  
		
		return data;
		
		/*   return new Object[][]    // Alternate Code
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };    */
	}
	@AfterTest
	public void postExecution()
	{
		driver.quit();
	}

}
