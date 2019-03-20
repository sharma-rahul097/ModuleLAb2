package PageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPagefactory {

	WebDriver driver;
	
	@FindBy(how = How.NAME,using = "txtFN")
	@CacheLookup
	WebElement pffname;
	
	@FindBy(how = How.ID,using = "btnPayment")
	@CacheLookup
	WebElement pfbtn;
	
	@FindBy(how = How.NAME,using = "txtLN")
	@CacheLookup
	WebElement pflname;
	
	
	@FindBy(how = How.NAME,using = "Email")
	@CacheLookup
	WebElement pfemail;
	
	
	@FindBy(css = "input[pattern='[789][0-9]{9}']")
	@CacheLookup
	WebElement pfmob;
	
	
	@FindBy(how = How.TAG_NAME, using = "textarea")
	@CacheLookup
	WebElement pfaddr;
	
	
	@FindBy(how = How.NAME,using = "city")
	@CacheLookup
	WebElement pfcity;

	@FindBy(how = How.NAME,using = "state")
	@CacheLookup
	WebElement pfstate;

	@FindBy(how = How.NAME,using = "persons")
	@CacheLookup
	WebElement pfperson;
	
	@FindBy(xpath="//*[@id='rooms']")
	@CacheLookup
	WebElement pfrooms; 
	
	@FindBy(how = How.ID,using = "txtCardholderName")
	@CacheLookup
	WebElement pfcard;
	
	
	@FindBy(how = How.NAME,using = "debit")
	@CacheLookup
	WebElement pfdebit;
	
	
	@FindBy(how = How.NAME,using ="cvv")
	@CacheLookup
	WebElement pfcvv;
	
	
	@FindBy(how = How.NAME,using = "month")
	@CacheLookup
	WebElement pfexpmon;
	
	
	@FindBy(how = How.NAME,using ="year")
	@CacheLookup
	WebElement pfexpyr;


	public HotelBookingPagefactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getPffname() {
		return pffname;
	}


	public void setPffname(String sfname) {
		pffname.sendKeys(sfname);
	}


	public WebElement getPfbtn() {
		return pfbtn;
	}


	public void setPfbtn() {
		pfbtn.click();
	}


	public WebElement getPflname() {
		return pflname;
	}


	public void setPflname(String sflname) {
		pflname.sendKeys(sflname);
	}


	public WebElement getPfemail() {
		return pfemail;
	}


	public void setPfemail(String sfemail) {
		pfemail.sendKeys(sfemail);
	}


	public WebElement getPfmob() {
		return pfmob;
	}


	public void setPfmob(String sfmob) {
		pfmob.sendKeys(sfmob);
	}


	public WebElement getPfaddr() {
		return pfaddr;
	}


	public void setPfaddr(String sfaddr) {
		pfaddr.sendKeys(sfaddr);
	}


	public WebElement getPfcity() {
		return pfcity;
	}


	public void setPfcity(String sfcity) {
		Select drpCity = new Select(pfcity);
		drpCity.selectByVisibleText(sfcity);
	}


	public WebElement getPfstate() {
		return pfstate;
	}


	public void setPfstate(String sfstate) {
		Select drpState = new Select(pfstate);
		drpState.selectByVisibleText(sfstate);
	}


	public WebElement getPfperson() {
		return pfperson;
	}


	public void setPfperson(String arg1) {
		Select drpPer = new Select(pfperson);
		drpPer.selectByVisibleText(arg1);
	}


	public WebElement getPfrooms() {
		return pfrooms;
	}


//	public void setPfrooms(WebElement pfrooms) {
//		this.pfrooms = pfrooms;
//	}


	public WebElement getPfcard() {
		return pfcard;
	}


	public void setPfcard(String sfcard) {
		pfcard.sendKeys(sfcard);
	}


	public WebElement getPfdebit() {
		return pfdebit;
	}


	public void setPfdebit(String sfdebit) {
		pfdebit.sendKeys(sfdebit);
	}


	public WebElement getPfcvv() {
		return pfcvv;
	}


	public void setPfcvv(String sfcvv) {
		pfcvv.sendKeys(sfcvv);
	}


	public WebElement getPfexpmon() {
		return pfexpmon;
	}


	public void setPfexpmon(String sfexpmon) {
		pfexpmon.sendKeys(sfexpmon);;
	}


	public WebElement getPfexpyr() {
		return pfexpyr;
	}


	public void setPfexpyr(String sfexpyr) {
		pfexpyr.sendKeys(sfexpyr);
	}
	
	
}
