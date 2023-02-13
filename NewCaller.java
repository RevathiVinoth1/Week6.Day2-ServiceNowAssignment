package main.java.servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NewCaller extends ServiceNow {
	@Test

	public void runNewCaller() throws InterruptedException {

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
		shdom.setImplicitWait(20);*/

		shdom.findElementByXPath("//input[@id='filter']").sendKeys("Callers", Keys.ENTER);
		shdom.findElementByXPath("//mark[text()='Callers']").click();
		
		WebElement shframe = shdom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(shframe);
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Revathi");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Vinoth");
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("Cheif Executive Officer");
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("revathivinoth@gmail.com");
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("9854323445");
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("9324232454");
		
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		
		WebElement get = driver.findElement(By.xpath("//div[@class='outputmsg_text']"));
		String text = get.getText();
		System.out.println(text);
		
		
		WebElement select = driver.findElement(By.xpath("//select[@role='listbox']"));
		Select lname=new Select(select);
		lname.selectByVisibleText("Last name");
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Vinoth",Keys.ENTER);
		WebElement text2 = driver.findElement(By.xpath("(//a[text()='Vinoth']/parent::td)[1]"));
		String name = text2.getText();
		System.out.println(name);
		
		if(name.contains("Vinoth")) {
			System.out.println("The Caller Created Successfully");
		}
		else 
		{
			System.out.println("The Caller Not Created");
		}
		
	}

}
