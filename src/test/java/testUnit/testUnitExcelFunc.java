package testUnit;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import customLibs.DropdownUtils;
import customLibs.ExcelUtils;
import customLibs.VerificationHelper;
import testbase.TestBase;

public class testUnitExcelFunc extends TestBase{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test unit");
		//testDropDown();
		testVerificationHelper();
	}

	@Test(enabled = false)
	public void testGetDataInExcel(){
		String filepath="E:/oanh/FW_SELENIUM/src/test/testData.xlsx";
		String sheetname="Sheet1";
		ExcelUtils oExcel = new ExcelUtils(filepath, sheetname);
		int numberRow =oExcel.getRowCount();
		System.out.println("Num of row =" + numberRow);
		for (int i=2; i<=numberRow; i++)
		{
			//can use func getColFromName(String) to find what colNumber of col username, password
			// col start with 0, row start with 1 (header)
			String user = oExcel.getCellData(i, 0);
			String pass = oExcel.getCellData(i, 1);
			System.out.println("user = "+user+", pass = "+pass);
		}

	}

	@Test(enabled = false)
	public void testStartFail(){
		String str="test";
		assert "message".equals(str);
	}

	@Test(dependsOnMethods ={"testStart"})
	public void testSkipOnStartFail(){
		String str="test";
		assert "message".equals(str);
	}

	// on 3/6/2018
	@Test(enabled = true)
	public static void testDropDown() throws InterruptedException {
		TestBase testbase = new TestBase();
		testbase.initBrowser("chrome");
		WebDriver driver=testbase.driver;
		WebDriverWait wait=new WebDriverWait(testbase.driver,120);
		driver.get("http://the-internet.herokuapp.com/dropdown");
		//testbase.driver.get("https://demos.telerik.com/kendo-ui/combobox/index");
		System.out.println("debug here1");
		WebElement elementdropdown1 = driver.findElement(By.xpath("//select[@id='dropdown']"));
		wait.until(ExpectedConditions.visibilityOf(elementdropdown1));
		System.out.println("debug here2");
		DropdownUtils dropdown = new DropdownUtils();
		System.out.println("debug here3");
		dropdown.selectByIndex(elementdropdown1, 1);
		Thread.sleep(3000);
		System.out.println("debug here4");
		String str = dropdown.getFirstSelectedOption(elementdropdown1);
		System.out.println("get selected text= "+str);
		System.out.println("debug here5");
		boolean isMulti = dropdown.isMultiple(elementdropdown1);
		if (isMulti== true) {
			System.out.println("This is a multi selected listbox");

			dropdown.deselectByVisibleText(elementdropdown1, dropdown.getFirstSelectedOption(elementdropdown1));
			System.out.println();
			Thread.sleep(3000);
		}
		else System.out.println("This is a single selected listbox");

		int count = dropdown.getNumberItem(elementdropdown1);
		ArrayList<String> arr = (ArrayList<String>) dropdown.getAllOptions(elementdropdown1);
		String lastoption =  arr.get(count-1);
		dropdown.selectByVisibleText(elementdropdown1, arr.get(count-1));
		System.out.println("Combobox has "+count+" options, and last option is "+lastoption);
		Thread.sleep(3000);

		driver.quit();
	}

	// on 3/6/2018
	@Test(enabled=true)
	public static void testVerificationHelper()
	{
		TestBase testbase = new TestBase();
		testbase.initBrowser("chrome");
		WebDriver driver=testbase.driver;
		WebDriverWait wait=new WebDriverWait(testbase.driver,120);
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		//System.out.println("debug here1");
		WebElement element = driver.findElement(By.xpath("//*[@id='divontheleft']"));
		wait.until(ExpectedConditions.visibilityOf(element));

		boolean bool;
		bool = VerificationHelper.verifyElementPresent(element);
		System.out.println("verifyElementPresent = "+bool);

		bool = VerificationHelper.verifyElementNotPresent(element);
		System.out.println("verifyElementNotPresent = "+bool);

		bool = VerificationHelper.verifyTextEquals(element, "message");
		System.out.println("verifyTextEquals = "+bool);

		driver.quit();
	}
}
