package pl.testeroprogramowania.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.LoggedUserPage;
import pl.testeroprogramowania.pages.MyAccountPage;
import pl.testeroprogramowania.utils.DriverFactory;

public class SignUpAndInStepDefs {

    protected String email;
    private LoggedUserPage loggedUserPage;

    @Given("User with unique email")
    public void userWithUniqueEmail() {
        int random = (int) (Math.random() * 1000);
        email = "test" + random + "@test.pl";
    }

    @When("User registers in application")
    public void userRegistersInApplication() {
        loggedUserPage =
                new HomePage(DriverFactory.getDriver())
                .openMyAccountPage()
                .registerUserValidData(email, "test@test.pl");
    }

    @Then("User should be redirected to logged user page")
    public void userShouldBeRedirectedToLoggedUserPage() {
        WebElement dashboardLink = loggedUserPage.getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Then("User should see an error which contains An account is already registered with your email address")
    public void userShouldSeeAnErrorWhichContainsAnAccountIsAlreadyRegisteredWithYourEmailAddress() {
        WebElement error = new MyAccountPage(DriverFactory.getDriver()).getError();
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address"));
    }

    @When("User logs in to the application")
    public void userLogsInToTheApplication() {
       loggedUserPage = new HomePage(DriverFactory.getDriver())
                .openMyAccountPage()
                .logInValidData(email, "test@test.pl");
    }


    @Given("User with email {string} which already exist in the application")
    public void userWithEmailWhichAlreadyExistInTheApplication(String email) {
        this.email = email;
    }
}
