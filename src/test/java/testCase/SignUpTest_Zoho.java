package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpTest_Zoho {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.zoho.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Sign up")).click();
		
		driver.findElement(By.id("email")).sendKeys("chingundeshubham.94@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("Shubrasi@1515");
		
		driver.findElement(By.id("rmobile")).sendKeys("8554043333");
		
		WebElement checkbox = driver.findElement(By.id("signup-termservice"));
		
		if (!checkbox.isSelected()) {
           
            checkbox.click();
        }
		
		driver.findElement(By.id("signupbtn")).click();


	}

}
