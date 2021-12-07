package hudlTest.testHudl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
		LoginPage loginpage = new LoginPage();
		HomePage homepage = new HomePage();
		YourTeam yourteam = new YourTeam();
		
		
		

	@Given("User is on Login Page")
	public void user_is_on_Login_Page() {
	    loginpage.verifyLoginPage();
	}
	@When("User entered valid credentials")
	public void user_entered_valid_credentials() {
		loginpage.Username();
		loginpage.Password();
		loginpage.LoginButton();
	   
	}
	@Then("User should be login successfully")
	public void user_should_be_login_successfully() {
	   homepage.HomePageTitle();
	}
	
	/////////////////Invalid login scenario//////////////////////////////
	
	@When("User entered invalid credentials {string} and {string}")
	public void user_entered_invalid_credentials_and(String Username, String Password) {
	   loginpage.InvalidUsername(Username);
	   loginpage.InvalidPassword(Password);
	   loginpage.LoginButton();
	}
	
	@Then("User should be unsuccessfully login")
	public void user_should_be_unsuccessfully_login() {
	    loginpage.verifyLoginFailedMessage();
	}
	
	///////////////////////Your Team video scenario ///////////////////////////
	
	@When("User click on {string}")
	public void user_click_on(String yourteam) {
	   homepage.clickOnYourTeam();
	}
	@Then("User view the list of videos")
	public void user_view_the_list_of_videos() {
	    yourteam.yourTeamVideo();
	}
	
	//////////////////search bar verification scenario///////////////////
	
	@When("User search football from search text bar")
	public void user_search_football_from_search_text_bar() {
	    homepage.searchTextBar();
	}
	@Then("User should be navigate to search list page")
	public void user_should_be_navigate_to_search_list_page() {
	    homepage.verifySearchResults();
	}
}
