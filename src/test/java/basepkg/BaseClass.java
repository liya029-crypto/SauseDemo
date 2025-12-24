package basepkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pagepkg.HomePageSauce;
import pagepkg.SauceDemoLoginPage;
import pagepkg.CheckoutPage;



public class BaseClass {
	public static WebDriver driver;
	public static SauceDemoLoginPage login;
	public static HomePageSauce hps;
	public static CheckoutPage cp;
	public static ExtentSparkReporter reporter;
	  public static ExtentReports extent;
	  public ExtentTest test;
@BeforeTest
public static void setup() {
	reporter = new ExtentSparkReporter( "./reports/myreport1.html");//specify the location of report

    reporter.config().setDocumentTitle(" Automation Test Report");
    reporter.config().setReportName("Functional Testing Report");
    reporter.config().setTheme(Theme.DARK);
    extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("hostname", "localhost");
    extent.setSystemInfo("os", "windows10");
    extent.setSystemInfo("testername", "abc");
    
    extent.setSystemInfo("Browser", "chrome");
	
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.saucedemo.com/");

	
driver.manage().window().maximize();
}
	
@BeforeMethod
public void beforemtd() {
	login=new SauceDemoLoginPage(driver);
	hps=new HomePageSauce(driver);
	cp=new CheckoutPage(driver);
}
@AfterMethod
public void browserclose(ITestResult result) throws Exception {
	if(result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL, "test case failed"+result.getName());
		test.log(Status.FAIL, "test case failed"+result.getThrowable());
		String screenshotpath=screenshotMethod(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
	
	}
	else if(result.getStatus()==ITestResult.SKIP) {
		
		test.log(Status.SKIP, "test case failed"+result.getName());	
	}
else if(result.getStatus()==ITestResult.SUCCESS) {
		
		test.log(Status.PASS, "test case failed"+result.getName());	
	}
}
	public static String screenshotMethod(WebDriver driver, String screenshotName) throws Exception
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="./screenshot/"+screenshotName+".jpeg";
		FileHandler.copy(src, new File(destination));
		return destination;
	}

@AfterTest
public void closeTest() {
	extent.flush();
}

}



