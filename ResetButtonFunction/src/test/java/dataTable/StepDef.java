package dataTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;

	@Given("^Open the firefox and launch the application$")
	public void open_the_firefox_and_launch_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/WorkingWithForms.html");

	}

	@When("^Enter the Username and Password$")
	public void enter_the_Username_and_Password(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> al = arg1.raw();
		for (int i = 0; i < al.size(); i++) {
			driver.findElement(By.id("txtUserName")).clear();
			Thread.sleep(100);
			driver.findElement(By.id("txtPassword")).clear();
			Thread.sleep(100);
			driver.findElement(By.id("txtUserName")).sendKeys(al.get(i).get(0));
			Thread.sleep(100);
			driver.findElement(By.id("txtPassword")).sendKeys(al.get(i).get(1));
			Thread.sleep(100);
		}
	}

	@Then("^Reset the credential$")
	public void reset_the_credential() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("reset")).click();
		Thread.sleep(100);

	}
}
