package com.solvd.practiceqa.web.service;

import com.solvd.practiceqa.web.pages.AbstractPage;
import com.solvd.practiceqa.web.pages.ProductPage;
import com.solvd.practiceqa.web.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageService {

    private final ProductPage productPage;
    private final ShoppingCartPage shoppingCartPage;

    public ProductPageService(WebDriver driver) {
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    public String getProductTitle() {
        return productPage.getTitle().getText();
    }

    public void productPageOpen() {
        productPage.open();
    }

    public void cartPageOpen() {
        shoppingCartPage.open();
    }

    public ShoppingCartPage addProductToBag() {
        productPage.chooseSize("8");
        productPage.clickAddToBAgButton();
        AbstractPage.sleep(3);
        productPage.getPopupCloseButton().click();
        productPage.goToBag();
        return shoppingCartPage;
    }

    public String getLastProductTitle() {
        List<WebElement> webTitles = shoppingCartPage.getProductTitle();
        WebElement lastProductTitle = webTitles.get(webTitles.size() - 1);
        return lastProductTitle.getText();
    }
}
