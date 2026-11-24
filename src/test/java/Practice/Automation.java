package Practice;

import java.awt.Desktop.Action;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Automation {
	WebDriver driver;
	Actions mouse;

	public Automation(WebDriver driver) {
		this.driver = driver;
		mouse = new Actions(driver);
	}

	public void inputField(String name, String email, String phone, String address) {
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.id("textarea")).sendKeys(address);
	}

	public void gender() {
		List<WebElement> gendElements = driver.findElements(By.xpath(
				"//*[@id=\"post-body-1307673142697428135\"]/div[3]/div/input"));
		System.out.println(gendElements.size());

		for (WebElement gen : gendElements) {
			System.out.println(gen.getText());
			System.out.println(gen.isDisplayed());
			System.out.println(gen.isEnabled());
			System.out.println(gen.isSelected());
		}

		gendElements.get(0).click();

		for (WebElement gen : gendElements) {

			System.out.println(gen.isDisplayed());
			System.out.println(gen.isEnabled());
			System.out.println(gen.isSelected());
		}

	}

	public void mouse() {
		WebElement hover = driver.findElement(By.xpath("//*[@id=\"HTML3\"]/div[1]/div/button"));
		mouse.moveToElement(hover).perform();

		WebElement dbl = driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
		mouse.doubleClick(dbl).perform();

	}
	
	public void slider()
	{
		WebElement drag=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		mouse.clickAndHold(drag).moveByOffset(50, 0).release().perform();
	}

}
