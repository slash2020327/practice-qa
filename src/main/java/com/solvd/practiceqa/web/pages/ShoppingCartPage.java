package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Your Bag']")
    WebElement title;

    @FindBy(xpath = "//a[contains(@class, 'line-item') and contains(@class, 'title')]")
    List<WebElement> productTitle;

    @FindBy(xpath = "//select[contains(@class, 'dropdown')]")
    List<WebElement> productAmount;

    @FindBy(xpath = "//button[@class='gl-dropdown-custom__option']")
    List<WebElement> amountOptions;

    @FindBy(xpath = "//button[contains(@data-auto-id, 'delete')]")
    List<WebElement> deleteButton;

    @FindBy(xpath = "//div[contains(@class, 'summary')]//button[contains(@aria-label, 'Checkout')]")
    WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage(WebDriver driver, String path) {
        super(driver);
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL);
        setUrl(pageUrl + path);
    }

    public List<WebElement> getProductTitle() {
        return productTitle;
    }

    public List<WebElement> getProductAmount() {
        return productAmount;
    }

    public List<WebElement> getDeleteButton() {
        return deleteButton;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getTitle() {
        return title;
    }

    public List<WebElement> getAmountOptions() {
        return amountOptions;
    }
}
