package PageBean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageFactoryForm {

	WebDriver driver;
	
	@FindBy(id ="txtUserName")
	@CacheLookup
	WebElement pfuser;
	
	
	@FindBy(id ="txtPassword")
	@CacheLookup
	WebElement pfpass;
	
	
	@FindBy(how = How.CLASS_NAME,using ="Format")
	@CacheLookup
	WebElement pfConfirmPass;
	
	
	@FindBy(how = How.XPATH,using = ".//*[@id='txtFirstName']")
	@CacheLookup
	WebElement pfFName;
	
	
	@FindBy(id ="txtLastName")
	@CacheLookup
	WebElement pfLname;
	
	
	@FindBy(name="gender")
	@CacheLookup
	WebElement pfgender;
	
	
	@FindBy(name = "DtOB")
	@CacheLookup
	WebElement pfDob;
	
	
	@FindBy(name = "Email")
	@CacheLookup
	WebElement pfEmail;
	
	
	@FindBy(name = "Address")
	@CacheLookup
	WebElement pfaddr;
	
	
	@FindBy(name ="City")
	@CacheLookup
	WebElement pfcity;
	
	
	@FindBy(how = How.XPATH,using=".//*[@id='txtPhone']")
	@CacheLookup
	WebElement pfphone;
	
	
	@FindBy(name = "chkHobbies")
	@CacheLookup
	WebElement pfhobby;
	
	
	@FindBy(name ="submit")
	@CacheLookup
	WebElement pfsubmit;
	
	
	@FindBy(name ="reset")
	@CacheLookup
	WebElement pfreset;


	public PageFactoryForm(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getPfuser() {
		return pfuser;
	}


	public void setPfuser(String sfuser) {
		this.pfuser.sendKeys(sfuser);
	}


	public WebElement getPfpass() {
		return pfpass;
	}


	public void setPfpass(String sfpass) {
		this.pfpass.sendKeys(sfpass);
	}


	public WebElement getPfConfirmPass() {
		return pfConfirmPass;
	}


	public void setPfConfirmPass(String sfConfirmPass) {
		this.pfConfirmPass.sendKeys(sfConfirmPass);
	}


	public WebElement getPfFName() {
		return pfFName;
	}


	public void setPfFName(String sfFName) {
		this.pfFName.sendKeys(sfFName);
	}


	public WebElement getPfLname() {
		return pfLname;
	}


	public void setPfLname(String sfLname) {
		this.pfLname.sendKeys(sfLname);
	}


	public WebElement getPfgender() {
		return pfgender;
	}


	public void setPfgender(String sfgender) {
		this.pfgender=driver.findElement(By.cssSelector(sfgender));
		pfgender.click();
	}


	public WebElement getPfDob() {
		return pfDob;
	}


	public void setPfDob(String sfDob) {
		this.pfDob.sendKeys(sfDob);
	}


	public WebElement getPfEmail() {
		return pfEmail;
	}


	public void setPfEmail(String sfEmail) {
		this.pfEmail.sendKeys(sfEmail);
	}


	public WebElement getPfaddr() {
		return pfaddr;
	}


	public void setPfaddr(String sfaddr) {
		this.pfaddr.sendKeys(sfaddr);
	}


	public WebElement getPfcity() {
		return pfcity;
	}


	public void setPfcity(String sfcity) {
		Select drpCity = new Select(pfcity);
		drpCity.selectByVisibleText(sfcity);
	}


	public WebElement getPfphone() {
		return pfphone;
	}


	public void setPfphone(String sfphone) {
		this.pfphone.sendKeys(sfphone);
	}


	public WebElement getPfhobby() {
		return pfhobby;
	}


	public void setPfhobby(String sfhobby) {
		this.pfhobby=driver.findElement(By.cssSelector(sfhobby));
		pfhobby.click();
	}


	public WebElement getPfsubmit() {
		return pfsubmit;
	}


	public void setPfsubmit() {
		this.pfsubmit.click();
	}


	public WebElement getPfreset() {
		return pfreset;
	}


	public void setPfreset() {
		this.pfreset.click();
	}
	
}
