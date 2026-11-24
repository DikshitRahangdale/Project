package Zomato.Registaration_Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
	WebDriverWait wait;

	public Login(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickSignUp() {
		driver.findElement(By.linkText("Sign up")).click();

	}

	public void nameAndEmail(String name, String email) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/section[2]/section[1]/div[1]/section[1]/section[1]/input[1]")));
		// driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/section[2]/section/div[1]/section/section/input"))
		// .sendKeys(name);
		driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/section[2]/section/section/section/input"))
				.sendKeys(email);
		driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/section[2]/section/div[2]/label/input")).click();
	}

	public void createAccountBtn() {
		driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/section[2]/section/button/span")).click();
	}

}
