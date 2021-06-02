import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.LoggedUserPage;
import pl.testeroprogramowania.pages.MyAccountPage;
import pl.testeroprogramowania.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class StepDefs {

    private WebDriver driver;
    private String email;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User with unique email")
    public void userWithUniqueEmail() {
        int random = (int) (Math.random() * 1000);
        email = "test" + random + "@test.pl";
    }

    @When("User registers in application")
    public void userRegistersInApplication() {
        new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email, "test@test.pl");
    }

    @Then("User should be redirected to logged user page")
    public void userShouldBeRedirectedToLoggedUserPage() {
        WebElement dashboardLink = new LoggedUserPage(driver).getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Given("User with email which already exist in the application")
    public void userWithEmailWhichAlreadyExistInTheApplication() {
        email = "test1@test.pl";
    }

    @Then("User should see an error which contains An account is already registered with your email address")
    public void userShouldSeeAnErrorWhichContainsAnAccountIsAlreadyRegisteredWithYourEmailAddress() {
        WebElement error = new MyAccountPage(driver).getError();
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address"));
    }
}
