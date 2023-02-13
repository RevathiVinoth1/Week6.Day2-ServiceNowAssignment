package main.java.servicenow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class MandatoryFields extends ServiceNow{
	@Test

	public void runMandatory() throws InterruptedException{
		
		/*ChromeOptions option1 = new ChromeOptions();
		option1.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option1);
		driver.get("https://dev65047.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Jaisriram@1");

		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		Shadow shdom = new Shadow(driver);
		shdom.setImplicitWait(30);
		shdom.findElementByXPath("//div[text()='All']").click();
		sh
		dom.setImplicitWait(20);*/

		shdom.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge", Keys.ENTER);
		shdom.findElementByXPath("//mark[text()='Knowledge']").click();
		
		
		WebElement shframe = shdom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(shframe);
		
		driver.findElement(By.xpath("//span[@class='btn-text']")).click();
		
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windows);
		
		driver.switchTo().window(handles.get(1));
		driver.findElement(By.xpath("//a[text()='IT']")).click();
		driver.switchTo().window(handles.get(0));
		driver.switchTo().frame(shframe);

		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).sendKeys("Java", Keys.ENTER);
		/*
		 * driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']"
		 * )).click(); Set<String> windows1 = driver.getWindowHandles(); List<String>
		 * handles1 = new ArrayList<String>(windows1);
		 * 
		 * driver.switchTo().window(handles1.get(1)); Thread.sleep(500);
		 * 
		 * driver.findElement(By.xpath("//span[text()='IT']")).click();
		 * driver.findElement(By.xpath("//span[text()='Java']")).click();
		 * driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		 * driver.switchTo().window(handles.get(0));
		 */		
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("I am having complete Knowledge in JAVA concepts");
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[1]")).click();
		

		
	}

}
