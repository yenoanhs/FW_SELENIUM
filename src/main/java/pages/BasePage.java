package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,120);
	}

	public void waitElement(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void clickOnElement(WebElement element)
	{
		waitElement(element);
		element.click();
	}

	public void inputTextInElement(WebElement element, String str)
	{
		waitElement(element);
		element.sendKeys(str);
	}

	public String getText(WebElement element)
	{
		waitElement(element);
		return element.getTagName();
	}
}
