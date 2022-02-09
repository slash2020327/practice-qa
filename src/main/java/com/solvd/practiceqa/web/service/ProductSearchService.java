package com.solvd.practiceqa.web.service;

import com.solvd.practiceqa.web.pages.AbstractPage;
import com.solvd.practiceqa.web.pages.HomePage;
import com.solvd.practiceqa.web.pages.ProductSearchingPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductSearchService {

    private final ProductSearchingPage productSearchingPage;
    private final HomePage homePage;

    public ProductSearchService(WebDriver driver) {
        productSearchingPage = new ProductSearchingPage(driver);
        homePage = new HomePage(driver);
    }

    public List<WebElement> sortSearch() {
        productSearchingPage.open();
        productSearchingPage.sortButtonClick();
        productSearchingPage.chooseOption("Price (high - low)");
        AbstractPage.sleep(6);
        return productSearchingPage.getProductPrice();
    }

    public List<Integer> getResultPrices(List<WebElement> prices) {
        return prices.stream()
                .map(WebElement::getText)
                .map(text -> text.substring(1).replaceAll("[,]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String> getResultTitles(List<WebElement> titles) {
        return titles.stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public ProductSearchingPage searchInput(String text) {
        homePage.open();
        WebElement searchField = homePage.getSearchField();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
        return productSearchingPage;
    }
}
