package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OffersSteps {
	WebDriver driver;
	JavascriptExecutor executor;

	@Given("the user is on the offers page")
	public void theUserIsOnTheOffersPage() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net/offers");
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.id("cookie_stop")));
	}

	@When("^the user clicks the (.*) offer")
	public void theUserClicksTheOffer(String offer) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		executor.executeScript("arguments[0].click();", driver.findElement(By.partialLinkText(offer)));
	}

	@Then("^the offer information is (.*), (.*), (.*), (.*)")
	public void theOfferInformationIs(String price, String phone, String email, String date) {
		String dataResult = driver.findElement(By.className("card-body")).getAttribute("innerText");
		String dataExpected = String.format("Price %s\n\nPhone %s\n\nEmail %s\n\nExpiry Date %s", price, phone, email,
				date);

		Assert.assertTrue(dataResult.contains(dataExpected));
	}

	@After
	public void closeTheBrowser() {
//	         driver.close();
//	         driver.quit();
	}
}
