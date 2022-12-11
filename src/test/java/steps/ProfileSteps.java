package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps {
	
	WebDriver driver;
	
	@Given("the user is on the customer dashboard page")
	public void theUserIsOnTheCustomerDashboardPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net/login");
		driver.findElement(By.id("cookie_stop")).click();
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("user@phptravels.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("demouser");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@When("the user clicks the profile button")
	public void theUserClicksTheProfileButton()
	{
		driver.findElement(By.className("header-right-action pt-1 pe-2")).click();
		driver.findElement(By.linkText(" My Profile")).click();
	}
	
	@When("^the user enters the (.*) field with (.*)")
	public void theUserEntersTheFieldWith(String field, String value)
	{
		driver.findElement(By.cssSelector("input[name="+field+"]")).sendKeys(value);
	}
	
	@When("the user clicks the update button")
	public void theUserClicksTheUpdateButton()
	{
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@Then("^the profile is updated for (.*) with (.*)")
	public void theProfileIsUpdatedForWith(String field, String value)
	{
		
	}
}
