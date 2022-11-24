package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        int random = (int) (Math.random() * 1000);
        String username = "test" + random + "@test.pl";
        ExtentTest extentTest = extentReports.createTest("Register user with username " + username);
        extentTest.pass("Browser opened");
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("test" + random + "@test.pl", "test@test.pl")
                .getDashboardLink();
        extentTest.pass("Register steps ");
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        extentTest.pass("Dashboard link displayed ");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        ExtentTest extentTest = extentReports.createTest("Register user with username test@test.pl");
        extentTest.pass("Browser opened");
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test@test.pl", "test@test.pl")
                .getError();
        extentTest.pass("Register steps ");
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address"));
        extentTest.pass("Error message displayed");
    }


}
