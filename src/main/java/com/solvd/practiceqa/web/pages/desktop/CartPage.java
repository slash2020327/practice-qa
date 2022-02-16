package com.solvd.practiceqa.web.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.desktop.CartProduct;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.CartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-bottom')]")
    protected Header header;

    @FindBy(xpath = "//h3[text()='Your Bag']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[contains(@class,'cart-item')]/div/div")
    private List<CartProduct> products;

    @FindBy(xpath = "//div[contains(@class, 'summary')]//button[contains(@aria-label, 'Checkout')]")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/cart");
    }

    @Override
    public String getLastProductTitle() {
        List<ExtendedWebElement> webTitles = products.stream()
                .map(CartProduct::getProductTitle)
                .collect(Collectors.toList());
        ExtendedWebElement lastProductTitle = webTitles.get(webTitles.size() - 1);
        return lastProductTitle.getText();
    }

    public Header getHeader() {
        return header;
    }

    public ExtendedWebElement getCheckoutButton() {
        return checkoutButton;
    }

    public ExtendedWebElement getPageTitle() {
        return title;
    }

    public List<CartProduct> getProducts() {
        return products;
    }
}
