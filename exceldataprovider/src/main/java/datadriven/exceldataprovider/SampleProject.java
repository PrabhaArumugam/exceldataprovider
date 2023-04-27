package datadriven.exceldataprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleProject {
	ExtentReports extent;
	
	@BeforeTest
	public void extentReport() {
		
		String path=System.getProperty("user.dir")+"ind.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	    reporter.config().setReportName("Web Automation Results");
	    reporter.config().setDocumentTitle("Test Results");
	    extent= new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "Prabha");
		
	}
	
	
	
	
	@Test
	public void intialDemo() {
		
		ExtentTest test=extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("results not expected");
		extent.flush();
		
		
	}

}
