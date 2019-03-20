package webDrivers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBean.PageFactoryForm;

public class WorkingWithForms {

	static WebDriver driver;
	public static void main(String[] args) {
		PageFactoryForm objpg;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		objpg = new PageFactoryForm(driver);
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/WorkingWithForms.html");

		try {
			objpg.setPfuser("Rshar126");
			Thread.sleep(100);
			objpg.setPfpass("asr");
			Thread.sleep(100);
			objpg.setPfConfirmPass("asr");
			Thread.sleep(100);
			objpg.setPfFName("Rahul");
			Thread.sleep(100);
			objpg.setPfLname("Sharma");
			Thread.sleep(100);
			objpg.setPfgender("input[value='Female']");
			Thread.sleep(100);
			objpg.setPfDob("11-06-1997");	
			Thread.sleep(100);
			objpg.setPfEmail("rs985826695@gmail.com");
			Thread.sleep(100);
			objpg.setPfaddr("deep puram,aurangabad,Mathura");
			Thread.sleep(100);
			objpg.setPfcity("Pune");
			objpg.setPfphone("7894561239");
			Thread.sleep(100);
			objpg.setPfhobby("input[value='Reading']");
			Thread.sleep(100);
			objpg.setPfhobby("input[value='Music']");
			Thread.sleep(100);
			objpg.setPfsubmit();
			Catch();
			Thread.sleep(100);
			objpg.setPfreset();
			Thread.sleep(100);
			driver.close();
			/*List<WebElement> element = driver.findElements(By.name("chkHobbies"));
			for(WebElement wb: element)
			{
				wb.click();
				
				try
				{
					Thread.sleep(100);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}*/
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void Catch()
	{
		Alert alert = driver.switchTo().alert();
		System.out.println("The message:"+ alert.getText());
		alert.accept();
	}
}
