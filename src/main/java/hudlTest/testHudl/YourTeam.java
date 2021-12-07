package hudlTest.testHudl;

import org.openqa.selenium.By;

public class YourTeam extends Utils{
	
	private By _playfirstvideo = By.xpath("//div[@class='content js-explore-tabs-content']/div/div/div/div/div[2]/div/div/div/div/div/div/div");


	public void yourTeamVideo ()
	{
		waitForElementToBeVisible(_playfirstvideo, 10);
		clickOnElement(_playfirstvideo);
	}
}
