package com.solvd.practiceqa.web.pages.android;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.android.AndroidCartProduct;
import com.solvd.practiceqa.web.components.android.AndroidHeader;
import com.solvd.practiceqa.web.pages.CartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class AndroidCartPage extends CartPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected AndroidHeader header;

    @FindBy(xpath = "//h4[text()='Your Bag']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[contains(@class,'cart-item')]/div/div")
    private List<AndroidCartProduct> products;

    @FindBy(xpath = "//div[contains(@class, 'summary')]//button[contains(@aria-label, 'Checkout')]")
    private ExtendedWebElement checkoutButton;

    public AndroidCartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/cart");
    }

    @Override
    public String getLastProductTitle() {
        List<ExtendedWebElement> webTitles = products.stream()
                .map(AndroidCartProduct::getProductTitle)
                .collect(Collectors.toList());
        ExtendedWebElement lastProductTitle = webTitles.get(webTitles.size() - 1);
        return lastProductTitle.getText();
    }

    public AndroidHeader getHeader() {
        return header;
    }

    public ExtendedWebElement getPageTitle() {
        return title;
    }

    public List<AndroidCartProduct> getProducts() {
        return products;
    }

    public ExtendedWebElement getCheckoutButton() {
        return checkoutButton;
    }
}
