package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.*;
import static org.junit.Assert.*;

public class LoginSteps extends BaseTest {


    private LoginPage loginPage;
    private ProductsPage productsPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
    }
    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(driver);
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Given("User is logged in with {string} and {string}")
    public void user_logged_in(String user, String pass) {

        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();
        productsPage = new ProductsPage(driver);
    }

    @When("User clicks login")
    public void user_clicks_login() {
        loginPage.clickLogin();
        productsPage = new ProductsPage(driver);
    }

    @When("User clicks reset")
    public void click_reset() {
        productsPage.clickReset();
    }

    @When("User clicks All item")
    public void click_All_item() {
        productsPage.clickInventory();
    }

    @When("User clicks about")
    public void click_about() {
        productsPage.clickAbout();
    }

    @When("verify page title {string}")
    public void verify_about_page(String title) {
        assertEquals(title, loginPage.getTitle());
    }

    @When("User verify reset state")
    public void verify_reset_state() {
        assertEquals("", productsPage.getCartCount());
        productsPage.verifyRemoveButtonNotDisplayed();
    }

    @When("User clicks logout")
    public void click_logout() {
        productsPage.clickLogout();
    }

    @Then("User should see products page")
    public void verify_products() {
        assertEquals("Products", productsPage.getPageTitle());
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}