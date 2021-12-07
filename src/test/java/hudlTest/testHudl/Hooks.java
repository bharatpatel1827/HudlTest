package hudlTest.testHudl;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BasePage {
	
	LoadProp loadprop = new LoadProp();
	BrowserSetup browsersetup = new BrowserSetup();

	@Before
	public void initializeTest(){
        // Code to setup initial configurations
	 browsersetup.selectBrowser();
        driver.get(loadprop.getproperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
	
	@After
	public void screenshot(Scenario  scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            	final File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          	  	FileUtils.copyFile(screenshot, new File("src\\test\\Resrouceses\\ScreenShots\\" + System.currentTimeMillis()+"\\testfailed.png"));
          	  
          	   }catch (WebDriverException somePlatformsDontSupportScreenshots){
          	   	System.err.println(somePlatformsDontSupportScreenshots.getMessage());
          	   
          	   }
            //driver.close();
            driver.quit();
        }
        driver.close();
    }
}
