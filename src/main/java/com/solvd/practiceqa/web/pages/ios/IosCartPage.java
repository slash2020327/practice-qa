package com.solvd.practiceqa.web.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.ios.IosCartProduct;
import com.solvd.practiceqa.web.components.ios.IosHeader;
import com.solvd.practiceqa.web.pages.CartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class IosCartPage extends CartPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected IosHeader header;

    @FindBy(xpath = "//h4[text()='Your Bag']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[contains(@class,'cart-item')]/div/div")
    private List<IosCartProduct> products;

    @FindBy(xpath = "//div[contains(@class, 'summary')]//button[contains(@aria-label, 'Checkout')]")
    private ExtendedWebElement checkoutButton;

    public IosCartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getEnvArg("base_url") + "/cart");
    }

    @Override
    public String getLastProductTitle() {
        List<String> webTitles = products.stream()
                .map(IosCartProduct::getProductTitleText)
                .collect(Collectors.toList());
        return webTitles.get(webTitles.size() - 1);
    }
}