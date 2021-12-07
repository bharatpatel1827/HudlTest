package hudlTest.testHudl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends Utils {
	LoadProp loadprop = new LoadProp();

	private By _homePageTitle = By.xpath(".//*[@class='hui-globalnav__item hui-globalnav__home']/span");
	private By _suggestionListTips = By.id("featured-athletes-container");
	private By _yourteam = By.xpath(".//*[@class='explore-tab explore-tab__home']");
	private By _searchSport = By.xpath(".//*[@class='uni-form__input search-bar__input']");
	private By _searchresults = By.xpath(".//*[@class='search-results']/a[1]/div/div[2]/h4");
	
	String homepagetitle="Home";
	
	public void HomePageTitle () 
	{
		try {
		    WebElement element = driver.findElement(_homePageTitle);
		    Assert.assertEquals(homepagetitle, element.getText());
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement element = driver.findElement(_homePageTitle);
		    Assert.assertEquals(homepagetitle, element.getText());
		}
		
	}
	
	public void followSuggestionTips () 
	{
		selectByIndex(_suggestionListTips, 1);
	}
	
	public void clickOnYourTeam () 
	{
		waitForElementToBeVisible(_yourteam, 5);
		List<WebElement> element = driver.findElements(_yourteam);
		element.get(2).click();
	}
	public void searchTextBar ()
	{
		clearAndEnterText(_searchSport, loadprop.getproperty("sports"));
	}
	public void verifySearchResults ()
	{
		waitForElementToBeVisible(_searchresults, 10);
		//List<WebElement> element = driver.findElements(_searchresults);
		String expectedValue = getTextFromElement(_searchresults);
		Assert.assertEquals(expectedValue, getTextFromElement(_searchresults));
	}
	
}
