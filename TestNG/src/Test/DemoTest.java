package Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class DemoTest {
@BeforeTest   //testNG XML level method
public void prequites() {  // database clearance, login etc.
	System.out.println("I will execute first");
}
@Test
public void Test1() {
	System.out.println("Hello");
}

@Test(groups= {"Smoke"})
public void Test2() {
	System.out.println("World");
}
@AfterSuite //testNG XML level method
public void afSuite() {
	  System.out.println("I'll execute on No. 1 from last");
}

}
