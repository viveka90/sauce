package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class ProductsDetailsPage {

    ElementActions elementActions;
    WebDriver driver;

    By addToCartBtn = By.id("add-to-cart");
    By removeBtn = By.id("remove");
    By cartIcon = By.className("shopping_cart_link");

    public ProductsDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public void addProduct() {
        elementActions.click(addToCartBtn);
    }

    public void clickCart() {
        elementActions.click(cartIcon);
    }

    public String getRemoveBtnText() {
        return elementActions.getText(removeBtn);
    }

    public void removeProduct() {
        elementActions.click(removeBtn);
    }

}