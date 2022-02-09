package Steps2;

import PageFactory.HomePage_PF;
import Steps.LoginDemoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginDemoSteps_PF {
    WebDriver d = null;
    LoginDemoSteps_PF login;
    HomePage_PF home;

    public LoginDemoSteps_PF(WebDriver d) {
        LoginDemoSteps_PF loginDemoSteps_pf=this;
        d = d;
    }

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println(" === I am inside browser_is_open === ");
        System.out.println("Inside Step-browser is open");

        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        d.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        d.manage().window().maximize();
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        d.navigate().to("https://example.testproject.io/web/");
    }

    @When("user enters (.*) and  and (.*)$")
    public void user_enters_username_and_password(String username, String password) throws InterruptedException {
        login= new LoginDemoSteps_PF(d);
        login.enterUsername(username);
        login.enterPassword(password);

        Thread.sleep(2000);
    }

    private void enterPassword(String password) {
        return;
    }

    private void enterUsername(String username) {
        return;
    }


    @And("user clicks on login")
    public void user_clicks_on_login() {

        login.clicksOnLogin();
    }

    private void clicksOnLogin() {
        return;
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {
        home = new HomePage_PF(d);
        home.checkLogoutIsDisplayed();

        Thread.sleep(2000);
        d.close();
        d.quit();

    }
}



