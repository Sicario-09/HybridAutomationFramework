package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;


public class MyFirstTestFW extends BaseTest {
	
	@Test(dataProvider="testdata")
	public static void SignInTest(String username, String password) throws InterruptedException
	{

		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );	
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("emailid_field"))));		
		element.sendKeys(username);	
		//driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("chingundeshubham.94@gmail.com");		
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();		
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10) );		
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("password_field"))));		
		element1.sendKeys(password);		
		driver.findElement(By.xpath(loc.getProperty("signin_button"))).click();
	}
	
	@DataProvider(name="testdata")
	
	public Object[][] createdata(){
		
		return new Object[][]
				{
			{"chingundeshubham.4@gmail.com" ,"Shubrasi@1513"},
			{"chingundeshubham.93@gmail.com" ,"Shubrasi@15152"},
			{"chingundeshubham.14@gmail.com" ,"Shubrasi@151"},
			{"chingundeshubham.94@gmail.com" ,"Shubrasi@1515"}
		
				};
	                              }
	
}

