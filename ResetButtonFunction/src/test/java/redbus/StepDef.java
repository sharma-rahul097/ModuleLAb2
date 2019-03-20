package redbus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	@Given("^Open the chrome and Launch the Application$")
	public void open_the_chrome_and_Launch_the_Application() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
	}

	@When("^Enter the Valid data$")
	public void enter_the_Valid_data() throws Throwable {
	    driver.findElement(By.id("src")).sendKeys("Pune");
	    Thread.sleep(1000);
	    driver.findElement(By.id("dest")).sendKeys("Mumbai");
	    Thread.sleep(1000);
	    /****************************************/
	    driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/span")).click();
        WebElement dateWidgetFrom = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody"));
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
       for (WebElement cell: columns) {
          if (cell.getText().equals("19")) {
                cell.click();
                break;
            }
        }
       Thread.sleep(1000);
       /********************************************/
       driver.findElement(By.xpath(".//*[@id='search']/div/div[4]/span")).click();
       WebElement dateWidgetFrom1 = driver.findElement(By.xpath(".//*[@id='rb-calendar_return_cal']/table/tbody"));
       
       List<WebElement> columns1 = dateWidgetFrom1.findElements(By.tagName("td"));
       
       for (WebElement cell1: columns1) {
    	   if (cell1.getText().equals("21")) {
    		   cell1.click();
    		   break;
    	   }
       }
       Thread.sleep(1000);
	    driver.findElement(By.id("search_btn")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='8194310']/div/div[2]/div[1]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='rt_8194310']/div/div/div/div[1]/div/div/ul/li[2]")).click();
	    
//	    driver.findElement(By.className("pointer")).click();
	    Actions ToolTip1 = new Actions(driver); 
	   
	    WebElement element = driver.findElement(By.xpath(".//*[@id='rt_8194310']/div/div/div/div[3]/div[2]/div[2]/canvas")); 
	    Thread.sleep(1000); 
	    ToolTip1.moveToElement(element).moveByOffset(461,586).click().build().perform();
	}

	@Then("^Search and Check Result$")
	public void search_and_Check_Result() throws Throwable {
	    if(driver.getCurrentUrl()=="https://www.redbus.in/search?fromCityName=Pune%20%28All%20Locations%29&fromCityId=130&toCityName=Mumbai%20%28All%20Locations%29&toCityId=462&onward=19-Mar-2019&return=21-Mar-2019&opId=0&busType=Any")
	    {
	    	System.out.println("matched**********");
	    }
	    else
	    {
	    	System.out.println("Not Matched**************");
	    }
	}
}
