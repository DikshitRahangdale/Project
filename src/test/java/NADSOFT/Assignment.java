package NADSOFT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Assignment {
	WebDriver driver;
	
	public Assignment(WebDriver driver)
	{
		this.driver=driver;
	}
	public void addMacBook(int a)
	{
		for(int i=0;i<a;i++)
		{
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")).click();
		}
	}
	
	public String successMessage() throws InterruptedException
	{
		Thread.sleep(2000);
		String mssg=driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText();
		return mssg;
	}
	
	public void cardButton()
	{
		driver.findElement(By.cssSelector("a[title='Shopping Cart']")).click();
	}
	
	public void validateURL()
	{
		String expexted="https://tutorialsninja.com/demo/index.php?route=checkout/cart";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(expexted, actual,"Url are Not Match or Page are Not open");
		
	}
	
	public void compairPrice()
	{
		String unitprice=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")).getText();
		String totalpriced =driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")).getText();
		
		unitprice = unitprice.replace("$", "").replace(",", "").trim();
	    totalpriced = totalpriced.replace("$", "").replace(",", "").trim();
		
		double totalP = Double.parseDouble(totalpriced);
		double unti = Double.parseDouble(unitprice);
		
		double all=unti*2;
		
		Assert.assertEquals(all, totalP,"Failed test case Use");
	}
}
