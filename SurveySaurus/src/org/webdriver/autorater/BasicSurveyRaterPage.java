/**
 * 
 */
package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class BasicSurveyRaterPage extends TestAutorater {

	/**
	 * @param driver
	 */
	public BasicSurveyRaterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Cancel btn
	public void clickCancelbtn() {
		click_by_id("cancel-form");
	}

	// Submit btn
	public void clickSubmitAnswerstbn() {
		click_by_id("submit");
		String locator = "/html/body/div[3]/md-dialog/section/div[2]/button[2]";
		waitExpectedConditions_xpath(locator);
		scrollElementIntoView_xpath(locator);
		click_by_xpath(locator);
		waitExpectedConditions_url("https://dev-swf.surveysaurus.com/rate-complete");
	}

	// Textbox
	public void typeTextField(String locator, String value) {
		click_by_xpath(locator);
		sendTabKey(locator);
		waitExpectedConditions_xpath(locator);
		scrollElementIntoView_xpath(locator);
		sendKey_xpath(locator, value);
	}

	// Checkbox
	public void clickCheckbox(String locator) {
		waitExpectedConditions_xpath(locator);
		scrollElementIntoView_xpath(locator);
		click_by_xpath(locator);
	}
}
