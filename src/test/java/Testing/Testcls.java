package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcls {
	
	WebDriver driver =null;
	WebElement element,size;
	Actions act;
	void waits() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@BeforeClass
	public void init() {
		
		System.out.println("browser started");
		//chrome browser setup
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		act=new Actions(driver);	
		//launching the URL
		driver.manage().window().maximize();
		driver.get("http://www.htmlcanvasstudio.com/");
				
	}
	@Test(priority=1)
	public void clickline() {
		driver.findElement(By.xpath("//input[@title='Draw a line']")).click();
		
		//element.click();
	}
	@Test(priority=2)
	public void horizontal() {
		element=driver.findElement(By.id("imageTemp"));
		act.clickAndHold(element).moveByOffset(-100, 0).perform();
		act.moveByOffset(0, 0).perform();
		act.click();
		act.release().perform();
		act.clickAndHold(element).moveByOffset(0, 0).perform();
		act.moveByOffset(100, 0).perform();
		act.click();
		act.release().perform();
		waits();
		
	}
	@Test(priority=2)
	public void verticalline() {
		act.clickAndHold(element).moveByOffset(0,-100).perform();
		act.moveByOffset(0, 0).perform();
		act.click();
		act.release().perform();
		act.clickAndHold(element).moveByOffset(0, 0).perform();
		act.moveByOffset(0, 100).perform();
		act.click();
		act.release().perform();
		act.release(element).perform();
		waits();
	}
	@Test(priority=3)
	public void clickrecatngle() {
		driver.findElement(By.xpath("//input[@title='Draw a rectangle']")).click();
	}
		
	@Test(priority=5)
	public void recangledrwaing() {
		act.moveToElement(element, 10, 160)
		.click()
		.moveByOffset(-50, 10)
		.release().perform();

	}
	@Test(priority=6)
	public void clickeraser() {
		driver.findElement(By.xpath("//input[@title='Use eraser']")).click();
		//increase the size of the eraser
		size=driver.findElement(By.xpath("//div[@id='slider']/a"));
		act.clickAndHold(size).perform();
		act.moveByOffset(5, 0).perform();
		act.release(size).perform();
	}
	@Test(priority=7)
	public void erasehorizontalline() {
		act.clickAndHold(element).moveByOffset(-100,0).perform();
		act.moveByOffset(0, 0).perform();
		act.click();
		act.release().perform();
		act.clickAndHold(element).moveByOffset(0, 0).perform();
		act.moveByOffset(100, 0).perform();
		act.click();
		act.release().perform();
		act.release(element).perform();
	}
	
	@AfterClass
	public void teardown() {	
		driver.close();
		System.out.println("browser closed");
	}
}
