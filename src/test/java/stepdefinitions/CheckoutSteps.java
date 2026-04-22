package stepdefinitions;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.*;

import java.util.List;

import static org.junit.Assert.*;

public class CheckoutSteps extends BaseTest {

    private final LoginPage loginPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;
    private final ProductsPage productsPage;
    private final ProductsDetailsPage productsDetailsPage;
    private final CheckoutOverviewPage checkoutOverviewPage;


    public CheckoutSteps() {
        this.loginPage = new LoginPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.productsDetailsPage = new ProductsDetailsPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    private void login(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();
    }

    @Given("User add product and proceed to cart for user {string}")
    public void user_add_product_product_page(String user) {
        login(user, "secret_sauce");
        productsPage.addProduct();
        String actualMessage = productsPage.getRemoveBtnText();
        assertEquals("Remove", actualMessage);
        productsPage.clickCart();
    }

    @Given("User add product {string} in cart from product page")
    public void user_add_particular_product_product_page(String productName) {
        productsPage.openSpecificProduct(productName);
        productsDetailsPage.addProduct();
        String actualMessage = productsDetailsPage.getRemoveBtnText();
        assertEquals("Remove", actualMessage);
    }

    @Given("User add product {string} and proceed to cart for user {string}")
    public void user_add_product_and_proceed(String productName, String user) {
        login(user, "secret_sauce");
        productsPage.openSpecificProduct(productName);
        productsDetailsPage.addProduct();
        String actualMessage = productsDetailsPage.getRemoveBtnText();
        assertEquals("Remove", actualMessage);
        productsDetailsPage.clickCart();
    }

    @When("User proceeds to checkout with below details")
    public void user_proceeds_to_checkout_with_details(DataTable dataTable) {
        var row = dataTable.asMap();
        if (row.get("product") != null) {
            for (String prod : List.of(row.get("product"))) {
                assertTrue(cartPage.cartPageVerifyCartItem(row.get(prod)));
            }
        }
        cartPage.cartPageStartCheckout();
        checkoutPage.enterDetails(row.get("firstName"), row.get("lastName"), row.get("zip"));
        checkoutPage.continueCheckout();
        assertEquals(row.get("title"), checkoutOverviewPage.getPageTitle());
        checkoutOverviewPage.finishOrder();
    }

    @Then("User should see order confirmation")
    public void user_should_see_order_confirmation() {

        String confirmation = checkoutPage.getConfirmation();
        assertEquals("Thank you for your order!", confirmation);
    }
}