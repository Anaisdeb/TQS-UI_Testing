package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderSteps {

	WebDriver driver;
	JavascriptExecutor executor;
	
	@Given("the user is on the main page")
	public void theUserIsOnTheMainPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net/");
		executor = (JavascriptExecutor)driver;
	}
	
	@When("the user click the currency")
	public void theUserClickTheCurrency() {
		driver.findElement(By.id("currency")).click();
	}
	
	@When("^the user change the (.*)")
	public void theUserChangeTheCurrency(String Currency) {
		driver.findElement(By.partialLinkText(Currency)).click();
	}
	
	@Then("^the price is in the right (.*)")
	public void thePriceIsInTheRightCurrency(String Currency) {
		String content = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(content.contains(Currency));
	}
	
	@After
    public void closeTheBrowser() {
		 //driver.close();
		 driver.quit();
    }
}
