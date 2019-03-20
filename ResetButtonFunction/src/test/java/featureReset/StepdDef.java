package featureReset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdDef {
	WebDriver driver;
	@Given("^Open the firefox and launch the application$")
	public void open_the_firefox_and_launch_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/WorkingWithForms.html");
//	    throw new PendingException();
	}

	@When("^Enter the Username and Password$")
	public void enter_the_Username_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("txtUserName")).sendKeys("rshar126");
		Thread.sleep(100);
		driver.findElement(By.id("txtPassword")).sendKeys("asd");
		Thread.sleep(100);
//	    throw new PendingException();
	}

	@Then("^Reset the credentials$")
	public void reset_the_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("reset")).click();
		Thread.sleep(100);
//	    throw new PendingException();
	}
}
