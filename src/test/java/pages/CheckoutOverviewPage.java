package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class CheckoutOverviewPage {

    private ElementActions elementActions;
    WebDriver driver;

    By title = By.className("title");
    By finishBtn = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public String getPageTitle() {
        return elementActions.getText(title);
    }
    public void finishOrder() {
        elementActions.click(finishBtn);
    }

}