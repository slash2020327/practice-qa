package com.solvd.practiceqa.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AdidasPage {

    @FindBy(xpath = "//div[contains(@class,'sidebar')]//h1")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[contains(@class, 'size')]")
    private List<ExtendedWebElement> sizeGrid;

    @FindBy(xpath = "//button[@title='Add To Bag']")
    private ExtendedWebElement addToBagButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupCloseButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/ultraboost-22-shoes/GX5592.html");
    }

    public void chooseSize(String size) {
        ExtendedWebElement chosenSize;
        chosenSize = sizeGrid.stream()
                .filter(item -> size.equals(item.getText()))
                .findFirst()
                .get();
        chosenSize.click();
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

    public ExtendedWebElement getPageTitle() {
        return title;
    }
}
