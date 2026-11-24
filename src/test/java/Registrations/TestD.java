package Registrations;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestD {
	WebDriver driver;

	public TestD(WebDriver driver) {
		this.driver = driver;
	}

	public void newsSelectorLink() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/ul[4]/li/a")).click();
	}

	public void newsSelectorOptions() {
//		WebElement yesElement=driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input"));
//		System.out.println("Yes is Selected: "+ yesElement.isSelected());

		List<WebElement> news = driver.findElements(By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label/input"));
		int count = 1;
		for (WebElement nw : news) {
			System.out.println(count + " " + nw.isSelected());
			count++;
		}
	}

	public void loginPageRegistration() {
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Register']")).click();
	}
	
	public String confirmPasswordWarning()
	{
		return driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")).getText();
	}

}
