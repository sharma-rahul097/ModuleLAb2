package HotelLogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBean.HotelLoginPageFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdDef {
	WebDriver driver;
	HotelLoginPageFactory objhg;
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objhg = new HotelLoginPageFactory(driver);
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/login.html");
	}

	@When("^enter the valid data for login$")
	public void enter_the_valid_data_for_login() throws Throwable {
		objhg.setUser("capgemini"); Thread.sleep(1000);
	    objhg.setPass("capg1234"); Thread.sleep(1000);
	    objhg.setBtn();
	}

	@Then("^Navigate to registration Page$")
	public void navigate_to_registration_Page() throws Throwable {
		driver.navigate().to("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/hotelbooking.html");
	    driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	    driver.close();
	}

	@When("^enter the incorrect data and clicks the button$")
	public void enter_the_incorrect_data_and_clicks_the_button(DataTable arg1) throws Throwable {
		 List<List<String>> data = arg1.raw();
		   for (int i = 0; i < data.size(); i++) {
				driver.findElement(By.name("userName")).clear();
				Thread.sleep(100);
				driver.findElement(By.name("userPwd")).clear();
				Thread.sleep(100);
				objhg.setUser(data.get(i).get(0));
				Thread.sleep(100);
				objhg.setPass(data.get(i).get(1));
				Thread.sleep(100);
			}
		   objhg.setBtn();
	}

	@Then("^display alert msg$")
	public void display_alert_msg() throws Throwable {
		Alert alert = driver.switchTo().alert();
		System.out.println("The alert:"+ alert.getText());
		alert.accept();
		driver.close();
	}

	@When("^Leaving the username empty and clicks the button$")
	public void leaving_the_username_empty_and_clicks_the_button() throws Throwable {
		objhg.setUser("");
		objhg.setBtn();
	}

	@Then("^display usererror msg$")
	public void display_usererror_msg() throws Throwable {
	    objhg.getPferroruser();
	    driver.close();
	}

	@When("^Leaving the password empty and clicks the button$")
	public void leaving_the_password_empty_and_clicks_the_button() throws Throwable {
		objhg.setUser("capgemini"); Thread.sleep(1000);
	    objhg.setPass("");
	    objhg.setBtn();
	}

	@Then("^display pwderror msg$")
	public void display_pwderror_msg() throws Throwable {
	    objhg.getPferrorpwd();
	    driver.close();
	}

}
