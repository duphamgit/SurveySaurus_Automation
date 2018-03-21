package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;
import org.webdriver.action.WebDriverAction;

public class TestHome extends WebDriverAction {

	/**
	 * 
	 */
	protected WebDriver driver;

	public TestHome(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	// open url rater page
	public HomePage navigatetoHomePage(String url) {
		open(url);
		return new HomePage(driver);
	}

	public SignUpPage navigatetoSignUpPage(String url) {
		open(url);
		return new SignUpPage(driver);
	}

	public ProjectListPage navigatetoProjectListPage(String url) {
		open(url);
		return new ProjectListPage(driver);
	}
}
