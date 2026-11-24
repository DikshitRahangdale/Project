package registration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reg_01 {
	WebDriver driver;
	JavascriptExecutor js;

	public Reg_01(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public void myAccount() {
		driver.findElement(By.partialLinkText("Account")).click();
	}

	public void regClick() {
		driver.findElement(By.partialLinkText("Register")).click();
	}

	public void firstname(String name) {
		driver.findElement(By.id("input-firstname")).sendKeys(name);
	}

	public void lastname(String last) {
		driver.findElement(By.id("input-lastname")).sendKeys(last);
	}

	public void eMail(String mail) {
		driver.findElement(By.id("input-email")).sendKeys(mail);
	}

	public void password(String pass) {
		WebElement password = driver.findElement(By.id("input-password"));
		js.executeScript("arguments[0].scrollIntoView(true);", password);
		password.sendKeys(pass);
	}

	public void confirmPassword(String confrString) {
		driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys(confrString);
	}

	public void subscribr() {
		WebElement subElement = driver.findElement(By.xpath("//*[@id=\"input-newsletter\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", subElement);
		js.executeScript("arguments[0].click();", subElement);
	}

	public void privacy() {
		WebElement element = driver.findElement(By.cssSelector("//*[@id=\"content\"]/form/div/div/input[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element); // Force click

	}

	public void contButton() {
		// WebElement btnElement =
		// driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btnElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-register\"]/div/button")));
		js.executeScript("arguments[0].scrollIntoView(true);", btnElement);
		js.executeScript("arguments[0].click();", btnElement); // Force click

	}

	public String getMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(driver.getCurrentUrl())));

		return driver.getCurrentUrl();

	}

	public String confrmmessage() {
		String msgString = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
		return msgString;
	}

	public void continuebtn() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
	}

	public void logout() {
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[5]/a")).click();
	}

	public void loginBTN() {
		driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Login']")).click();

	}

	public void lgnContn() {
		driver.findElement(By.linkText("Continue")).click();
	}

}
