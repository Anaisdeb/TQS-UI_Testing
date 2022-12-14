package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResearchSteps {

	WebDriver driver;
	JavascriptExecutor executor;
	
	@Given("the user is on the application research page")
	public void theUserIsOnTheApplicationResearchPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net");
		
//		Executor used to fix "WebDriverException: Element is not clickable at point (x, y)"
		executor = (JavascriptExecutor)driver;
		
		driver.findElement(By.id("cookie_stop")).click();
	}
	
	@When("the user clicks the flights option")
	public void theUserClicksTheFlightOption()
	{
		driver.findElement(By.id("flights-tab")).click();
	}
	
	@When("^the user enters the (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) fields")
	public void theUserEntersTheField(String way, String type, String from, String to, String departure, String back, String adults, String childs, String infants)
	{	
		driver.findElement(By.id(way)).click();
		Select flightType = new Select (driver.findElement(By.id("flight_type")));
		flightType.selectByVisibleText(type);
		driver.findElement(By.id("autocomplete")).sendKeys(from);
		driver.findElement(By.id("autocomplete2")).sendKeys(to);
		WebElement depart = driver.findElement(By.id("departure"));
		depart.clear();
		depart.sendKeys(departure);
		if(way.equals("round-trip")) {
			WebElement ret = driver.findElement(By.id("return"));
			ret.clear();
			ret.sendKeys(back);
		} 
		driver.findElement(By.className("col-lg-2")).click();	
		
//		Wait until travellers to be clickable
//		Duration duration = Duration.ofSeconds(20);
//		WebDriverWait wait = new WebDriverWait(driver, duration); 
			
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#onereturn > div.col-lg-2 > div > div > div > div > div.dropdown-item.adult_qty > div > div > div.qtyInc")));
		int adultsValue = Integer.parseInt(driver.findElement(By.id("fadults")).getAttribute("value"));
		for (int i=adultsValue; i<Integer.parseInt(adults); i++){
			driver.findElement(By.cssSelector("#onereturn > div.col-lg-2 > div > div > div > div > div.dropdown-item.adult_qty > div > div > div.qtyInc")).click();
		};
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#onereturn > div.col-lg-2 > div > div > div > div > div.dropdown-item.child_qty > div > div > div.qtyInc")));
		int childsValue = Integer.parseInt(driver.findElement(By.id("fchilds")).getAttribute("value"));
		for (int i=childsValue; i<Integer.parseInt(childs); i++){
			driver.findElement(By.cssSelector("#onereturn > div.col-lg-2 > div > div > div > div > div.dropdown-item.child_qty > div > div > div.qtyInc")).click();
		};
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#onereturn > div.col-lg-2 > div > div > div > div > div.dropdown-item.infant_qty > div > div > div.qtyInc")));
		int infantsValue = Integer.parseInt(driver.findElement(By.id("finfant")).getAttribute("value"));
		for (int i=infantsValue; i<Integer.parseInt(infants); i++){
			executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#onereturn > div.col-lg-2 > div > div > div > div > div.dropdown-item.infant_qty > div > div > div.qtyInc")));
		};
	}
	
	@When("the user clicks the research button")
	public void theUserClicksTheResearchButton()
	{
		driver.findElement(By.id("flights-search")).click();
	}
	
	@Then("^the research result is (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
	public void theResearchResultIs(String way, String type, String from, String to, String departure, String back, String adults, String childs, String infants)
	{
		String headerResult = driver.findElement(By.className("breadcrumb-wrap")).getText();
		String headerExpected;
		String urlResult = driver.getCurrentUrl();
		String urlExpected;
		
		if(way.equals("one-way")) {
			headerExpected = String.format("%s %s\nDates ( %s )\nAdults %s Childs %s Infants %s\n Total Flights :", from, to, departure, adults, childs, infants);
			urlExpected = String.format("https://phptravels.net/flights/en/usd/%s/%s/oneway/%s/%s/%s/%s/%s", from, to, type, departure, adults, childs, infants).toLowerCase();
		} else {
			headerExpected = String.format("%s %s\nDates ( %s%s )\nAdults %s Childs %s Infants %s\n Total Flights :", from, to, departure, back, adults, childs, infants);
			urlExpected = String.format("https://phptravels.net/flights/en/usd/%s/%s/return/%s/%s/%s/%s/%s/%s", from, to, type, departure, back, adults, childs, infants).toLowerCase();
		}
		urlExpected = urlExpected.replace(" ", "_");
		
		Assert.assertTrue(headerResult.contains(headerExpected));
		Assert.assertEquals(urlResult, urlExpected);
	}
	
//	 @After
//     public void closeTheBrowser() {
//         driver.close();
//         driver.quit();
//     }
}