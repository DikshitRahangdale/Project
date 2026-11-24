package Practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AutomationMain {
	WebDriver driver;
	Automation atm;

	@Test
	public void f() {
		atm.inputField("Dikshit Rahangdale", "adt@gmail.com", "58421111", "Pune");
		atm.gender();
		atm.mouse();
		atm.slider();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		atm = new Automation(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
