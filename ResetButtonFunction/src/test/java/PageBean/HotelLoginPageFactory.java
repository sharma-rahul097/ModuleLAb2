package PageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HotelLoginPageFactory {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "userName")
	@CacheLookup
	WebElement user;
	
	
	@FindBy(how = How.NAME, using = "userPwd")
	@CacheLookup
	WebElement pass;
	
	
	@FindBy(how = How.CLASS_NAME, using = "btn")
	@CacheLookup
	WebElement btn;

	@FindBy(id= "userErrMsg")
	@CacheLookup
	WebElement pferroruser;

	@FindBy(id= "pwdErrMsg")
	@CacheLookup
	WebElement pferrorpwd;
	


	public HotelLoginPageFactory(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getPferroruser() {
		return pferroruser;
	}
	
	
	public WebElement getPferrorpwd() {
		return pferrorpwd;
	}
	public WebElement getUser() {
		return user;
	}


	public void setUser(String users) {
		this.user.sendKeys(users);
	}


	public WebElement getPass() {
		return pass;
	}


	public void setPass(String passs) {
		this.pass.sendKeys(passs);
	}


	public WebElement getBtn() {
		return btn;
	}


	public void setBtn() {
		this.btn.click();
	}
}
