package com.solvd.practiceqa.web.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-bottom')]")
    protected Header header;

    @FindBy(xpath = "//div[contains(@class,'sidebar')]//h1")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[contains(@class, 'size')]")
    private List<ExtendedWebElement> sizeGrid;

    @FindBy(xpath = "//button[@title='{L10N:ProductPage.button}']")
    private ExtendedWebElement addToBagButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupCloseButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getEnvArg("base_url") + "/ultraboost-22-shoes/GX5592.html");
    }

    @Override
    public String getProductTitleText() {
        return title.getText();
    }

    @Override
    public CartPage addProductToBag(String size) {
        chooseSize(size);
        addToBagButton.click();
        popupCloseButton.click();
        header.clickBagButton();
        return new CartPage(getDriver());
    }

    @Override
    public ProductPage chooseSize(String size) {
        ExtendedWebElement chosenSize;
        chosenSize = sizeGrid.stream()
                .filter(item -> size.equals(item.getText()))
                .findFirst()
                .get();
        chosenSize.click();
        return this;
    }
}
