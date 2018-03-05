package customLibs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

	WebDriver driver;

	public DropdownUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void selectByValue(WebElement element, String str) {
		Select select = new Select(element);
		select.selectByValue(str);

	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String str) {
		Select select = new Select(element);
		select.selectByVisibleText(str);

	}

	public void deselectByValue(WebElement element, String str) {
		Select select = new Select(element);
		select.deselectByValue(str);
	}

	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deselectByVisibleText(WebElement element, String str) {
		Select select = new Select(element);
		select.deselectByVisibleText(str);
	}

	public String getFirstSelectedOption(WebElement element)
	{ // get current selected option
		String str;
		Select select = new Select(element);
		str = select.getFirstSelectedOption().getText();
		return str;
	}

	public Object getAllSelectedOptions(WebElement element){
		Select select = new Select(element);
		List<WebElement> elementlist= select.getAllSelectedOptions();
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement webElement:elementlist){
			list.add(webElement.getText());
		}
		return list;
	}

	public int getNumberItem(WebElement element)
	{
		int numberItem;
		Select select = new Select(element);
		numberItem=select.getOptions().size();
		return numberItem;
	}

	public Object getAllOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementlist = select.getOptions();
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement webElement:elementlist)
		{
			list.add(webElement.getText());
		}
		return list;
	}

	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
}
