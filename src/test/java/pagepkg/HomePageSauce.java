package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSauce {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//*[contains(@class,'app_logo') ]")
	WebElement text;
	@FindBy(xpath="//*[contains(@class,'product_sort_container')]")
	WebElement drpdwn;
	@FindBy(xpath="//*[contains(@class,'btn btn_primary btn_small btn_inventory ')]")
	List<WebElement> addToCartButtons;
	@FindBy(xpath="//*[contains(@class,'shopping_cart_link') ]")
	WebElement maincartBtn;
	@FindBy(xpath="//*[contains(@class,'btn btn_action btn_medium checkout_button ') ]")
	WebElement checkoutBtn;
	
	public HomePageSauce(WebDriver driver )
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		PageFactory.initElements(driver,this);
	}
	public boolean textverify() {
		wait.until(ExpectedConditions.visibilityOf(text));
		return text.isDisplayed();
		
	}
	public void dropdown() {
		drpdwn.click();
	}
	public void selectdrpdwn(int index) {
        Select select = new Select(drpdwn);
        select.selectByIndex(index);
        
    }
	public void addcart() {
		for (WebElement btn : addToCartButtons) {
            wait.until(ExpectedConditions.elementToBeClickable(btn));
            btn.click();
        }
		
		
	}
	public String titleVerify() {
		
		return driver.getTitle();
			
	}
	public void mainCartClik() {
		maincartBtn.click();
	}
	public void checkoutClk() {
		checkoutBtn.click();
	}
	
	

}
