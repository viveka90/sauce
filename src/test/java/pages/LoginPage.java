package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class LoginPage {

    ElementActions elementActions;
    WebDriver driver;


    By errorMsg = By.cssSelector("[data-test='error']");
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementActions = new ElementActions(driver);
    }

    public void enterUsername(String user) {
        elementActions.sendKeys(username, user);
    }

    public void enterPassword(String pass) {
        elementActions.sendKeys(password, pass);
    }

    public void clickLogin() {
        elementActions.click(loginBtn);
    }

    public String getErrorMessage() {
        return elementActions.getText(errorMsg);
    }

    public String getTitle() {
        return elementActions.getTitle();
    }
}