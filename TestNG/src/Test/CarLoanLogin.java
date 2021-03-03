package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CarLoanLogin {
	@BeforeClass //Class level method
	public void bClass() {
		System.out.println("Before CarLoanLogin Class");
	}
	
	@AfterClass //Class level method
	public void afClass() {
		System.out.println("After CarLoanLogin Class");
	}
	
	@Test(enabled=false) // Used when there is known issue in the test, So, we can skip execution of this test using enabled=false attribute to avoid failure logs for known issue in report.
	public void webCarLogin() {
		//Selenium code
		System.out.println("webCarLogin");
	}
	
	@Test(groups= {"Smoke"})
	public void mobileCarLogin() {
		//Appium Code
		System.out.println("mobileCarLogin");
	}
	
	@Test
	public void mobileCarSignin() {
		//Appium Code
		System.out.println("mobileCarSignin");
	}
	
	@Test(timeOut=4000) // When your test is taking so long time, due to which test is getting failed. it will wait for 4 sec. to get the test status as pass/fail. e.g. API request response delay
	public void mobileCarLogout() {
		//Appium Code
		System.out.println("mobileCarLogout");
	}
	
	@Test(dependsOnMethods= {"mobileCarSignin","mobileCarLogout"}) //when one test is dependent on other tests execution.
	public void APICarLogin() {
		//RestAPI code
		System.out.println("APICarLogin");
	}

}
