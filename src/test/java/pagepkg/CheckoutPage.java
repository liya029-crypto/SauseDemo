package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//*[contains(@class,'header_secondary_container') ]")
	WebElement textcheck;
	@FindBy(xpath="(//*[contains(@class,'input_error form_input') ])[1]")
	WebElement fstNm;
	@FindBy(xpath="(//*[contains(@class,'input_error form_input') ])[2]")
	WebElement lstNm;
	@FindBy(xpath="(//*[contains(@class,'input_error form_input') ])[3]")
	WebElement pstlCd;
	@FindBy(xpath="//*[contains(@class,'submit-button btn btn_primary cart_button btn_action') ]")
	WebElement continueBtn;
	@FindBy(xpath="//*[contains(@class,'btn btn_action btn_medium cart_button') ]")
	WebElement finishBtn;
	@FindBy(xpath="//*[contains(@class,'btn btn_primary btn_small') ]")
	WebElement backBtn;
	@FindBy(xpath="//*[contains(@id,'react-burger-menu-btn') ]")
	WebElement hmbgrBtn;
	
	@FindBy(xpath="(//*[contains(@class,'bm-item menu-item') ])[3]")
	WebElement logoutBtn;

	public CheckoutPage(WebDriver driver )
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	PageFactory.initElements(driver,this);
	}
	public boolean textverifychk() {
		wait.until(ExpectedConditions.visibilityOf(textcheck));
		return textcheck.isDisplayed();
		
	}
	public void setValues(String text1,String text2,String text3) {
		fstNm.sendKeys(text1);
		lstNm.sendKeys(text2);
		pstlCd.sendKeys(text3);
	}
	public void continueClk() {
		continueBtn.click();
	}
	public void finishClk() {
		wait.until(ExpectedConditions.visibilityOf(finishBtn));
		finishBtn.click();
	}
	public void backClk() {
		wait.until(ExpectedConditions.visibilityOf(backBtn));
		backBtn.click();
	}
	public void hmbgrClk() {
		wait.until(ExpectedConditions.visibilityOf(hmbgrBtn));
		hmbgrBtn.click();
	}
	public void logoutClk() {
	
		logoutBtn.click();
	}
	
	
}
