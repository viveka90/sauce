package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import static org.junit.Assert.assertTrue;

public class ProductsPage {

    ElementActions elementActions;
    WebDriver driver;

    By title = By.className("title");
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By removeBtn = By.id("remove-sauce-labs-backpack");
    By logoutBtn = By.id("logout_sidebar_link");
    By burgerMenu = By.id("react-burger-menu-btn");
    By resetBtn = By.id("reset_sidebar_link");
    By burgerMenuClose = By.id("react-burger-cross-btn");
    By aboutBtn = By.id("about_sidebar_link");
    By inventoryBtn = By.id("inventory_sidebar_link");
    By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public String getPageTitle() {
        return elementActions.getText(title);
    }

    public void clickLogout() {
        elementActions.click(burgerMenu);
        elementActions.click(logoutBtn);
    }

    public void clickAbout() {
        elementActions.click(burgerMenu);
        elementActions.click(aboutBtn);
    }

    public void clickReset() {
        elementActions.click(burgerMenu);
        elementActions.click(resetBtn);
        elementActions.click(burgerMenuClose);
    }

    public void clickInventory() {
        elementActions.click(burgerMenu);
        elementActions.click(inventoryBtn);
    }

    public void openSpecificProduct(String product) {
        elementActions.click(By.xpath("//div[@class='inventory_item_name ' and text()='" + product + "']"));
    }

    public void addProduct() {
        elementActions.click(addToCartBtn);
    }

    public String getRemoveBtnText() {
        return elementActions.getText(removeBtn);
    }
    public String getCartCount() {
        return driver.findElement(cartIcon).getText();
    }

    public void clickCart() {
        elementActions.click(cartIcon);
    }

    public void removeProduct() {
        elementActions.click(removeBtn);
    }

    public void addSpecificProductToCart(String product) {
        String xpath = "//div[@class='inventory_item_name ' and text()='" + product + "']/ancestor::div[@class='inventory_item_description']//button";
        elementActions.click(By.xpath(xpath));
    }

    public void verifyRemoveButtonNotDisplayed() {
        assertTrue(elementActions.isNotDisplayed(removeBtn));
    }

}