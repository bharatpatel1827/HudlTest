package hudlTest.testHudl;

//import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.openqa.selenium.By;

public class LoginPage extends Utils{

	LoadProp loadprop = new LoadProp();
	
	private By _username = By.id("email");
	private By _password = By.id("password");
	private By _loginBtn = By.id("logIn");
	private By _loginWithOrganisation = By.id("logInWithOrganization");
	private By _loginFailedMessage = By.xpath(".//*[@class='login-error-container']/p");
	
	
	String loginwithorganisation = "Log In with an Organization";
	String loginfailedmessage = "We didn't recognize that email and/or password. Need help?";
	
	public void Username()
	{
		clearAndEnterText(_username, loadprop.getproperty("Username"));
	}
	
	public void InvalidUsername(String Username)
	{
		clearAndEnterText(_username, Username);
	}
	
	public void Password()
	{
		clearAndEnterText(_password, loadprop.getproperty("Password"));
	}
	
	public void InvalidPassword (String Password)
	{
		clearAndEnterText(_password, Password);
	}
	
	public void LoginButton ()
	{
		clickOnElement(_loginBtn);
	}
	
	public void verifyLoginPage ()
	{
		Assert.assertEquals(loginwithorganisation, waitAndGetText(_loginWithOrganisation, 10));
	}
	
	public void verifyLoginFailedMessage ()
	{
		Assert.assertEquals(loginfailedmessage, waitAndGetText(_loginFailedMessage, 10));
	}
}
