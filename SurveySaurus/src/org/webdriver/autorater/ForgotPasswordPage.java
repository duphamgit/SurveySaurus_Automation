/**
 * 
 */
package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class ForgotPasswordPage extends TestHome {

	/**
	 * @param driver
	 */
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Sign In btn
	public void clickSignInbtn() {
		click_by_xpath("/html/body/header/div/div/div[2]/div/ul/li/a");
	}

	// Submit btn
	public void clickSubmitbtn() {
		click_by_xpath("/html/body/section/section/div/form/div[3]/button");
	}

	// Email Textfield
	public void inputEmail(String value) {
		sendKey_name("email", value);
	}
}
