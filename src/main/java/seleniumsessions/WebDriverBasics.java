package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class WebDriverBasics {

	public static void main(String[] args) {

		// FirefoxDriver driver = new FirefoxDriver();
		// EdgeDriver driver = new EdgeDriver();

		ChromeDriver driver = new ChromeDriver();
		// SessionId s = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("SESSION - ID-->>" + ((RemoteWebDriver) driver).getSessionId());
		driver.get("https://www.amazon.com");

		String title = driver.getTitle();
		System.out.println(title);
		// ChromeOptions co = new ChromeOptions();
		// String cPath = SeleniumManager.getInstance().getDriverPath(co);
		// System.out.println(cPath);
		//driver.close();
//		driver = new ChromeDriver();
		// System.out.println("SESSION - ID afte close-->>"+((RemoteWebDriver)
		// driver).getSessionId());

		driver.quit();
		driver = new ChromeDriver();
	System.out.println("SESSION - ID afte quit-->>"+((RemoteWebDriver) driver).getSessionId());
		
		// driver = new ChromeDriver();
		// String title1 = driver.getTitle();
		// System.out.println(title);
	}

}
