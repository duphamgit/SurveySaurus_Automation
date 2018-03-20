/**
 * 
 */
package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class HomePage extends TestHome {

	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// SignIn btn
	public void clickSignInbtn() {
		click_by_xpath("/html/body/section/section/div/form/div[3]/button");
	}

	// Email textfield
	public void inputEmail(String email) {
		sendKey_name("email", email);
	}

	// Password textfield
	public void inputPassword(String password) {
		sendKey_name("password", password);
	}

	// Sign Up btn
	public void clickSignUpbtn() {
		click_by_xpath("/html/body/section/section/div/div/p/a");
	}

	// Forgot Your Password btn
	public void clickForgotPasswordbtn() {
		click_by_xpath("/html/body/section/section/div/form/div[3]/a");
	}

	// Logout btn
	public void clickLogout() {
		click_by_id("btn-logout-header");
	}

}
