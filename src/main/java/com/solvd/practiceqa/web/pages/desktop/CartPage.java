package com.solvd.practiceqa.web.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Localized;
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

    @Localized
    @FindBy(xpath = "//h3[text()='{L10N:CartPage.title}']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[contains(@class,'cart-item')]/div/div")
    private List<CartProduct> products;

    @FindBy(xpath = "//div[contains(@class, 'summary')]//button[contains(@aria-label, '{L10N:CartPage.checkout}')]")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getEnvArg("base_url") + "/cart");
    }

    @Override
    public String getLastProductTitle() {
        List<String> webTitles = products.stream()
                .map(CartProduct::getProductTitleText)
                .collect(Collectors.toList());
        return webTitles.get(webTitles.size() - 1);
    }
}
