package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	WebDriver driver;

	public WebDriver initDriver(String browserName) {

		System.out.println("Launching the browser: " + browserName);
		
		//browser null check
				if (browserName == null) {
					System.out.println("Browser can not be null");
					throw new MySeleniumException("BROWSERNULLEXCEPTION");
				}
				
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please pass the right browser name..." + browserName);
			throw new MySeleniumException("WRONGBROWSEREXCEPTION");
		}
		driver.manage().window().maximize();
		return driver;
	}

	public void launchUrl(String url) {
		//URL null check
		if (url == null) {
			System.out.println("URL can not be null");
			throw new MySeleniumException("URLBLANKEXCEPTION");
		}
		if(url.contains("http")) {
			driver.get(url);
		}
		else {
			System.out.println("http(s) is missing");
	}

	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public void quitBrowser() {
		driver.quit();
	}

}
