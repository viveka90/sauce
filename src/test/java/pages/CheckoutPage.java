package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class CheckoutPage {

    private ElementActions elementActions;
    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By confirmationMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public void enterDetails(String fName, String lName, String zip) {
        elementActions.sendKeys(firstName, fName);
        elementActions.sendKeys(lastName, lName);
        elementActions.sendKeys(postalCode, zip);
    }

    public void continueCheckout() {
        elementActions.click(continueBtn);
    }

    public String getConfirmation() {
        return elementActions.getText(confirmationMsg);
    }
}