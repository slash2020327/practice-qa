package com.solvd.practiceqa.web.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductPage extends ProductPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected Header header;

    @FindBy(xpath = "//h1[contains(@class,'heading')]/span")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[contains(@class, 'size')]")
    private List<ExtendedWebElement> sizeGrid;

    @FindBy(xpath = "//button[@title='Available sizes']")
    private ExtendedWebElement addToBagButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupCloseButton;

    public AndroidProductPage(WebDriver driver) {
        super(driver);
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

    public Header getHeader() {
        return header;
    }

    public ExtendedWebElement getPageTitle() {
        return title;
    }

    public List<ExtendedWebElement> getSizeGrid() {
        return sizeGrid;
    }

    public ExtendedWebElement getAddToBagButton() {
        return addToBagButton;
    }

    public ExtendedWebElement getPopupCloseButton() {
        return popupCloseButton;
    }
}
