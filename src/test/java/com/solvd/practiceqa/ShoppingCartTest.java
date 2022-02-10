package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AbstractPage;
import com.solvd.practiceqa.web.pages.ShoppingCartPage;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.DriverService;
import com.solvd.practiceqa.web.service.ProductPageService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingCartTest {

    private static WebDriver driver;
    private static ProductPageService productPageService;

    @BeforeTest
    public void beforeCartTest() {
        new ConfigService();
        driver = DriverService.driverInit();
        productPageService = new ProductPageService(driver);
    }

    @Test
    public void addToBagTest() {
        productPageService.productPageOpen();
        String productTitle = productPageService.getProductTitle();
        ShoppingCartPage shoppingCartPage =
                productPageService.addProductToBag();
        AbstractPage.sleep(4);
        Assert.assertTrue(shoppingCartPage.getTitle().isDisplayed(), "Cart isn't opened");
        String cartTitle = productPageService.getLastProductTitle();
        Assert.assertEquals(cartTitle, productTitle, "The product isn't added to cart");
    }

    @AfterClass
    public void afterCartTest() {
        driver.quit();
    }
}
