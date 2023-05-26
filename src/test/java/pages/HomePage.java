package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By productsLabel = By.className("title");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By dropdownSorting = By.className("product_sort_container");


    public HomePage (WebDriver driver) {
        this.driver = driver;
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
    }

    public WebElement getProductsLabel() {
        return driver.findElement(productsLabel);
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    public void selectSortingOption(String optionValue) {
        WebElement sortDropdown = driver.findElement(dropdownSorting);
        wait.until(ExpectedConditions.visibilityOf(sortDropdown));
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue(optionValue);
    }
}
