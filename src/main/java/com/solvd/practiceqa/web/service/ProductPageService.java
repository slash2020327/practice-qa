package com.solvd.practiceqa.web.service;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.desktop.CartProduct;
import com.solvd.practiceqa.web.pages.desktop.ProductPage;
import com.solvd.practiceqa.web.pages.desktop.CartPage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPageService {

    private final ProductPage productPage;
    private final CartPage shoppingCartPage;

    public ProductPageService(WebDriver driver) {
        productPage = new ProductPage(driver);
        shoppingCartPage = new CartPage(driver);
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

    public CartPage addProductToBag(String size) {
        productPage.chooseSize(size);
        productPage.getAddToBagButton().click();
        productPage.getPopupCloseButton().click();
        productPage.getHeader().getBagButton().click();
        return shoppingCartPage;
    }

    public String getLastProductTitle() {
        List<CartProduct> products = shoppingCartPage.getProducts();
        List<ExtendedWebElement> webTitles = products.stream()
                .map(CartProduct::getProductTitle)
                .collect(Collectors.toList());
        ExtendedWebElement lastProductTitle = webTitles.get(webTitles.size() - 1);
        return lastProductTitle.getText();
    }
}
