package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties pr = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	@BeforeMethod
	public void setUp() throws IOException  // In setUp() method basically contains browser invoke, file reading and contains info of base url etc.
	{
		if(driver==null) {
			
			 fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties"); //this method reads the data and location of config.properties file
		     fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties"); // this method will read the data and location of locators.properties file
			pr.load(fr);
			loc.load(fr1);
		}
		
		if(pr.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.get(pr.getProperty("testurl"));
			 driver.manage().window().maximize();
		}
		else if(pr.getProperty("browser").equalsIgnoreCase("firefox")) {
			
            WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver(); 
        	 driver.get(pr.getProperty("testurl"));
        	 driver.manage().window().maximize();
		}
		
	}
	
	@AfterMethod
	public void tearDown()    // In tearDown() method basically contains exit current sessions and logout from applications and closing browser etc.
	{
		driver.close();
		
	}

}
