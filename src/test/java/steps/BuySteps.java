package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuySteps {
	
	WebDriver driver;
	JavascriptExecutor executor;
	
	@Given("the user is on the application index page")
	public void theUserIsOnTheApplicationIndexPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net/");
		executor = (JavascriptExecutor)driver;
	}
	
	@When("the user clicks the cookie")
	public void theUserClicksTheCookie() {
		driver.findElement(By.id("cookie_stop")).click();
	}
	@When("the user clicks the fly destination")
	public void theUserClicksTheFlyDestination() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"new-york\"]/div/div[2]/a")).sendKeys(Keys.RETURN);
	}
	
	@When("the user clicks the first fly")
	public void theUserClicksTheFirstFly() {
		driver.findElement(By.xpath("//*[@id=\"data\"]/ul/li[1]/div/form/div/div[2]/div/button")).sendKeys(Keys.RETURN);
	}
	
	@When("^the user enters the personal information (.*), (.*), (.*), (.*), (.*)")
	public void theUserEntersThePersonalInformation(String FirstName, String LastName, String Email, String Phone, String Address) {
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(FirstName);
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(LastName);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(Email);
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(Phone);
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys(Address);
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[6]/div/div/div/span/span[1]/span")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/span/span/span[1]/input")).sendKeys("spain" + Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[7]/div/div/div/span/span[1]/span")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/span/span/span[1]/input")).sendKeys("spain" + Keys.RETURN);
		
	}
	
	@When("^the user enters the travellers information (.*), (.*), (.*)")
	public void theUserEntersTheTravellersInformation(String FirstName, String LastName, String Passport) {
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[1]/select/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]/select/option[210]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/select/option[13]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/select/option[24]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[3]/select/option[23]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/select/option[7]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[2]/select/option[7]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[3]/div/div[1]/select/option[13]")).click();
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[5]/form/section/div/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[3]/div/div[2]/select/option[13]")).click();
		driver.findElement(By.cssSelector("input[name='firstname_1']")).sendKeys(FirstName);
		driver.findElement(By.cssSelector("input[name='lastname_1']")).sendKeys(LastName);
		driver.findElement(By.cssSelector("input[name='passport_1']")).sendKeys(Passport);
	}
	
	@When("the user confirm the Booking")
	public void theUserConfirmTheBooking() {
		executor.executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@id=\"myTab\"]/label/label/label/label/label")));
		executor.executeScript("arguments[0].click()", driver.findElement(By.cssSelector("label[for='agreechb']")));
		executor.executeScript("arguments[0].click()", driver.findElement(By.id("booking")));
	}
	
	@Then("the booking status is pending")
	public void theBookingStausIsPending() throws InterruptedException {
		String content = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section/div/div/div/div/div[2]/div[3]/strong/div[2]/div/div[1]/form/input[3]")).getAttribute("value");
		Assert.assertTrue(content.contains("Request Cancellation"));
	}
	
	@After
    public void closeTheBrowser() {
		 //driver.close();
		 driver.quit();
    }
}
