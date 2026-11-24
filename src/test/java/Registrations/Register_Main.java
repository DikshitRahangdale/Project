package Registrations;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Register_Main {
	WebDriver driver;
	TestA a;
	TestC c;
	TestD d;
	WebDriverMethods dm;

	// Test 1
	@Test(enabled = true, priority = 1)
	public void TestA() {
		a.myAccount();
		a.regiSteration();
		a.firstName("Dikshit");
		a.lastName("Diks");
		a.eMail("Skshi@gmail.com");
		a.mobileNumber("856987421");
		a.password("DIzks@398");
		a.confirmPassword("DIzks@398");
		a.privacyButton();
		a.contnueBtn();
		a.confirmation();
		a.successPageContBtn();
		a.myAccountPage();
		a.myAccount();
		a.logOut();
		a.logoutContinue();

	}

	// Test 3
	@Test(enabled = true, priority = 2)
	public void TestB() {

		a.myAccount();
		a.regiSteration();
		a.firstName("Dikshit");
		a.lastName("Diks");
		a.eMail("mashi@gmail.com");
		a.mobileNumber("856987421");
		a.password("DIks@398");
		a.confirmPassword("DIks@398");
		a.privacyButton();
		a.newsLetter(0);
		a.contnueBtn();
		a.confirmation();
		a.successPageContBtn();
		a.myAccountPage();
		a.myAccount();
		a.logOut();
		a.logoutContinue();
	}

	// Test 4
	@Test(enabled = true, priority = 3)

	public void TestC() {
		String firstname = "First Name must be between 1 and 32 characters!";
		String lastName = "Last Name must be between 1 and 32 characters!";
		String email = "E-Mail Address does not appear to be valid!";
		String mobile = "Telephone must be between 3 and 32 characters!";
		String pass = "Password must be between 4 and 20 characters!";
		String privacy = "Warning: You must agree to the Privacy Policy!";
		a.myAccount();
		a.regiSteration();
		a.contnueBtn();
		String privacyString = c.privacyWarning();
		String firstnameString = c.firstNameWarning();
		String lastnameString = c.lastNameWarning();
		String emailString = c.emailWarning();
		String mobileString = c.mobileWarning();
		String passString = c.passwordWarning();

		c.Assertion(privacyString, privacy);
		c.Assertion(firstnameString, firstname);
		c.Assertion(lastnameString, lastName);
		c.Assertion(emailString, email);
		c.Assertion(mobileString, mobile);
		c.Assertion(passString, pass);
	}

	// Test Case 5

	@Test(enabled = true, priority = 4)
	public void TestD() {

		a.myAccount();
		a.regiSteration();
		a.firstName("Dikshit");
		a.lastName("Diks");
		a.eMail("xeox@gmail.com");
		a.mobileNumber("856987421");
		a.password("DIks@398");
		a.confirmPassword("DIks@398");
		a.newsLetter(0);
		a.privacyButton();
		a.contnueBtn();
		a.confirmation();
		a.successPageContBtn();
		a.myAccountPage();

		d.newsSelectorLink();
		d.newsSelectorOptions();
		a.myAccount();
		a.logOut();
		a.logoutContinue();

	}
	// Test case 6

	@Test(enabled = true, priority = 5)
	public void TestE() {

		a.myAccount();
		a.regiSteration();
		a.firstName("Dikshit");
		a.lastName("Diks");
		a.eMail("nadsft@gmail.com");
		a.mobileNumber("856987421");
		a.password("DIks@398");
		a.confirmPassword("DIks@398");
		a.newsLetter(1);
		a.privacyButton();
		a.contnueBtn();
		a.confirmation();
		a.successPageContBtn();
		a.myAccountPage();
		d.newsSelectorLink();
		d.newsSelectorOptions();
		a.myAccount();
		a.logOut();
		a.logoutContinue();

	}

	// Test 7
	@Test(enabled = true, priority = 6)
	public void TestF() {
		a.myAccount();
		a.regiSteration();
		a.myAccount();
		c.loginbtn();
		c.loginPageContinueBtn();
		String actuTitleString = "Register Account";
		String urlString = driver.getTitle();
		Assert.assertEquals(urlString, actuTitleString, "Registration Page are Not Open");
		a.myAccount();
		c.loginbtn();
		d.loginPageRegistration();
		String url = driver.getTitle();
		Assert.assertEquals(url, actuTitleString, "Registration Page are Not Open");
	}

	// Test case 8
	@Test(enabled = true, priority = 7)

	public void TestG() {
		a.myAccount();
		a.regiSteration();
		a.firstName("Dikshit");
		a.lastName("Diks");
		a.eMail("mmhj@gmail.com");
		a.mobileNumber("856987421");
		a.password("12345");
		a.confirmPassword("abcde");
		a.privacyButton();
		a.contnueBtn();
		String expeString = "Password confirmation does not match password!";
		String warning = "Warning Message are not Matched";
		String actualString = d.confirmPasswordWarning();

		dm.hardAssertionValidation(actualString, expeString);

	}

	// Test case 9

	@Test(enabled = true, priority = 8)
	public void TestH() {
		a.myAccount();
		a.regiSteration();
		a.firstName("Dikshit");
		a.lastName("Diks");
		a.eMail("diskhitrahangdale@gmail.com");
		a.mobileNumber("856987421");
		a.password("DIzks@398");
		a.confirmPassword("DIzks@398");
		a.privacyButton();
		a.contnueBtn();

		String warningexcepte = "Warning: E-Mail Address is already registered!";
		String warningactual = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();

		dm.hardAssertionValidation(warningactual, warningexcepte);

	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("https://demo.opencart.com.gr");
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		a = new TestA(driver);
		c = new TestC(driver);
		d = new TestD(driver);
		dm = new WebDriverMethods(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
