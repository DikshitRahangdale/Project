package NADSOFT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainAssignment {
	WebDriver driver;
	Assignment asg;

	@Test
	public void testA() throws InterruptedException {
		asg.addMacBook(2);
		String msgString = asg.successMessage();
		System.out.println(msgString);
		asg.cardButton();
		asg.validateURL();
		asg.compairPrice();
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		asg = new Assignment(driver);
	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}

}
