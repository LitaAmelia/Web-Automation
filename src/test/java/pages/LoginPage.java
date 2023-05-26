package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

    public String getExpectedMessageBlankField() {
        return "Epic sadface: Username and password is required";
    }

    public String getExpectedMessageUsernameBlank() {
        return "Epic sadface: Username is required";
    }

    public String getExpectedMessagePasswordBlank() {
        return "Epic sadface: Password is required";
    }

    public String getExpectedMessageMissmatch() {
        return "Epic sadface: Username and password do not match any user in this service";
    }
}
