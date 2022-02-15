package com.solvd.practiceqa.web.service;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.pages.ProductPage;
import com.solvd.practiceqa.web.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductPageService {

    private final ProductPage productPage;
    private final ShoppingCartPage shoppingCartPage;

    public ProductPageService(WebDriver driver) {
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    public String getProductTitleText() {
        return productPage.getPageTitle().getText();
    }

    public void openProductPage() {
        productPage.open();
    }

    public void openCartPage() {
        shoppingCartPage.open();
    }

    public ShoppingCartPage addProductToBag(String size) {
        productPage.chooseSize(size);
        productPage.getAddToBagButton().click();
        productPage.getPopupCloseButton().click();
        productPage.getHeader().getBagButton().click();
        return shoppingCartPage;
    }

    public String getLastProductTitle() {
        List<ExtendedWebElement> webTitles = shoppingCartPage.getProducts();
        ExtendedWebElement lastProductTitle = webTitles.get(webTitles.size() - 1);
        return lastProductTitle.getText();
    }
}
