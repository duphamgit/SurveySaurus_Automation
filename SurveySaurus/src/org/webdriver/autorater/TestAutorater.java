package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;
import org.webdriver.action.WebDriverAction;

public class TestAutorater extends WebDriverAction {

	/**
	 * 
	 */
	protected WebDriver driver;

	public TestAutorater(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	// open url rater page
	public CultureSurveyRaterPage navigatetoCultureRaterPage(String url) {
		open(url);
		return new CultureSurveyRaterPage(driver);
	}
	public BasicSurveyRaterPage navigatetoBasicRaterPage(String url) {
		open(url);
		return new BasicSurveyRaterPage(driver);
	}
	public Survey360RaterPage navigateto360RaterPage(String url) {
		open(url);
		return new Survey360RaterPage(driver);
	}
}
