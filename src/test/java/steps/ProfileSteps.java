package steps;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps {
	
	WebDriver driver;
	JavascriptExecutor executor;
	
	@Given("the user is on the customer dashboard page")
	public void theUserIsOnTheCustomerDashboardPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net/login");
		executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", driver.findElement(By.id("cookie_stop")));
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("agent@phptravels.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("demoagent");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@When("the user clicks the account button")
	public void theUserClicksTheAccountButton()
	{
		driver.findElements(By.id("currency")).get(1).click();
	}
	
	@When("the user clicks the profile button")
	public void theUserClicksTheProfileButton()
	{
		driver.findElement(By.cssSelector("a[href='https://phptravels.net/account/profile']")).click();
	}
	
	@When("^the user enters the (.*) field with (.*)")
	public void theUserEntersTheFieldWith(String field, String value)
	{
		WebElement place = driver.findElement(By.cssSelector("input[name="+field+"]"));
		place.clear();
		place.clear();
		place.sendKeys(value);
	}
	
	@When("the user clicks the update button")
	public void theUserClicksTheUpdateButton()
	{
		executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("button[type='submit']")));
	}
	
	@Then("^the profile is updated for (.*) with (.*)")
	public void theProfileIsUpdatedForWith(String field, String value)
	{
		Optional<WebElement> success = Optional.of(driver.findElement(By.className("alert-success")));
		Assert.assertTrue(success.isPresent());
		
		String content = driver.findElement(By.cssSelector("input[name="+field+"]")).getAttribute("value");
		Assert.assertEquals(content, value);
	}
}
