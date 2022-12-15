package steps;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanySteps {
	
	WebDriver driver;
	JavascriptExecutor executor;

	@Given("the user is on phptravels")
	public void theUserIsOnPhptravels() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://phptravels.net");
		executor = (JavascriptExecutor)driver;
	}
	
	@When("^the user cliks to move to (.*)")
	public void theUserMOveToPage(String Page) {
        WebElement hoverable = driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]/a"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.xpath(Page)).click();
	}
	
	@When("^the user move to the social (.*)")
	public void theUserMoveToTheSocialPage(String Account) {
		driver.findElement(By.xpath(Account)).click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	
	@Then("^the page is the right social (.*)")
	public void thePageIsTheRightSocialMedia(String Media) {
		String URL = driver.getCurrentUrl();
		assertTrue(URL.contains(Media));
	}
	
}
