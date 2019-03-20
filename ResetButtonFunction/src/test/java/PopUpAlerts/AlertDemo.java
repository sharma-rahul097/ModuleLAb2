package PopUpAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/AlertBoxDemos.html");
		
		driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println("The alert message is:"+alert.getText());
		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		
		Alert confirm  = driver.switchTo().alert();
		confirm.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		
		confirm  = driver.switchTo().alert();
		confirm.dismiss();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("rahul");
		Thread.sleep(2000);
		prompt.accept();
		Thread.sleep(2000);
		/*String text = prompt.getText();
		System.out.println(text);
		Thread.sleep(2000);*/
		
		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		
		prompt = driver.switchTo().alert();
		prompt.dismiss();
		Thread.sleep(2000);
		
		String text1 = prompt.getText();
		System.out.println(text1);
		Thread.sleep(2000);
		
		driver.quit();
	}
}
