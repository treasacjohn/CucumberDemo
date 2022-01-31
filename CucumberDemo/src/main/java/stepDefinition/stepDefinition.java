package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {

	WebDriver wd = new ChromeDriver();
	String url;

	@Given("I want to launch google.com")
	public void i_want_to_launch_google_com() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\WorkspaceSDET\\CucumberDemo\\chromedriver.exe");
		wd.get("https://www.google.com/");
		wd.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Launched Google Chrome");
	}

	@When("I enter text for search")
	public void i_enter_text() throws InterruptedException {
		wd.findElement(By.name("q")).sendKeys("Britannica" + Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("Searched for the text");
	}

	@Then("I verify that I am able to click on the available link")
	public void i_verify_that_i_am_able_to_click_link() throws InterruptedException {
		wd.findElement(By.xpath("//h3[contains(.,'Encyclopedia Britannica | Britannica')]")).click();
		Thread.sleep(5000);
		System.out.println("Clicked on the searched list");
	}

	@And("I navigate to search result page")
	public void i_navigate_to_search_result_page() {
		System.out.println("URL Title is : " + wd.getTitle());
	}

	@Given("I want to launch browser <{string}>")
	public void i_want_to_launch_browser(String browsername) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\WorkspaceSDET\\CucumberDemo\\chromedriver.exe");
		wd.get(browsername);
		wd.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Launched browser : " + browsername);
	}

	@When("I enter <{string}> for search")
	public void i_enter_for_search(String text) throws InterruptedException {
		wd.findElement(By.name("q")).sendKeys(text + Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("Searched for the text : " + text);
	}

	@And("I navigate to search <{string}> page")
	public void i_navigate_to_search_page(String result) {
		url = wd.getCurrentUrl();
		if (url.contains("https://www.britannica.com/")) {
			System.out.println("Page is launched with URL : " + url);
		} else {
			System.out.println("Page is not launched");
		}
	}
}
