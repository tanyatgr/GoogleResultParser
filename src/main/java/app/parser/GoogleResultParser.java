package app.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleResultParser {

	private WebDriver driver = new FirefoxDriver();
	private String query;

	public void run(String stringQuery) {

		query = stringQuery.trim();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement queryField = driver.findElement(By.name("q"));
		queryField.sendKeys(query);
		queryField.submit();
		waitForResult();
		List<WebElement> links = driver.findElements(By
				.xpath("//*[@id='rso']//h3/a"));
		List<String> urls = new ArrayList<String>();
		for (WebElement elem : links) {
			urls.add(elem.getAttribute("href"));
		}
		printTitles(urls);
		driver.close();
	}
	
	private void printTitles(List<String> urls) {
		for (String url : urls) {
			driver.get(url);
			System.out.println(driver.getTitle());
		}
	}

	private void waitForResult() {
		for (int second = 0;; second++) {
			if (second >= 60) {
				System.out.println("timeout");
			}
			try {
				if (isElementPresent(By.id("resultStats"))){
					break;
				}
				Thread.sleep(1000);;
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElements(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
