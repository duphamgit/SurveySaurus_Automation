/**
 * 
 */
package org.webdriver.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.webdriver.autorater.BasicSurveyRaterPage;
import org.webdriver.autorater.TestAutorater;

/**
 * @author du
 *
 */
public class TestBasicSurvey {

	WebDriver driver;
	TestAutorater testAutoraterBasicSurvey;
	BasicSurveyRaterPage raterPageBasicSurvey;

	@BeforeMethod
	public void setUp() throws IOException {
		/// Config Geckodriver
		String file_geckodriver_config = "src/GeckodriverConfig";
		String geckodriver = "webdriver.gecko.driver";
		String environment_geckodriver = Files.readAllLines(Paths.get(file_geckodriver_config)).get(3);
		// Edit in GeckodriverConfig at line 3:
		// Mac: src/geckodriver
		// Windows: src/geckodriver.exe
		System.setProperty(geckodriver, environment_geckodriver);
		driver = new FirefoxDriver();
		testAutoraterBasicSurvey = new TestAutorater(driver);
		raterPageBasicSurvey = new BasicSurveyRaterPage(driver);
	}

	@Test
	public void BasicSurveyTemplate_1() throws InterruptedException, IOException {
		String file = "/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/url";
		// numberOfTest number of test using get specific Url in File
		for (int numberOfTest = 0; numberOfTest <= 1000; numberOfTest++) {
			String url = testAutoraterBasicSurvey.getSpecificUrl(file, numberOfTest);
			testAutoraterBasicSurvey.navigatetoBasicRaterPage(url);

			// Question 1-6
			for (int question = 1; question <= 6; question++) {
				Random rand = new Random();
				int min = 1;
				int max = 5;
				int randomNum = rand.nextInt((max - min) + 1) + min;

				String locator = "/html/body/section/div/div/div[1]/div/div[" + question + "]/div[" + randomNum
						+ "]/label/span";
				raterPageBasicSurvey.clickCheckbox(locator);
			}
			// click Submit btn
			raterPageBasicSurvey.clickSubmitAnswerstbn();
		}
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
