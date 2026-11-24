package Registrations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TestC {

	WebDriver driver;
	SoftAssert soft;

	public TestC(WebDriver driver) {
		this.driver = driver;
		soft = new SoftAssert();
	}

	public String firstNameWarning() {
		String fmsg = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
		return fmsg;

	}

	public String lastNameWarning() {
		String lmsgString = driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText();
		return lmsgString;
	}

	public String emailWarning() {
		String mailString = driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText();
		return mailString;
	}

	public String mobileWarning() {
		String mobiString = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText();
		return mobiString;
	}

	public String passwordWarning() {
		String passString = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div"))
				.getText();
		return passString;
	}

	public String privacyWarning() {
		return driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
	}

	public void Assertion(String actual, String expectd) {
		System.out.println("Warning Message: " + actual);
		soft.assertEquals(actual, expectd, "Warning Message are Not Matched");

	}

	public void loginbtn() {
		driver.findElement(By.linkText("Login")).click();
	}

	public void loginPageContinueBtn() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
	}

}
