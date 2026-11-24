package Registrations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestA {
	WebDriver driver;
	WebDriverWait wait;

	public TestA(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void myAccount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account"))).click();
	}

	public void logIN() {
		driver.findElement(By.linkText("Login")).click();
	}

	public void logOut() {
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
	}

	public void logoutContinue() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
	}

	public void regiSteration() {

		driver.findElement(By.linkText("Register")).click();
	}

	public void firstName(String name) {
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(name);
	}

	public void lastName(String lname) {
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lname);
	}

	public void eMail(String mail) {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(mail);
	}

	public void mobileNumber(String mobile) {
		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(mobile);
	}

	public void password(String pass) {
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(pass);
	}

	public void confirmPassword(String pass) {
		driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(pass);
	}

	public void newsLetter(int a) {
		List<WebElement> newsElements = driver
				.findElements(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label/input"));
		newsElements.get(a).click();

		System.out.println(newsElements.get(a).isSelected());
	}

	public void privacyButton() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
	}

	public void contnueBtn() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	}

	public void confirmation() {
		String url = driver.getCurrentUrl();
		String actString = "account/success";
		String urlString = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();

		if (url.contains(actString)) {
			System.out.println(urlString);
		} else {
			System.out.println("Account are Not Created");
		}

	}

	public void successPageContBtn() {

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
	}

	public void myAccountPage() {
		String titileString = driver.getTitle();
		String titile = "My Account";
		Assert.assertEquals(titileString, titile, "Myt Account Page are Not Open");
	}
}
