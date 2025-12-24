package testpkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.BaseClass;

public class SauseDemoLoginTest extends BaseClass{
	@Test
	public void test() throws InterruptedException {
		test=extent.createTest("test");
		
		login.setValues("standard_user","secret_sauce");
		
		login.loginClick();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
		String expectedurl="https://www.sauce.com/inventory.html";
		String actualurl=driver.getCurrentUrl();
		/*if(actualurl.equals(expectedurl)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}*/
		Assert.assertEquals(actualurl, expectedurl, "URL does not match!");
		
	}
	
}
