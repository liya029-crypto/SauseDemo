package testpkg;

import org.testng.annotations.Test;

import basepkg.BaseClass;

public class CheckoutTest extends BaseClass{
	@Test(priority=1)
	public void checkText() {
		test=extent.createTest("checkText");
		cp.textverifychk();
	}
	@Test(priority=2)
	public void fillValues() {
		test=extent.createTest("fillvalues");
		cp.setValues("yuy", "nujhjhjll", "86765ll");
	}
	@Test(priority=3)
	public void continueBtnClk() {
		test=extent.createTest("continue");
		cp.continueClk();
	}
	@Test(priority=4)
	public void finishBtnClk() {
		test=extent.createTest("finish");
		cp.finishClk();
	}
	@Test(priority=5)
	public void backBtnClk() {
		test=extent.createTest("back");
		cp.backClk();
	}
	@Test(priority=6)
	public void hmbgrBtnClk() {
		test=extent.createTest("hmbgr");
		cp.hmbgrClk();
	}
	@Test(priority=7)
	public void logoutBtnClk() {
		test=extent.createTest("logout");
		cp.logoutClk();
	}


}
