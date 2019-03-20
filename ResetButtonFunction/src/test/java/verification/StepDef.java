package verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	@Given("^Open the firefox and lauch the application$")
	public void open_the_firefox_and_lauch_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/WorkingWithForms.html");
	}

	@When("^Enter the Valid Data$")
	public void enter_the_Valid_Data(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    List<List<String>> al = arg1.raw();
	    driver.findElement(By.id("txtUserName")).sendKeys(al.get(1).get(1));
		Thread.sleep(100);
		driver.findElement(By.id("txtPassword")).sendKeys(al.get(2).get(1));
		Thread.sleep(100);
		driver.findElement(By.className("Format")).sendKeys(al.get(3).get(1));
		Thread.sleep(100);
		driver.findElement(By.cssSelector("input.Format1")).sendKeys(al.get(4).get(1));
		Thread.sleep(100);
		driver.findElement(By.id("txtLastName")).sendKeys(al.get(5).get(1));
		Thread.sleep(100);
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		Thread.sleep(100);
		driver.findElement(By.name("DtOB")).sendKeys("06/11/1997");
		Thread.sleep(100);
		driver.findElement(By.name("Email")).sendKeys(al.get(6).get(1));
		Thread.sleep(100);
		driver.findElement(By.name("Address")).sendKeys(al.get(7).get(1));
		Thread.sleep(100);
		Select drpCity = new Select(driver.findElement(By.name("City")));
		drpCity.selectByVisibleText("Mumbai");
		driver.findElement(By.xpath(".//*[@id='txtPhone']")).sendKeys(al.get(8).get(1));
		Thread.sleep(100);
		driver.findElement(By.cssSelector("input[value='Reading']")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("input[value='Music']")).click();
		Thread.sleep(100);
	}

	@Then("^User registrattion should be successfull$")
	public void user_registrattion_should_be_successfull() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("reset")).click();
		Thread.sleep(100);
	    driver.close();
	}
}
