package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartPageTest {

	public static void main(String[] args) {
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		By firstName = By .name("firstname");
		By lastName = By .name("lastname");
		By email = By.name("email");
		By telephone = By.name("telephone");
		By pwd = By.id("input-password");
		By cnfPwd = By.id("input-confirm");
		By newsLetter = By.xpath("//input[@name='newsletter' and @value='1']");
		By privacyPolicy = By.name("agree");
		By submit = By.xpath("//input[@value='Continue']");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "shahadat");
		eleUtil.doSendKeys(lastName, "khan");
		eleUtil.doSendKeys(email, "abc@gmail.com");
		eleUtil.doSendKeys(telephone, "86532154");
		eleUtil.doSendKeys(pwd, "aabc134");
		eleUtil.doSendKeys(cnfPwd, "aabc134");
		eleUtil.doClick(newsLetter);
		eleUtil.doClick(privacyPolicy);
		eleUtil.doClick(submit);
		
		//brUtil.quitBrowser();

	}

}
