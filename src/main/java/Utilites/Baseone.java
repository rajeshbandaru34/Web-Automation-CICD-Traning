package Utilites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import POM.Web_Elements;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Baseone {
	public static Web_Elements elements; 
	public static WebDriver driver;
	
	@BeforeTest
	public static void install() {
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();  
		elements = PageFactory.initElements(driver, Web_Elements.class);
	}
	
	public static void Senddata(WebElement element, String string) {
		element.sendKeys(string);
	}
	public static void Click(WebElement element) {
		element.click();
	}
	public static void get(String URL) {
		driver.get(URL);
	}
	public static void implicitlywait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
