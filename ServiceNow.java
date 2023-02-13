package main.java.servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.sukgu.Shadow;

public class ServiceNow {
	
	public  ChromeDriver driver;
	public   ChromeOptions option1;
	public Shadow shdom;

	@BeforeMethod
	public void runServiceNow() {
		
		option1=new ChromeOptions();
		option1.addArguments("--disable-notifications");
		driver=new ChromeDriver(option1);
		driver.get("https://dev65047.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Jaisriram@1");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		shdom=new Shadow(driver);
		shdom.setImplicitWait(30);
		shdom.findElementByXPath("//div[text()='All']").click();
		shdom.setImplicitWait(20);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
