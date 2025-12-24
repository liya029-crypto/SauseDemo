package testpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.BaseClass;

public class HomeSauseTest extends BaseClass {
	@Test(priority=1)
	public void textverify() {
		test=extent.createTest("textverify");
		boolean actualtext=hps.textverify();
		Assert.assertTrue(actualtext, "not displayed");
	}
	@Test(priority=2)
	public void dropdownclk() {
		test=extent.createTest("dropdownclk");
		hps.dropdown();
		hps.selectdrpdwn(2);
	}
	@Test(priority=3)
	public void addcartBtn() {
		test=extent.createTest("addcartBtn");
		hps.addcart();
	}
	@Test(priority=4)
	public void titleVerify() {
		test=extent.createTest("titleVerify");
		hps.titleVerify();
	}
	@Test(priority=5)
	public void MainCartBtn() {
		test=extent.createTest("MainCartBtn");
		hps.mainCartClik();
	}
	@Test(priority=6)
	public void checkOutBtn() {
		test=extent.createTest("checkOutBtn");
		hps.checkoutClk();
	}
	

}
