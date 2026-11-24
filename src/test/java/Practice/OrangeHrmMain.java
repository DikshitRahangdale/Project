package Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHrmMain {
	WebDriver driver;
	OrangeHRM hrm;

	@Test
	public void f() {

		hrm.userAndPassword("Admin", "admin123");
		hrm.loginBtn();
	}

	@BeforeTest
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		hrm = new OrangeHRM(driver);

	}

	@AfterTest
	public void afterTest() {

	}
}
