package registration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class RegMain {
	Reg_01 reg;
	EmptyField empty;
	WebDriver driver;
	SoftAssert soft;

	String expnameString = "First Name must be between 1 and 32 characters!";
	String explastnameString = "Last Name must be between 1 and 32 characters!";
	String expemailString = "E-Mail Address does not appear to be valid!";
	String exppassString = "Password must be between 4 and 20 characters!";

	String mail1 = "bhavana@gmail.com";
	String mail2 = "tushar@gmail.com";
	String mail3 = "palavi@gmail.com";
	String mail4 = "rohit@gmail.com";

// Test Case 1 &2
	@Test(priority = 3)
	public void allField() {
		reg.myAccount();
		reg.regClick();
		reg.firstname("Diks");
		reg.lastname("Dixit");
		reg.eMail(mail1);
		reg.password("Pasws@123");
		//reg.confirmPassword("Pass@123");
		reg.subscribr();
		reg.privacy();
		reg.contButton();

		String actString = reg.getMessage();
		String confmessageString = reg.confrmmessage();

		if (actString.contains("account/success")) {
			reg.continuebtn();
			reg.myAccount();
			reg.logout();
			System.out.println("Test Case 1->ER.1 Passed!!");
			System.out.println("Test Case 3 Passed!!");
			System.out.println(confmessageString);
		} else {
			System.out.println("Test case 1->ER1.Fail!!");
			System.out.println("Test Case 3 Fail");
		}

	}

	// Test Case 4
	@Test(priority = 2,enabled = false)
	public void empty() {
		reg.myAccount();
		reg.regClick();
		reg.contButton();
		String actFirstnameString = empty.firstnames();
		String actlastnameString = empty.lastnames();
		String actmailString = empty.emails();
		String actpasswordString = empty.passWords();

		if ((actFirstnameString.equals(expnameString)) && (actlastnameString.equals(explastnameString))
				&& (actmailString.equals(expemailString)) && (actpasswordString.equals(exppassString))) {
			System.out.println("Test Case 4 Pass!!");
		} else {
			System.out.println("Test Case 4 Fail!!");
		}

	}

	// Test case 5
	@Test(priority = 1,enabled = false)
	public void newsLetter() {
		reg.myAccount();
		reg.regClick();
		reg.firstname("Dikshjit");
		reg.lastname("Dixit");
		reg.eMail(mail2);
		reg.password("hass@123");
		reg.confirmPassword("hass@123");
		reg.subscribr();
		reg.privacy();
		reg.contButton();

		String actString = reg.getMessage();
		// String confmessageString = reg.confrmmessage();

		if (actString.contains("account/success")) {
			reg.continuebtn();
			reg.myAccount();
			reg.logout();
			System.out.println("Test Case 5 Passed!!");
			// System.out.println(confmessageString);
		} else {

			System.out.println("Test Case 5 Fail");
		}

	}

	// Test Case 6
	@Test(priority = 4,enabled = false)
	public void noNewselter() {
		reg.myAccount();
		reg.regClick();
		reg.firstname("Nitesh");
		reg.lastname("Dixit");
		reg.eMail(mail3);
		reg.password("hass@123");
		reg.confirmPassword("hass@123");
		reg.privacy();
		reg.contButton();

		String actString = reg.getMessage();
		// String confmessageString = reg.confrmmessage();

		if (actString.contains("account/success")) {
			reg.continuebtn();
			reg.myAccount();
			reg.logout();
			System.out.println("Test Case 6 Passed!!");
			// System.out.println(confmessageString);
		} else {

			System.out.println("Test Case 6 Fail");
		}
	}

	// Test case 7
	@Test(priority = 5,enabled = false)
	public void differentWay() {
		reg.myAccount();
		reg.regClick();
		reg.myAccount();
		reg.loginBTN();
		reg.lgnContn();

		String urlString = driver.getCurrentUrl();

		if (urlString.contains("account/register")) {
			System.out.println("Test Case 7.1 Passed");
		} else {
			System.out.println("Test Case 7.1 Fail!!");
		}
		reg.myAccount();
		reg.loginBTN();
		empty.loginPageRegstrLink();
		String url2 = driver.getCurrentUrl();
		if (url2.contains("account/register")) {
			System.out.println("Test Case 7.2 Passed");
		} else {
			System.out.println("Test Case 7.2 Fail!!");
		}
	}

	// Test case 9
	@Test(priority = 6,enabled = false)
	public void existingDetail() {
		reg.myAccount();
		reg.regClick();
		reg.firstname("Diks");
		reg.lastname("Dixit");
		reg.eMail(mail4);
		reg.password("Pass@123");
		reg.confirmPassword("Pass@123");
		reg.subscribr();
		reg.privacy();
		reg.contButton();

		String actalert = driver.findElement(By.id("alert")).getText();
		String expalert = "Warning: E-Mail Address is already registered!";

		soft.assertEquals(expalert, actalert, "Test case 9 Fail!!");

	}

	@BeforeMethod(alwaysRun = true)
	public void a() throws InterruptedException {
		driver.get("https://demo.opencart.com");
		Thread.sleep(2000);
		reg = new Reg_01(driver);
		empty = new EmptyField(driver);

	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		soft = new SoftAssert();

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
