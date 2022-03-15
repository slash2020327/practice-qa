package com.solvd.practiceqa.web.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.ios.IosHeader;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class IosProductPage extends ProductPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected IosHeader header;

    @FindBy(xpath = "//h1[contains(@class,'heading')]/span")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[contains(@class, 'size')]")
    private List<ExtendedWebElement> sizeGrid;

    @FindBy(xpath = "//button[@title='Add To Bag']")
    private ExtendedWebElement addToBagButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupCloseButton;

    public IosProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/ultraboost-22-shoes/GX5592.html");
    }

    @Override
    public IosProductPage chooseSize(String size) {
        ExtendedWebElement chosenSize;
        chosenSize = sizeGrid.stream()
                .filter(item -> size.equals(item.getText()))
                .findFirst()
                .get();
        chosenSize.click();
        return this;
    }

    @Override
    public String getProductTitleText() {
        return title.getText();
    }

    @Override
    public IosCartPage addProductToBag(String size) {
        chooseSize(size);
        addToBagButton.click();
        popupCloseButton.click();
        header.clickBagButton();
        return new IosCartPage(getDriver());
    }
}