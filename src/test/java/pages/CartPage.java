package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementActions;

import java.util.List;


public class CartPage {


    ElementActions elementActions;
    WebDriver driver;

    By checkoutBtn = By.id("checkout");
    By cartItemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public void cartPageStartCheckout() {
        elementActions.click(checkoutBtn);
    }

    public Boolean cartPageVerifyCartItem(String product) {
        if (product != null && elementActions.isDisplayed(cartItemName)) {

            List<WebElement> items = driver.findElements(cartItemName);
            for (WebElement item : items) {
                if (item.getText().equalsIgnoreCase(product)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }


}