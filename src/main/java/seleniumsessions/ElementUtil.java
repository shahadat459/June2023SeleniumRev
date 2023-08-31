package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doSendKeys(By locator, String value) {
		if (value == null) {
			System.out.println("null values are not allowed");
			throw new MySeleniumException("VALUECANNOTBENULL");
		}
		doClear(locator);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			System.out.println("Element is found with given locator..." + locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found with given locator..." + locator);
			try { // this try catch block is to handle only Thread.sleep( )
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			element = driver.findElement(locator);
		}
		return element;
	}

	public void doClear(By locator) {
		getElement(locator).clear();
	}
	//System.out.println("Test line for git");
	//method created
	public boolean checkElementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public String doGetAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void clickElementFromPageSection(By locator, String eleText) {
		List<WebElement> eleList = getElements(locator);

		for (WebElement e : eleList) {
			String text = e.getText();

			if (text.equalsIgnoreCase(eleText)) {
				System.out.println(text);
				e.click();
				break;
			}
		}
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<String> getElementsAttributeValue(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrList.add(attrValue);
		}
		return eleAttrList;
	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> elesTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			elesTextList.add(text);
		}
		return elesTextList;
	}

	//useful in Google search suggestion 
	public  void search(String searchKey, By searchLocator, String suggName, By suggestionsLocator)
			throws InterruptedException {
		doSendKeys(searchLocator,searchKey);
		Thread.sleep(3000);
		List<WebElement> suggList = getElements(suggestionsLocator); 
		System.out.println(suggList.size());
		if (suggList.size() > 0) {
			for (WebElement e : suggList) {
				String text = e.getText();
				if (text.length() > 0) {
					System.out.println(text);
					if (text.contains(suggName)) {
						e.click();
						break;
					}
				} else {
					System.out.println("Blank values -- no suggestions");
					break;
				}
			}
		} else {
			System.out.println("No search suggestion are found...");
		}
	}

}
