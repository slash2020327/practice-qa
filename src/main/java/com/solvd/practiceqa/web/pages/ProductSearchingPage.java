package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductSearchingPage extends AbstractPage{

    @FindBy(xpath = "//div[contains(@class,'secondary-controllers')]//div[contains(@class,'sortby_wrapper')]//button[contains(@class,'dropdown-select')]")
    private WebElement sortButton;

    @FindBy(xpath = "//div[contains(@class,'secondary-controllers')]//div[contains(@class,'sortby_wrapper')]//div[contains(@class,'options')]//li/button")
    private List<WebElement> sortingOptions;

    @FindBy(xpath = "//div[contains(@class,'product-container')]//div[contains(@class,'grid-item')]//div[contains(@class, 'gl-price--')]/div[1]")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//p[contains(@class,'product-card') and contains(@class,'title')]")
    private List<WebElement> productTitles;

    public ProductSearchingPage(WebDriver driver) {
        super(driver);
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL) + "/women-new_arrivals";
        setUrl(pageUrl);
    }

    public void sortButtonClick() {
        sortButton.click();
    }

    public void chooseOption(String title) {
        WebElement option = sortingOptions.stream()
                .filter(webElement -> webElement.getText().equals(title))
                .findFirst()
                .get();
        option.click();
    }

    public WebElement getSortButton() {
        return sortButton;
    }

    public List<WebElement> getSortingOptions() {
        return sortingOptions;
    }

    public List<WebElement> getProductPrice() {
        return productPrice;
    }

    public List<WebElement> getProductTitles() {
        return productTitles;
    }
}
