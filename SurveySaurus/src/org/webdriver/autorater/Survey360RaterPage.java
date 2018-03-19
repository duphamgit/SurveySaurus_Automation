/**
 * 
 */
package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class Survey360RaterPage extends TestAutorater {

	/**
	 * @param driver
	 */
	public Survey360RaterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Cancel btn
	public void clickCancelbtn() {
		click_by_id("cancel-form");
	}

	// Save&Complete Later btn
	public void clickSaveAndCompleteLaterbtn() throws InterruptedException {
		waitExpectedConditions_id("stash");
		click_by_id("stash");
		Thread.sleep(5000);
	}

	// Submit btn
	public void clickSubmitAnswerstbn() {
		click_by_id("submit");
		String locator = "/html/body/div[3]/md-dialog/section/div[2]/button[2]";
		waitExpectedConditions_xpath(locator);
		click_by_xpath(locator);
		waitExpectedConditions_url("https://staging-swf.surveysaurus.com/rate-complete");
	}

	// Checkbox
	public void clickCheckbox(String locator) {
		waitExpectedConditions_xpath(locator);
		scrollElementIntoView_xpath(locator);
		click_by_xpath(locator);
	}
}
