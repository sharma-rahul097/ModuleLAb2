package HotelBooking;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBean.HotelBookingPagefactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	HotelBookingPagefactory objhg;
	@Given("^user is on hotel booking page$")
	public void user_is_on_hotel_booking_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RSHAR126\\Desktop\\core java\\Module 3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objhg = new HotelBookingPagefactory(driver);
		driver.get("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/hotelbooking.html");
	}

	@Then("^Check the title of the page$")
	public void check_the_title_of_the_page() throws Throwable {
		String title=driver.getTitle();
		if(title.contentEquals("Hotel Booking")) System.out.println("****** Title Matched");
		else System.out.println("****** Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.close();
	}

	@When("^user enters all valid data$")
	public void user_enters_all_valid_data() throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("rutukulkarni2003@yahoo.com");	Thread.sleep(100);
		objhg.setPfmob("7722005480");	Thread.sleep(100);
		objhg.setPfcity("Pune");	Thread.sleep(100);
		objhg.setPfstate("Maharashtra");	Thread.sleep(100);
		objhg.setPfperson("5");	Thread.sleep(100);
		objhg.setPfcard("Rutuja Kulkarni");	Thread.sleep(100);
		objhg.setPfdebit("5678567867897890");	Thread.sleep(100);
		objhg.setPfcvv("067");	Thread.sleep(100);
		objhg.setPfexpmon("5");	Thread.sleep(100);
		objhg.setPfexpyr("2020"); 
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		objhg.setPfbtn();
		
	}

	@Then("^navigate to welcome page$")
	public void navigate_to_welcome_page() throws Throwable {
		driver.navigate().to("file:///C:/Users/RSHAR126/Desktop/core%20java/Module%203/BDD/success.html");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.close();
	}

	@When("^user leaves first Name blank$")
	public void user_leaves_first_Name_blank() throws Throwable {
		 objhg.setPffname(""); Thread.sleep(100);
		 
	}

	@When("^clicks the button$")
	public void clicks_the_button() throws Throwable {
		 objhg.setPfbtn();
	}

	@Then("^display alert msg$")
	public void display_alert_msg() throws Throwable {
		Alert alert = driver.switchTo().alert();
		System.out.println("The alert:"+ alert.getText());
		alert.accept();
		driver.close();
	}

	@When("^user leaves last name blankand clicks the button$")
	public void user_leaves_last_name_blankand_clicks_the_button() throws Throwable {
		objhg.setPffname("Rahul"); Thread.sleep(100);
	    objhg.setPflname("");
	    objhg.setPfbtn();
	}

	@When("^user leaves email blankand clicks the button$")
	public void user_leaves_email_blankand_clicks_the_button() throws Throwable {
		objhg.setPffname("Rahul"); Thread.sleep(100);
		objhg.setPflname("Sharma"); Thread.sleep(100);
	    objhg.setPfemail("");
	    objhg.setPfbtn();

	}

	@When("^user enters the incorrect emailand clicks the button$")
	public void user_enters_the_incorrect_emailand_clicks_the_button() throws Throwable {
		objhg.setPfemail("rk26@.com");
		 objhg.setPfbtn();

	}

	@When("^user leaves Mobile no blank and clicks the button$")
	public void user_leaves_Mobile_no_blank_and_clicks_the_button() throws Throwable {
		objhg.setPffname("Rahul"); Thread.sleep(100);
		 objhg.setPflname("Sharma"); Thread.sleep(100);
		 objhg.setPfemail("Rahuls@gmail.com");
		objhg.setPfmob("");
		 objhg.setPfbtn();

	}

	@When("^user enters incorrect mobileno format and clicks the button$")
	public void user_enters_incorrect_mobileno_format_and_clicks_the_button(DataTable arg1) throws Throwable {
		objhg.setPffname("Rahul"); Thread.sleep(100);
		 objhg.setPflname("Sharma"); Thread.sleep(100);
		 objhg.setPfemail("Rahuls@gmail.com"); Thread.sleep(100);
		 
		 List<String> al = arg1.asList(String.class);
//		 objhg.setPfmob(al);
		 objhg.setPfbtn();
		 for(int i=0; i<al.size(); i++) {
				if(Pattern.matches("^[7-9]{1}[0-9]{9}$", al.get(i))) {
				System.out.println("***** Matched" + al.get(i) + "*****");
				}
				else {
					System.out.println("***** NOT Matched" + al.get(i) + "*****");
				}
			}
	
	}

	@When("^user does not select city$")
	public void user_does_not_select_city() throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("rutuja.k@gmail.com");	Thread.sleep(100);
		objhg.setPfmob("7722005480");	Thread.sleep(100);
		objhg.setPfcity("Select City");	Thread.sleep(100);
		 objhg.setPfbtn();

	}

	@When("^user does not select state$")
	public void user_does_not_select_state() throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("rutuja.k@gmail.com");	Thread.sleep(100);
		objhg.setPfmob("7722005480");	Thread.sleep(100);
		objhg.setPfcity("Pune");	Thread.sleep(100);
		objhg.setPfstate("Select State");	Thread.sleep(100);
		 objhg.setPfbtn();

	}

	@When("^user enters (\\d+)$")
	public void user_enters(String arg1) throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("rutuja.k@gmail.com");	Thread.sleep(100);
		objhg.setPfmob("7722005480");	Thread.sleep(100);
		objhg.setPfcity("Pune");	Thread.sleep(100);
		objhg.setPfstate("Maharashtra");	Thread.sleep(100);
		objhg.setPfperson(arg1);	Thread.sleep(100);
		 objhg.setPfbtn();

	}

	@Then("^allocate rooms such that (\\d+) room for minimum (\\d+) guests$")
	public void allocate_rooms_such_that_room_for_minimum_guests(int arg1, int arg2) throws Throwable {
		if(arg2 <=3) {
	    	System.out.println("***** 1 room");
	    	assertEquals(1, arg1);
	    }
	    else if(arg2 <=6){
	    	System.out.println("***** 2 rooms");
	    	assertEquals(2, arg1); 	
	    }	 
	    else if(arg2 <=9){
	    	System.out.println("***** 3 rooms");
	    	assertEquals(3, arg1); 	
	    }
	
	}

	@When("^user leaves CardHolderName blank and clicks the button$")
	public void user_leaves_CardHolderName_blank_and_clicks_the_button() throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("rutuja.k@gmail.com");	Thread.sleep(100);
		objhg.setPfmob("7722005480");	Thread.sleep(100);
		objhg.setPfcity("Pune");	Thread.sleep(100);
		objhg.setPfstate("Maharashtra");	Thread.sleep(100);
		objhg.setPfperson("7");	Thread.sleep(100);
		objhg.setPfcard("");	Thread.sleep(100);
		 objhg.setPfbtn();
		
	}

	@When("^user leaves DebitCardNo blank and clicks the button$")
	public void user_leaves_DebitCardNo_blank_and_clicks_the_button() throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("rutuja.k@gmail.com");	Thread.sleep(100);
		objhg.setPfmob("7722005480");	Thread.sleep(100);
		objhg.setPfcity("Pune");	Thread.sleep(100);
		objhg.setPfstate("Maharashtra");	Thread.sleep(100);
		objhg.setPfperson("7");	Thread.sleep(100);
		objhg.setPfcard("Rutuja Kulkarni");	Thread.sleep(100);
		objhg.setPfdebit("");	Thread.sleep(100);
		 objhg.setPfbtn();
		 
	}

	@When("^user leaves ExpirationMonth blank and clicks the button$")
	public void user_leaves_ExpirationMonth_blank_and_clicks_the_button() throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("rutuja.k@gmail.com");	Thread.sleep(100);
		objhg.setPfmob("7722005680");	Thread.sleep(100);
		objhg.setPfcity("Pune");	Thread.sleep(100);
		objhg.setPfstate("Maharashtra");	Thread.sleep(100);
		objhg.setPfperson("7");	Thread.sleep(100);
		objhg.setPfcard("Rutuja Kulkarni");	Thread.sleep(100);
		objhg.setPfdebit("8765431234567898");	Thread.sleep(100);
		objhg.setPfcvv("098");	Thread.sleep(100);
		objhg.setPfexpmon("");	Thread.sleep(100);
		 objhg.setPfbtn();
	
	}

	@When("^user leaves ExpirationYr blank and clicks the button$")
	public void user_leaves_ExpirationYr_blank_and_clicks_the_button() throws Throwable {
		objhg.setPffname("Rutuja");	Thread.sleep(100);
		objhg.setPflname("Kulkarni");	Thread.sleep(100);
		objhg.setPfemail("Rutu.k@gmail.com");	Thread.sleep(100);
		objhg.setPfmob("7722005680");	Thread.sleep(100);
		objhg.setPfcity("Pune");	Thread.sleep(100);
		objhg.setPfstate("Maharashtra");	Thread.sleep(100);
		objhg.setPfperson("7");	Thread.sleep(100);
		objhg.setPfcard("Rutu Kulkarni");	Thread.sleep(100);
		objhg.setPfdebit("7678567867897890");	Thread.sleep(100);
		objhg.setPfcvv("056");	Thread.sleep(100);
		objhg.setPfexpmon("8");	Thread.sleep(100);
		objhg.setPfexpyr("");	Thread.sleep(100);
		 objhg.setPfbtn();
	
	}
}
