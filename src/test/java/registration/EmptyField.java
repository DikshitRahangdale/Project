package registration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmptyField {
	WebDriver driver;
	WebDriverWait wait;

	public EmptyField(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String firstnames() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-firstname")));
		return driver.findElement(By.id("error-firstname")).getText();

	}

	public String lastnames() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-lastname")));
		return driver.findElement(By.id("error-lastname")).getText();

	}

	public String emails() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-email")));
		return driver.findElement(By.id("error-email")).getText();
	}

	public String passWords() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-password")));
		return driver.findElement(By.id("error-password")).getText();
	}
	public void loginPageRegstrLink()
	{
		driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();
	}
}
