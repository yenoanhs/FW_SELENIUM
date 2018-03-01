package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import customLibs.ExcelUtils;

public class TestBase {
	public WebDriver driver;
	public File varfile;
	public FileInputStream inputSteam;

	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;

	public ExcelUtils excelReader;

	private static String userDir = System.getProperty("user.dir");

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(
				userDir + "/src/main/java/reports/test" + formater.format(calendar.getTime()) + ".html", false);
	}

	// initiate browser
	public void initBrowser(String browserName) {
		if (System.getProperty("os.name").contains("Window")) {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", userDir + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", userDir + "/drviers/chromedirver.exe");
			}
		}
		else if (System.getProperty("os.name").contains("Mac")){
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", userDir + "/drivers/geckodriver");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", userDir + "/drviers/chromedirver");
			}
		}
	}

	// take screen shot
	public String getScreenShot(String imageName) throws IOException{
		if (imageName.equals("")){
			imageName="_blank";
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = userDir +"/src/main/java/screenshot/"		;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName =imageLocation+"_"+format.format(calendar.getTime())+".png";
		File desFile = new File(actualImageName);
		FileUtils.copyFile(image, desFile);

		return actualImageName;
	}

	public void getresult(ITestResult result) throws IOException{
		if (result.getStatus()==ITestResult.SUCCESS){
			test.log(LogStatus.PASS, result.getName() + " test is passed");
		}else if (result.getStatus()==ITestResult.SKIP){
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is: "+result.getThrowable());
		}else if (result.getStatus()==ITestResult.FAILURE ){
			test.log(LogStatus.FAIL, result.getName()+" test is failed. Reason is " + result.getThrowable());
			String screen = getScreenShot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		}else if (result.getStatus()==ITestResult.STARTED){
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}

	}
}
