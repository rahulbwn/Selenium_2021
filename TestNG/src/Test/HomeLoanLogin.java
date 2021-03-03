package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeLoanLogin {
	@Test(dataProvider="getData") // Test that needs to be run with different  set of data
	public void webHomeLogin(String UserName,String Password) {
		//Selenium code
		System.out.println("webHomeLogin");
		System.out.println(UserName);
		System.out.println(Password);
	}
	
	@Parameters({"URL","Domain/UserName"})
	@Test
	public void mobileHomeLogin(String baseURL, String userName) {
		//Appium Code
		System.out.println("mobileHomeLogin");
		System.out.println(baseURL);
		System.out.println(userName);
	}
	
	@Test(groups= {"Smoke"})
	public void APIHomeLogin() {
		//RestAPI code
		System.out.println("APIHomeLogin");
	}
	
	@BeforeMethod //class level method
	public void bMethod() {
		System.out.println("I'll execute before each method in the class.");
	}
	
	@AfterMethod   //class level method
	public void afMethod() {
		System.out.println("I'll execute after each method in the class.");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// 1. UserName & Password -- loan - good credit score
		// 2. UserName & Password -- loan - average credit score
		// 3. UserName & Password -- loan - fraud Person
		
		Object[][] data=new Object[3][2]; //3 denotes no. of test data set & 2 denotes data entries in each row
		
		data[0][0]="firstUserName";
		data[0][1]="firstPassword";
		
		data[1][0]="SecondUserName";
		data[1][1]="SecondPassword";
		
		data[2][0]="ThirdUserName";
		data[2][1]="ThirdPassword";
		
		return data;
		
	}

}
