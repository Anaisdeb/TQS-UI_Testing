package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResearchSteps {

	WebDriver driver;
	
	@Given("the user is on the application landing page")
	public void theUserIsOnTheApplicationLandingPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://phptravels.net");
	}
	
	@When("the user clicks the flights option")
	public void theUserClicksTheFlightOption()
	{
		driver.findElement(By.id("flights-tab")).click();
	}
	
	@When("^the user enters the (.*)(.*)(.*)(.*)(.*)(.*)(.*)(.*)(.*) fields")
	public void theUserEntersTheField(String way, String type, String from, String to, String departure, String back, String adults, String childs, String infants)
	{
		driver.findElement(By.id(way)).click();
		Select flightType = new Select (driver.findElement(By.id("flight_type")));
		flightType.selectByVisibleText(type);
		driver.findElement(By.id("autocomplete")).sendKeys(from);
		driver.findElement(By.id("autocomplete2")).sendKeys(to);
		driver.findElement(By.id("departure")).sendKeys(departure);
		if(way.equals("round-trip")) {
			driver.findElement(By.id("return")).sendKeys(back);
		};
		
		
	}
	
	@When("the user clicks the research button")
	public void theUserClicksTheResearchButton()
	{
	
	}
	
	@Then("^the first flight is (.*)(.*)")
	public void theUserLoginIs(String first, String price)
	{
		
	}
	
	 @After
     public void closeTheBrowser() {
         driver.close();
         driver.quit();
     }
}