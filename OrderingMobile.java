package main.java.servicenow;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class OrderingMobile extends ServiceNow{
	@Test

	public void runOrderingMoble() throws IOException {
			
		/*
		 * ChromeOptions option1=new ChromeOptions();
		 * option1.addArguments("--disable-notifications"); ChromeDriver driver=new
		 * ChromeDriver(option1); driver.get("https://dev65047.service-now.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * 
		 * driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		 * driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(
		 * "Jaisriram@1");
		 * 
		 * driver.findElement(By.xpath("//button[text()='Log in']")).click();
		 * 
		 * Shadow shdom=new Shadow(driver); shdom.setImplicitWait(30);
		 * shdom.findElementByXPath("//div[text()='All']").click();
		 * shdom.setImplicitWait(20);
		 */
		shdom.findElementByXPath("//span[text()='Service Catalog']").click();
		
		WebElement shframe = shdom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(shframe);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		WebElement option = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select opt=new Select(option);
		opt.selectByValue("Unlimited");
		driver.findElement(By.xpath("(//label[@class='radio-label'])[4]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[11]")).click();
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		String request = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		System.out.println(request);
		String reqnum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println(reqnum);
		File source=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./servicenow/webpage.png");
		FileUtils.copyFile(source, dest);
		//driver.close();
	}

}
