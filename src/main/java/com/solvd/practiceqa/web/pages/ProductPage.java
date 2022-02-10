package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractPage{

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
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL) + "/ultraboost-22-shoes/GX5592.html";
        setUrl(pageUrl);
    }

    public void chooseSize(String size) {
        WebElement chosenSize = null;
        chosenSize = sizeGrid.stream()
                .filter(item -> size.equals(item.getText()))
                .findFirst()
                .get();
        if(chosenSize != null) {
            chosenSize.click();
        }
        else throw new RuntimeException("There is no such size");
    }

    public void clickAddToBAgButton() {
        addToBagButton.click();
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
