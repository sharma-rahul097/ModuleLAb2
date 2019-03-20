package CatchAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelAlert {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/hotelbooking.html");
		
		/**************************************************************/
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		
		/**************************************************************/
		driver.findElement(By.id("txtFirstName")).sendKeys("rahul");
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		
		/**************************************************************/
		driver.findElement(By.id("txtLastName")).sendKeys("Sharma");
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		
		/**************************************************************/
		driver.findElement(By.id("txtEmail")).sendKeys("Rs9858@gmail.com");
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		
		/**************************************************************/
		driver.findElement(By.id("txtPhone")).sendKeys("7894561239");
		driver.findElement(By.tagName("textarea")).sendKeys("arskhdkjlhsajdhjakshdljkhasjkldhajkshdjkashfkj");
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
	
		/**************************************************************/
		Select drpCity1 = new Select(driver.findElement(By.name("city")));
		drpCity1.selectByVisibleText("Pune");
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		/**************************************************************/
		Select state1 = new Select(driver.findElement(By.name("state")));
		state1.selectByVisibleText("Karnataka");
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		/**************************************************************/
		Select no1 = new Select(driver.findElement(By.name("persons")));
		no1.selectByValue("2");		
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		/**************************************************************/
		driver.findElement(By.id("txtCardholderName")).sendKeys("Rahul Sharma");			
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		/**************************************************************/
		driver.findElement(By.id("txtDebit")).sendKeys("789131565675345698");				
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		/**************************************************************/
		driver.findElement(By.id("txtCvv")).sendKeys("182");			
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		/**************************************************************/
		driver.findElement(By.id("txtMonth")).sendKeys("January");			
		driver.findElement(By.id("btnPayment")).click();
		Catch();
		Thread.sleep(1000);
		/**************************************************************/
		driver.findElement(By.id("txtYear")).sendKeys("2018");		
		Thread.sleep(1000);
	}
	
	public static void Catch() throws InterruptedException
	{
		Alert btnPayment = driver.switchTo().alert();
		System.out.println("The alert:"+ btnPayment.getText());
		btnPayment.accept();
		Thread.sleep(1000);
	}
}
