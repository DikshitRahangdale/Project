package Zomato.Registaration_Login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMain {
	WebDriver driver;
	Login login;

	@Test
	public void logins() {
        login.clickSignUp();
        WebElement frmElement=driver.findElement(By.xpath("/html/body/iframe[12]"));
        driver.switchTo().frame(frmElement);
		login.nameAndEmail("Diks Rhanagdale", "DDD@gmail.com");
		login.createAccountBtn();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.zomato.com/");
		login = new Login(driver);
	}

	@AfterTest
	public void afterTest() {
	}

}
