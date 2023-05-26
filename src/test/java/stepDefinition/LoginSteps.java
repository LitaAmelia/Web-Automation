package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        loginPage = new LoginPage(hooks.getDriver());
        homePage = new HomePage(hooks.getDriver());
    }

    @Given("I am on Login page")
    public void iAmOnLoginPage() throws InterruptedException{
        driver.get("https://www.saucedemo.com");
        Thread.sleep(500);
    }

    @When("I fill username and password")
    public void iFillUsernameAndPassword() throws InterruptedException{
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        Thread.sleep(500);
    }

    @And("I click login button")
    public void iClickLoginButton() throws InterruptedException{
        loginPage.clickLoginButton();
        Thread.sleep(500);
    }

    @Then("I navigate to homepage")
    public void iNavigateToHomepage() throws InterruptedException{
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOf(homePage.getProductsLabel())
        );
        Thread.sleep(500);
    }

    @When("I input (.*) and (.*)$")
    public void iInputUsernameAndPassword(String username, String password) throws InterruptedException{
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        Thread.sleep(500);
    }

    @Then("I get login (.*)$")
    public void iGetLoginResult(String expectedResult) throws InterruptedException{
        if(expectedResult.equals("blank field")) {
            WebElement errorMessage = loginPage.getErrorMessage();
            String actualErrorMessage = errorMessage.getText();
            String expectedErrorMessage = loginPage.getExpectedMessageBlankField();
            assertEquals(expectedErrorMessage, actualErrorMessage);
        } else if (expectedResult.equals("username blank")) {
            WebElement errorMessage = loginPage.getErrorMessage();
            String actualErrorMessage = errorMessage.getText();
            String expectedErrorMessage = loginPage.getExpectedMessageUsernameBlank();
            assertEquals(expectedErrorMessage, actualErrorMessage);
        } else if (expectedResult.equals("password blank")) {
            WebElement errorMessage = loginPage.getErrorMessage();
            String actualErrorMessage = errorMessage.getText();
            String expectedErrorMessage = loginPage.getExpectedMessagePasswordBlank();
            assertEquals(expectedErrorMessage, actualErrorMessage);
        } else if (expectedResult.equals("missmatch")) {
            WebElement errorMessage = loginPage.getErrorMessage();
            String actualErrorMessage = errorMessage.getText();
            String expectedErrorMessage = loginPage.getExpectedMessageMissmatch();
            assertEquals(expectedErrorMessage, actualErrorMessage);
        }
        Thread.sleep(500);
    }

}
