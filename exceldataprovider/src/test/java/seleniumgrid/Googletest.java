package seleniumgrid;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Googletest {

	@Test
	public void testgoogle() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.86.24:4444"),caps);
		caps.setBrowserName("chrome");
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Rahul shetty Academy");
		driver.close();
	}
}
