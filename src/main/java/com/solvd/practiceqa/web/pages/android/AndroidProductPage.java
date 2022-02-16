package com.solvd.practiceqa.web.pages.android;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.android.AndroidHeader;
import com.solvd.practiceqa.web.pages.CartPageBase;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class AndroidProductPage extends ProductPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected AndroidHeader header;

    @FindBy(xpath = "//h1[contains(@class,'heading')]/span")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[contains(@class, 'size')]")
    private List<ExtendedWebElement> sizeGrid;

    @FindBy(xpath = "//button[@title='Add To Bag']")
    private ExtendedWebElement addToBagButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupCloseButton;

    public AndroidProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/ultraboost-22-shoes/GX5592.html");
    }

    @Override
    public void chooseSize(String size) {
        ExtendedWebElement chosenSize;
        chosenSize = sizeGrid.stream()
                .filter(item -> size.equals(item.getText()))
                .findFirst()
                .get();
        chosenSize.click();
    }

    @Override
    public String getProductTitleText() {
        return title.getText();
    }

    @Override
    public AndroidCartPage addProductToBag(String size) {
        chooseSize(size);
        addToBagButton.click();
        popupCloseButton.click();
        header.clickBagButton();
        return new AndroidCartPage(getDriver());
    }
}
