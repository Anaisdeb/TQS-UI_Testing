package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	
	@Given("the user is on the application landing page")
	public void theUserIsOnTheApplicationLandingPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://phptravels.net");
	}
	
	@When("the user clicks the account option")
	public void theUserClicksTheAccountOption()
	{
		driver.findElement(By.id("ACCOUNT")).click();
	}
	
	@When("^the user clicks the (.*) login")
	public void theUserClicksTheLogin(String profile)
	{
		driver.findElement(By.linkText(profile + " Login")).click();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	
	@When("^the user enters valid (.*) and valid (.*)")
	public void theUserEntersValidAndValid(String email, String password)
	{
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
	}
	
	@When("^the user clicks the login button")
	public void theUserClicksTheLoginButton()
	{
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@Then("^the user login is (.*)")
	public void theUserLoginIs(Boolean login)
	{

		String content = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(login, content.contains("Dashboard"));
		
	}
	
	 @After
     public void closeTheBrowser() {
         driver.close();
         driver.quit();
     }
}