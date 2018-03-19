/**
 * 
 */
package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class SignUpPage extends TestAutorater {

	/**
	 * @param driver
	 */
	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Sign In btn
	public void clickSignInbtn() {
		click_by_xpath("/html/body/header/div/div/div[2]/div/ul/li/a");
	}

	// Individual
	public void clickIndividualbtn() {
		click_by_xpath("/html/body/section/div/div/div/ul/li[1]/a");
	}
	// Organization
	public void clickOrganizationbtn() {
		click_by_xpath("/html/body/section/div/div/div/ul/li[2]/a");
	}
	// Firstname, lastname, email, password, confirn password, and so on...
	
}
