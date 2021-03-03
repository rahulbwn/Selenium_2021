package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
  @Parameters({"URL"})
  @Test
  public void f(String baseURL) {
	  System.out.println("Bye");
	  System.out.println(baseURL);
  }
  @AfterTest  //Clearing  cookies, cache of browser //testNG XML level method
  public void lastExecution() {
	  System.out.println("I'll execute in last");
  }
  @BeforeSuite  //testNG XML level method //for setting up different run environment i.e. Diff Diff URLs for QA run environments
  public void bSuite() {
	  System.out.println("I'll execute in No. 1");
  }
}
