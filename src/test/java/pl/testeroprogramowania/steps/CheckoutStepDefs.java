package pl.testeroprogramowania.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.CartPage;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;
import pl.testeroprogramowania.pages.ProductListPage;
import pl.testeroprogramowania.utils.DriverFactory;

public class CheckoutStepDefs  {

    private Customer customer;
    private CartPage cartPage;
    private OrderDetailsPage orderDetailsPage;
    private ProductListPage productListPage;

    @Given("User on shop home page")
    public void userOnShopHomePage() {
        customer = new Customer();
        customer.setEmail("specificemail@gmail.com");
        productListPage = new HomePage(DriverFactory.getDriver()).openShopPage();
    }

    @And("he fills address details")
    public void heFillsAddressDetails() {
        orderDetailsPage= cartPage.openAddressDetails()
                .fillAddressDetails(customer,"Some random comment");
    }

    @Then("he should be redirected to thank you page")
    public void heShouldBeRedirectedToThankYouPage() {
        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver × 1");
    }

    @When("he selects {string} product")
    public void heSelectsProduct(String productName) {
        cartPage = productListPage.openProduct(productName)
                .addProductToCart()
                .viewCart();
    }
}

