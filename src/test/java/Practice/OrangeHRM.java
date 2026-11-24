package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM {
	WebDriver driver;

	public OrangeHRM(WebDriver driver) {
		this.driver = driver;
	}

	public void userAndPassword(String user, String pass) {
		driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
				.sendKeys(user);
		driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
				.sendKeys(pass);
	}

	public void loginBtn() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}
}
