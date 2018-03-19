/**
 * 
 */
package org.webdriver.autorater;

import java.util.Random;

import org.openqa.selenium.WebDriver;

/**
 * @author du
 *
 */
public class CultureSurveyRaterPage extends TestAutorater {

	/**
	 * @param driver
	 */
	public CultureSurveyRaterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	// clickListbox
	public void clickListbox(String locator) {
		waitExpectedConditions_id(locator);
		scrollElementIntoView_id(locator);
		click_by_id(locator);
	}

	// select Option
	public void selectOption(String locator) {
		waitExpectedConditions_id(locator);
		scrollElementIntoView_id(locator);
		click_by_id(locator);
	}

	// List box
	public void testListBox(int question) {
		if (question == 1) {
			clickListbox("select_1");
			testSelectOption(3, 10);
		}
		if (question == 2) {
			clickListbox("select_11");
			testSelectOption(13, 18);
		}
		if (question == 3) {
			clickListbox("select_21");
			testSelectOption(23, 33);
		}
		if (question == 4) {
			clickListbox("select_35");
			testSelectOption(37, 45);
		}
		if (question == 5) {
			clickListbox("select_47");
			testSelectOption(49, 58);
		}
		if (question == 6) {
			clickListbox("select_59");
			testSelectOption(61, 71);
		}
	}

	// Select Option
	public void testSelectOption(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		String options = "select_option_" + randomNum;
		selectOption(options);
	}

	// Select Answers Choice
	public void selectAnswerChoice(String locator) {
		waitExpectedConditions_xpath(locator);
		scrollElementIntoView_xpath(locator);
		click_by_xpath(locator);
	}

	// Select Answers Choice
	public void testSelectAnswerChoice(int part, int Question) {
		// random question
		int question = 0;
		if (Question == 7 || Question == 12 || Question == 19 || Question == 27 || Question == 33 || Question == 40
				|| Question == 44 || Question == 50 || Question == 54 || Question == 58 || Question == 63
				|| Question == 70 || Question == 75 || Question == 80) {
			question = 1;
		}
		if (Question == 8 || Question == 13 || Question == 20 || Question == 28 || Question == 34 || Question == 41
				|| Question == 45 || Question == 51 || Question == 55 || Question == 59 || Question == 64
				|| Question == 71 || Question == 76 || Question == 81) {
			question = 2;
		}
		if (Question == 9 || Question == 14 || Question == 21 || Question == 29 || Question == 35 || Question == 42
				|| Question == 46 || Question == 52 || Question == 56 || Question == 60 || Question == 65
				|| Question == 72 || Question == 77 || Question == 82) {
			question = 3;
		}
		if (Question == 10 || Question == 15 || Question == 22 || Question == 30 || Question == 36 || Question == 43
				|| Question == 47 || Question == 53 || Question == 57 || Question == 61 || Question == 66
				|| Question == 73 || Question == 78 || Question == 83) {
			question = 4;
		}
		if (Question == 11 || Question == 16 || Question == 23 || Question == 31 || Question == 37 || Question == 48
				|| Question == 62 || Question == 67 || Question == 74 || Question == 79 || Question == 84) {
			question = 5;
		}
		if (Question == 17 || Question == 24 || Question == 32 || Question == 38 || Question == 49 || Question == 68) {
			question = 6;
		}
		if (Question == 18 || Question == 25 || Question == 39 || Question == 69) {
			question = 7;
		}
		if (Question == 26) {
			question = 8;
		}
		// random number
		Random rand = new Random();
		int min = 2;
		int max = 9;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		String options = "/html/body/section/div/div/div[2]/div/div[" + part + "]/div/table/tbody/tr[" + question
				+ "]/td[" + randomNum + "]";
		selectAnswerChoice(options);
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
		String locator = "/html/body/div[9]/md-dialog/section/div[2]/button[2]";
		waitExpectedConditions_xpath(locator);
		click_by_xpath(locator);
		waitExpectedConditions_url("https://staging-swf.surveysaurus.com/rate-complete");
	}

}
