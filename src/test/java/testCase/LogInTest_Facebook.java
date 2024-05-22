package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInTest_Facebook {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup(); // we can move this in base class
		
		WebDriver driver = new ChromeDriver();  // we can move this in base class
		
		driver.get("https://www.facebook.com/");  // properties file
		
		driver.manage().window().maximize();
		
	//	driver.findElement(By.linkText("Sign in")).click();
			
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shubhamchingunde234@gmail.com"); // locators we can maintain in properties file
		
		driver.findElement(By.cssSelector("#pass")).sendKeys("Shubrasi@1515");
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Log in")).click();
       

	}

}
