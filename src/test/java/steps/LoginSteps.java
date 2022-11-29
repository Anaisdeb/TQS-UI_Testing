package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;

public class LoginSteps {
	
	WebDriver driver;
	
	@Given("the user is on the application landing page")
	public void theUserIsOnTheApplicationLandingPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://phptravels.net");
	}
}