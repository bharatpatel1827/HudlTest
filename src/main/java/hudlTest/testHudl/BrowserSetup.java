package hudlTest.testHudl;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup extends BasePage {

	LoadProp loadprop = new LoadProp();
	String browser = loadprop.getproperty("Browser");
	
	
public void selectBrowser(){
        
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","src/test/java/browserDirectory/chromedriver");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/java/browserDirectory/MicrosoftWebDriver");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/java/browserDirectory/geckodriver");
            driver = new FirefoxDriver();
        }else{System.out.print("Wrong Browser");
        }
    }
}
