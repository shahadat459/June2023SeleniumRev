package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test {
	static ElementUtil eleUtil = null;
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtil = new BrowserUtil();

		driver = brUtil.initDriver("Chrome");
		eleUtil = new ElementUtil(driver);
		brUtil.launchUrl("https://google.com");
		By searchLocator = By.id("APjFqb");
		String searchKey = "rest";
		String suggName = "api";
		By suggestionsLocator = By.xpath("//div[@class='wM6W7d']/span");
		eleUtil.search(searchKey, searchLocator, suggName, suggestionsLocator);
		
		// driver.quit();
	}

	



}
