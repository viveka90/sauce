package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.*;

import static org.junit.Assert.assertEquals;

public class CartSteps extends BaseTest {


    private ProductsPage productsPage;
    private ProductsDetailsPage productsDetailsPage;

    public CartSteps() {
        this.productsPage = new ProductsPage(driver);
        this.productsDetailsPage = new ProductsDetailsPage(driver);
    }
    @When("User adds product to cart")
    public void add_product() {
        productsPage.addProduct();
    }

    @When("User remove product in product page")
    public void remove_product() {
        productsPage.removeProduct();
    }

    @When("User remove product from cart in product details page")
    public void remove_product_product_details_page() {
        productsDetailsPage.removeProduct();
    }

    @Then("Cart badge should show {string}")
    public void verify_cart(String count) {
        assertEquals(count, productsPage.getCartCount());
    }
    @When("User open cart page")
    public void open_cart() {
        productsPage.clickCart();
    }


}