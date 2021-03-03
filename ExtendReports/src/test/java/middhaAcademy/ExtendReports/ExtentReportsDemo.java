package middhaAcademy.ExtendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReportsDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void ExtentReportCreater()
	{
		String reportPath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Test Results");
		reporter.config().setDocumentTitle("Selenium Automation Tests");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul");
	}
	
	@Test
	public void InitialDemo()
	{
		ExtentTest test=extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.sarkariresultnaukri.com/");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Validation Failed");
		extent.flush();
		
	}

}
