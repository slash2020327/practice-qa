package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.TestDataService;
import com.solvd.practiceqa.web.util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ProductSearchingPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'controllers')]//button[contains(@class,'select')]//span[contains(@class,'text')]")
    private WebElement sortButton;

    @FindBy(xpath = "//div[contains(@class,'sortby')]//div[contains(@class,'options')]//button")
    private List<WebElement> sortingOptions;

        @FindBy(xpath = "//div[contains(@class,'grid-item')]//div[contains(@class, 'price')]/div[1]")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//p[contains(@class,'product-card') and contains(@class,'title')]")
    private List<WebElement> productTitles;

    public ProductSearchingPage(WebDriver driver) {
        super(driver);
    }

    public ProductSearchingPage(WebDriver driver, String path) {
        super(driver);
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL);
        setUrl(pageUrl + path);
    }

    public void chooseOption(String title) {
        WebElement option = sortingOptions.stream()
                .filter(webElement -> webElement.getText().equals(title))
                .findFirst()
                .get();
        click(option);
    }

    public List<WebElement> sortSearch() {
        open();
        click(sortButton);
        String sortOption = TestDataService.getValue("sorting_option");
        chooseOption(sortOption);
        WaitUtil.sleep(5);
        return getProductPrice();
    }

    public List<Integer> getResultPrices() {
        List<WebElement> prices = sortSearch();
        return prices.stream()
                .map(WebElement::getText)
                .map(text -> text.substring(1).replaceAll("[,]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String> getResultTitles() {
        List<WebElement> titles = getProductTitles();
        return titles.stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public void searchInput(String text) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        WebElement searchField = homePage.getSearchField();
        insert(searchField, text);
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
