package org.webdriver.action;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {

	WebDriver driver = null;

	public WebDriverAction(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// click by ID
	public void click_by_id(String locator) {
		// click function on a element by ID
		driver.findElement(By.id(locator)).click();
	}

	// click by XPATH
	public void click_by_xpath(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	// click by class
	public void click_by_class(String locator) {
		driver.findElement(By.className(locator)).click();
	}

	// click by CSS Selector
	public void click_by_CSS(String locator) {
		driver.findElement(By.cssSelector(locator));
	}

	// send Key By Id
	public void sendKey_id(String locator, String value) {
		// enter a string to textfields
		driver.findElement(By.id(locator)).sendKeys(value);
	}

	// send Key By xpath
	public void sendKey_xpath(String locator, String value) {
		// enter a string to textfields
		driver.findElement(By.xpath(locator)).sendKeys(value);
	}

	// Send Key By Name
	public void sendKey_name(String locator, String value) {
		driver.findElement(By.name(locator)).sendKeys(value);
	}

	// getText
	public String getText(String locator) {
		String myText = driver.findElement(By.id(locator)).getText();
		return myText;
	}

	// close browser
	public void close() {
		driver.close();
	}

	// open browser
	public void open(String url) {
		driver.get(url);
	}

	// Wait ExpectedConditions Command By Id
	public void waitExpectedConditions_id(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5500);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
	}

	// Wait ExpectedCoditions By id textToBePresentInElementLocated
	public void waitExpectedConditions_textToBePresentInElementLocated_id(String locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 5500);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(locator), text));
	}

	// Wait ExpectedCoditions By xpath textToBePresentInElementLocated
	public void waitExpectedConditions_textToBePresentInElementLocated_xpath(String locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 5500);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locator), text));
	}

	// Scroll element into view By Id
	public void scrollElementIntoView_id(String locator) {
		// WebElement element = driver.findElement(By.id(locator));
		// Actions actions = new Actions(driver);
		// actions.moveToElement(element);
		// actions.perform();
		WebElement element = driver.findElement(By.id(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Wait ExpectedConditions Command By xpath
	public void waitExpectedConditions_xpath(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	// Wait ExpectedConditions until Url contain
	public void waitExpectedConditions_url(String url) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.urlMatches(url));
	}

	// Scroll element into view By xpath
	public void scrollElementIntoView_xpath(String locator) {
		// WebElement element = driver.findElement(By.id(locator));
		// Actions actions = new Actions(driver);
		// actions.moveToElement(element);
		// actions.perform();
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Move mouse hover to locator
	public void moveToElement(String locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id(locator));
		action.moveToElement(element, 0, 0).build().perform();
	}

	// Get element text
	public String getElementText(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		String text = element.getText();
		return text;
	}

	// Wait until an element appear
	public void waitExpectedConditions_element_xpath(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	// Send Tab Key
	public void sendTabKey(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(Keys.SEMICOLON);
	}

	// Thread.sleep
	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	// Check Page contain element
	public String checkPageContainElement(String locator) {
		String isTrue = "0";
		Boolean isPresent = driver.findElements(By.xpath(locator)).size() > 0;
		return isTrue;
	}
	// Assertion by xpath
	public void checkAssertion_xpath(String locator, String value) {
		try {
			assertEquals(driver.findElement(By.xpath(locator)).getText(), value);
			System.out.println("---PASS---");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("---FAIL---");
		}
	}
	// Assertion by Page contain url
	public void checkAssertion_url(String url) {
		try {
			assertEquals(driver.getCurrentUrl(), url);
			System.out.println("---PASS---");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("---FAIL---");
		}
	}
	
	// Read Url from a file
	public String getUrl(String file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		String url = in.readLine();
		in.close();
		return url;
	}

	// Read Specific Url from a file
	public String getSpecificUrl(String file, int numberOfLine) throws IOException {
		String url = Files.readAllLines(Paths.get(file)).get(numberOfLine);
		return url;
	}
}