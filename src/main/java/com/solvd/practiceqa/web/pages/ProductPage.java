package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'sidebar')]//h1")
    WebElement title;

    @FindBy(xpath = "//button[contains(@class, 'size')]")
    List<WebElement> sizeGrid;

    @FindBy(xpath = "//button[@title='Add To Bag']")
    WebElement addToBagButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    WebElement popupCloseButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage(WebDriver driver, String path) {
        super(driver);
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL);
        setUrl(pageUrl + path);
    }

    public void chooseSize(String size) {
        WebElement chosenSize;
        chosenSize = sizeGrid.stream()
                .filter(item -> size.equals(item.getText()))
                .findFirst()
                .get();
        click(chosenSize);
    }

    public List<WebElement> getSizeGrid() {
        return sizeGrid;
    }

    public WebElement getAddToBagButton() {
        return addToBagButton;
    }

    public WebElement getPopupCloseButton() {
        return popupCloseButton;
    }

    public WebElement getTitle() {
        return title;
    }
}
