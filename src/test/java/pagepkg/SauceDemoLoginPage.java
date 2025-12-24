package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {
	WebDriver driver;
	@FindBy(name="user-name")
	WebElement user;
	@FindBy(name="password")
	WebElement pwd;
	@FindBy(xpath="//input[@name='login-button']")
	WebElement loginbutton;
	public SauceDemoLoginPage(WebDriver driver )
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void setValues(String username,String password) {
		user.sendKeys(username);
		pwd.sendKeys(password);
	}
	public void loginClick() {
		loginbutton.click();
	}

}



