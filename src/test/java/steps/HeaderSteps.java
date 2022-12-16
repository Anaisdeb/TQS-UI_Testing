package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	public void theUserIsOnTheMainPage() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net/");
		executor = (JavascriptExecutor) driver;
	}

	@When("^the user click the (.*) dropdown")
	public void theUserClickTheButtonDropdown(String Button) {
		driver.findElement(By.id(Button)).click();
	}

	@When("^the user change the (.*)")
	public void theUserChangeTheMenu(String Menu) {
		driver.findElement(By.partialLinkText(Menu)).click();
	}

	@Then("^the page is in the right (.*)")
	public void thePageIsInTheRightMenu(String Menu) {
		String content = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(content.contains(Menu));
	}

	@After
	public void closeTheBrowser() {
		// driver.close();
		// driver.quit();
	}
}
