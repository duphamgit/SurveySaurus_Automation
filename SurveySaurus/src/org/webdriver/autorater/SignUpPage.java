/**
 * 
 */
package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class SignUpPage extends TestHome {

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
	// individual
	public void inputFirstName_individual(String value) {
		sendKey_name("firstname", value);
	}

	public void inputLastName_individual(String value) {
		sendKey_name("lastname", value);
	}

	public void inputEmail_individual(String value) {
		sendKey_name("email", value);
	}

	public void inputPassword_individual(String value) {
		sendKey_name("password", value);
	}

	public void inputConfirmPassword_individual(String value) {
		sendKey_name("confirmPassword", value);
	}

	// Checkbox I agree to Survey Saurus Terms of Use and Policy
	public void clickCheckBoxArgree_individual() {
		click_by_xpath("/html/body/section/div/div/form/div[6]/label/span");
	}

	// organization
	public void inputFirstName_organization(String value) {
		sendKey_name("firstname", value);
	}

	public void inputLastName_organization(String value) {
		sendKey_name("lastname", value);
	}

	public void inputEmail_organization(String value) {
		sendKey_name("email", value);
	}

	public void inputPassword_organization(String value) {
		sendKey_name("password", value);
	}

	public void inputConfirmPassword_organization(String value) {
		sendKey_name("confirmPassword", value);
	}

	public void inputCompanyName_organization(String value) {
		sendKey_name("companyname", value);
	}

	public void inputPhoneNumber_organization(String value) {
		sendKey_name("phonenumber", value);
	}

	public void inputAddress_organization(String value) {
		sendKey_name("address", value);
	}

	public void inputCity_organization(String value) {
		sendKey_name("city", value);
	}

	public void inputZipCode_organization(String value) {
		sendKey_name("zipcode", value);
	}

	public void inputState_organization(String value) {
		sendKey_name("state", value);
	}

	// Checkbox I agree to Survey Saurus Terms of Use and Policy
	public void clickCheckBoxArgree_organization() {
		click_by_xpath("/html/body/section/div/div/form/div[6]/label/span");
	}

	// Click Create Account btn
	public void clickCreateAccountbtn_individual() {
		click_by_xpath("/html/body/section/div/div/form/div[7]/button");
	}

	public void clickCreateAccountbtn_organization() {
		click_by_xpath("/html/body/section/div/div/form/div[8]/button");
	}

}
