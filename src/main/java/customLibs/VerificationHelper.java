package customLibs;

import org.openqa.selenium.WebElement;

public class VerificationHelper {

	public static synchronized boolean verifyElementPresent(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return isDisplayed;
	}

	public static synchronized boolean verifyElementNotPresent(WebElement element) {
		boolean isDisplayed = false;
		try {
			element.isDisplayed();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			isDisplayed = true;
		}
		return isDisplayed;
	}

	public static synchronized boolean verifyTextEquals(WebElement element, String expectedText) {
		boolean flag = false;
		try {
			String actualText = element.getText();
			if (actualText.equals(expectedText))
				flag = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}
}
