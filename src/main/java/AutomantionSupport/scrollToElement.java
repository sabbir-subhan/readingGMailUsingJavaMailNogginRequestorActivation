package AutomantionSupport;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scrollToElement {
	
	public void ScrollElementIntoView(WebDriver driver,WebElement ElementToBeScrolled) {

		// Create instance of Javascript executor and down cast web driver to a Java script executor instance
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// now execute query which actually will scroll until that element is not visible on page.
		je.executeScript("arguments[0].scrollIntoView(true);",ElementToBeScrolled);
		////System.out.println("Java script scrolling !!!");
		}

}
