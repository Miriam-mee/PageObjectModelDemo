package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginDemoSteps {

    WebDriver d = null;
    LoginPage login;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println(" === I am inside browser_is_open === ");
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        d.manage().window().maximize();


    }

    @And("user is on login page")
    public void user_is_on_loginPage() {
        d.navigate().to("https://example.testproject.io/web/");

    }

    @When("user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) throws InterruptedException {
        login = new LoginPage(d);
        login.enterUsername(username);
        login.enterPassword(password);
        Thread.sleep(3000);

    }

    @And("user clicks on login")
    public void user_clicks_on_login() {
        login.clickLogin();

    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {
        assertTrue(login.checkLogoutIsDisplayed());
        Thread.sleep(3000);
        d.close();

    }

}
