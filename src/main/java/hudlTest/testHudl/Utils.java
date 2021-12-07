package hudlTest.testHudl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BasePage {

	LoadProp loadprop = new LoadProp();
	
	
	//to click on element
    public static void clickOnElement(By by) {
    	driver.findElement(by).click();
    	}
    
    //to click on Mulitple elements
    public static void clickOnElements(By by) {
    	Boolean isPresent = driver.findElements(by).size()>0;
    	if(isPresent == true) {
    		isPresent.toString();
    	}
    	}

    // to clear and enter text
    public static void clearAndEnterText(By by, String text) {
    	driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        }

    // to enter text
    public static void enterText(By by, String text) {
    	driver.findElement(by).sendKeys(text);
    	}

    // to get text from element
    public static String getTextFromElement(By by) {
    	return driver.findElement(by).getText();
    	}

    //mouseHover with hold items
    public static void mouseHover(By by) {
    	WebElement myelement = driver.findElement(by);
    	Actions action = new Actions(driver);  			
    	action.doubleClick();
    	//action.moveByOffset(0, 500);
    	action.moveToElement(myelement).click();
    	action.build().perform();
        }
    
    //wait for invisible element
    public static void waitForElementToBeInvisible(By by, int time) {
    	WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }
    
    //wait for visible element
    public static void waitForElementToBeVisible(By by, int time) {
    	WebDriverWait wait = new WebDriverWait(driver,  time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    
    //javascript executor with webelement verify
    @SuppressWarnings("unlikely-arg-type")
	protected void javascriptexecutorelement(By by, List<WebElement> element) {
		WebElement elements = driver.findElement(by);
		List <WebElement> ele = elements.findElements(by);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.equals(ele);
	}
    
    
    // scroll to element view
    public void scrolltoviewelement(By by) {
    	WebElement myelement = driver.findElement(by);
    	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    	jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
    }
    
    //javascript executor click
    public static void javascriptexecutor (By by) {
		WebElement elements = driver.findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", elements);
    	}
    
    // to selecct from droplist by visible text
    public static void selectByVisibleText(By by, String name) {
    	new Select(driver.findElement(by)).selectByVisibleText(name);
    	}

    // to select ffrom droplist by index
    public static void selectByIndex(By by, int numb) {
    	new Select(driver.findElement(by)).selectByIndex(numb);
    	}

    // to wait and click
    public static void waitAndClick(By by,int time) { 
    	WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
        }
    
    //wait to load element ang get Text
    public static String waitAndGetText(By by,int time) { 
    	WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();
        }

    //get text from given location
    public static String getText(By by) { 
    	driver.findElement(by).isDisplayed();
        return driver.findElement(by).getText();
        }    
}
