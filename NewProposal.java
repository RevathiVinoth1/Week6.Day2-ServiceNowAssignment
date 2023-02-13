package main.java.servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NewProposal extends ServiceNow {
	@Test

	public  void runNewProposal() throws InterruptedException {

		/*
		 * ChromeOptions option1 = new ChromeOptions();
		 * option1.addArguments("--disable-notifications"); ChromeDriver driver = new
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
		 * Shadow shdom = new Shadow(driver); shdom.setImplicitWait(30);
		 * shdom.findElementByXPath("//div[text()='All']").click();
		 * shdom.setImplicitWait(30);
		 */

		shdom.findElementByXPath("//input[@id='filter']").sendKeys("Proposal", Keys.ENTER);

		shdom.findElementByXPath("//mark[@class='filter-match']").click();
		// shdom.findElementByXPath("//span[@class='label']").click();

		Thread.sleep(2000);

		WebElement shframe = shdom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(shframe);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']"))
				.sendKeys("Proposal Created Successfully");

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		String text = driver.findElement(By.xpath("(//a[@class='linked formlink'])[2]")).getText();
		System.out.println("The Proposal Number Is:" + text);

		if (text.contains("Successfully"))
		{
			System.out.println("New Proposal Created");

		}
		else 
		{
			System.out.println("New Proposal Not Created");
		}

	}

}
