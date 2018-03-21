/**
 * 
 */
package org.webdriver.autorater;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class ProjectListPage extends TestHome {

	/**
	 * @param driver
	 */
	public ProjectListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String xpath_NewProjectbtn = "/html/body/section/div/div/div/div[1]/a[1]";
	String xpath_AllProject = "/html/body/section/div/div/div/div[1]/a[2]";
	String xpath_OnGoing = "/html/body/section/div/div/div/div[1]/a[3]";
	String xpath_Templates = "/html/body/section/div/div/div/div[1]/a[4]";
	String xpath_Archive = "/html/body/section/div/div/div/div[1]/a[5]";
	String xpath_PROJECTSbtn = "/html/body/header/div/div/div[2]/div[2]/ul/li[1]/a";
	String xpath_SETTINGSbtn = "/html/body/header/div/div/div[2]/div[2]/ul/li[2]/a";
	String xpath_CREDITbtn = "/html/body/header/div/div/div[2]/div[2]/ul/li[3]/a";

	// New Project btn
	public void clickNewProjectbtn() {
		click_by_xpath(xpath_NewProjectbtn);
	}

	// All Project link
	public void clickAllProject() {
		click_by_xpath(xpath_AllProject);
	}

	// On-going link
	public void clickOnGoing() {
		click_by_xpath(xpath_OnGoing);
	}

	// Templates link
	public void clickTemplates() {
		click_by_xpath(xpath_Templates);
	}

	// Archive link
	public void clickArchive() {
		click_by_xpath(xpath_Archive);
	}

	// PROJECTS btn
	public void clickPROJECTSbtn() {
		click_by_xpath(xpath_PROJECTSbtn);
	}

	// SETTING btn
	public void clickSETTINGSbtn() {
		click_by_xpath(xpath_SETTINGSbtn);
	}

	// CREDIT btn
	public void clickCREDITbtn() {
		click_by_xpath(xpath_CREDITbtn);
	}

	// EDIT btn
	public void clickEditbtn(int id) {
		String id_Editbtn = "//*[@id=\"btn-hide-projects-menu\"" + id + "\"]";
		click_by_id(id_Editbtn);
	}

	// check Assertion
	public void checkAssertion() {

		System.out.println("New Project btn");
		waitExpectedConditions_xpath(xpath_NewProjectbtn);
		checkPageContainElement(xpath_NewProjectbtn);

		System.out.println("All Project link");
		waitExpectedConditions_xpath(xpath_AllProject);
		checkPageContainElement(xpath_AllProject);

		System.out.println("On-going link");
		waitExpectedConditions_xpath(xpath_OnGoing);
		checkPageContainElement(xpath_OnGoing);

		System.out.println("Templates link");
		waitExpectedConditions_xpath(xpath_Templates);
		checkPageContainElement(xpath_Templates);

		System.out.println("Archive link");
		waitExpectedConditions_xpath(xpath_Archive);
		checkPageContainElement(xpath_Archive);

		System.out.println("PROJECTS btn");
		waitExpectedConditions_xpath(xpath_PROJECTSbtn);
		checkPageContainElement(xpath_PROJECTSbtn);

		System.out.println("SETTINGS btn");
		waitExpectedConditions_xpath(xpath_SETTINGSbtn);
		checkPageContainElement(xpath_SETTINGSbtn);

		System.out.println("CREDIT btn");
		waitExpectedConditions_xpath(xpath_CREDITbtn);
		checkPageContainElement(xpath_CREDITbtn);

		System.out.println("Edit btn");
		waitExpectedConditions_xpath("//*[@id=\"btn-hide-projects-menu0\"]");
		checkPageContainElement("//*[@id=\"btn-hide-projects-menu0\"]");
	}
}
