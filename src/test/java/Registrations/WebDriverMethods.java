package Registrations;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class WebDriverMethods {
	WebDriver driver;

	public WebDriverMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void urlValidation()
	{
		String urlString=driver.getCurrentUrl();
		
		
	}
	
	
	public void hardAssertionValidation(String actual, String expected) {
	    Assert.assertEquals(actual, expected);
	}


}
