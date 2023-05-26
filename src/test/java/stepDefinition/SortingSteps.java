package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortingSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public SortingSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        loginPage = new LoginPage(hooks.getDriver());
        homePage = new HomePage(hooks.getDriver());
    }
    @Given("I on SauceDemo HomePage")
    public void iOnSauceDemoHomePage() throws InterruptedException{
        driver.get("https://www.saucedemo.com");
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        Thread.sleep(500);
    }

    @When("I sort the products by name \\(A-Z)")
    public void iSortTheProductsByNameAZ() throws InterruptedException{
        homePage.selectSortingOption("az");
        Thread.sleep(500);
    }

    @Then("The products should be displayed in alphabetical order")
    public void theProductsShouldBeDisplayedInAlphabeticalOrder() throws InterruptedException{
        assertEquals(true, isNameSortedAscending(homePage.getProductNames()));
        Thread.sleep(500);
    }

    private boolean isNameSortedAscending(List<WebElement> productNames) {
        for (int i = 0; i < productNames.size() - 1; i++) {
            String currentName = productNames.get(i).getText();
            String nextName = productNames.get(i + 1).getText();
            if (currentName.compareToIgnoreCase(nextName) > 0) {
                return false;
            }
        }
        return true;
    }

    @When("I sort the products by name \\(Z-A)")
    public void iSortTheProductsByNameZA() throws InterruptedException{
        homePage.selectSortingOption("za");
        Thread.sleep(500);
    }

    @Then("The products should be displayed in reverse alphabetical order")
    public void theProductsShouldBeDisplayedInReverseAlphabeticalOrder() throws InterruptedException{
        assertEquals(true, isNameSortedDescending(homePage.getProductNames()));
        Thread.sleep(500);
    }

    private boolean isNameSortedDescending(List<WebElement> productNames) {
        for (int i = 0; i < productNames.size() - 1; i++) {
            String currentName = productNames.get(i).getText();
            String nextName = productNames.get(i + 1).getText();
            if (currentName.compareToIgnoreCase(nextName) < 0) {
                return false;
            }
        }
        return true;
    }

    @When("I sort the products by lowest price")
    public void iSortTheProductsByLowestPrice() throws InterruptedException{
        homePage.selectSortingOption("lohi");
        Thread.sleep(500);
    }

    @Then("The products should be displayed in ascending order of price")
    public void theProductsShouldBeDisplayedInAscendingOrderOfPrice() throws InterruptedException{
        assertEquals(true, isPriceSortedAscending(homePage.getProductPrices()));
        Thread.sleep(500);
    }

    private boolean isPriceSortedAscending(List<WebElement> productPrices) {
        for (int i = 0; i < productPrices.size() - 1; i++) {
            double currentPrice = Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
            double nextPrice = Double.parseDouble(productPrices.get(i + 1).getText().replace("$", ""));
            if (currentPrice > nextPrice) {
                return false;
            }
        }
        return true;
    }

    @When("I sort the products by highest price")
    public void iSortTheProductsByHighestPrice() throws InterruptedException{
        homePage.selectSortingOption("hilo");
        Thread.sleep(500);
    }

    @Then("The products should be displayed in descending order of price")
    public void theProductsShouldBeDisplayedInDescendingOrderOfPrice() throws InterruptedException{
        assertEquals(true, isPriceSortedDescending(homePage.getProductPrices()));
        Thread.sleep(500);
    }

    private boolean isPriceSortedDescending(List<WebElement> productPrices) {
        for (int i = 0; i < productPrices.size() - 1; i++) {
            double currentPrice = Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
            double nextPrice = Double.parseDouble(productPrices.get(i + 1).getText().replace("$", ""));
            if (currentPrice < nextPrice) {
                return false;
            }
        }
        return true;
    }
}
