package seleniumgrid;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RSAtest {

	@Test
	public void testrsa() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.86.24:4444"),caps);
		//caps.setBrowserName("firefox");
		caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		driver.get("http://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		//driver.findElement(By.name("q")).sendKeys("Rahul shetty Academy");
		driver.close();
	}
}
