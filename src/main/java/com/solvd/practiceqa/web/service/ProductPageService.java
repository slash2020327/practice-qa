package com.solvd.practiceqa.web.service;

import com.solvd.practiceqa.web.pages.ProductPage;
import com.solvd.practiceqa.web.pages.ShoppingCartPage;
import com.solvd.practiceqa.web.util.WaitUtil;
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

    public String getProductTitleText() {
        return productPage.getTitle().getText();
    }

    public void openProductPage() {
        productPage.open();
    }

    public void openCartPage() {
        shoppingCartPage.open();
    }

    public ShoppingCartPage addProductToBag(String size) {
        productPage.chooseSize(size);
        productPage.click(productPage.getAddToBagButton());
        WaitUtil.waitVisibility(productPage.getDriver(), productPage.getPopupCloseButton());
        productPage.click(productPage.getPopupCloseButton());
        productPage.click(productPage.getBagButton());
        return shoppingCartPage;
    }

    public String getLastProductTitle() {
        List<WebElement> webTitles = shoppingCartPage.getProductTitle();
        WebElement lastProductTitle = webTitles.get(webTitles.size() - 1);
        return lastProductTitle.getText();
    }
}
