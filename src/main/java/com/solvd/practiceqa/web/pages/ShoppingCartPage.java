package com.solvd.practiceqa.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends AdidasPage {

    @FindBy(xpath = "//h3[text()='Your Bag']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[contains(@class,'cart-item')]/div/div")
    private List<ExtendedWebElement> products;

    @FindBy(xpath = "//div[contains(@class, 'summary')]//button[contains(@aria-label, 'Checkout')]")
    private ExtendedWebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/cart");
    }

    public ExtendedWebElement getCheckoutButton() {
        return checkoutButton;
    }

    public ExtendedWebElement getPageTitle() {
        return title;
    }

    public List<ExtendedWebElement> getProducts() {
        return products;
    }
}
