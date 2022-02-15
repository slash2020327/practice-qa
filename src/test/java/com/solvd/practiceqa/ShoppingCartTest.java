package com.solvd.practiceqa;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.practiceqa.web.pages.desktop.CartPage;
import com.solvd.practiceqa.web.service.ProductPageService;
import com.solvd.practiceqa.web.service.TestDataService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingCartTest extends AbstractTest implements IAbstractTest {

    private static ProductPageService productPageService;

    @BeforeClass
    public void beforeCartTest() {
        productPageService = new ProductPageService(getDriver());
    }

    @Test
    public void addToBagTest() {
        productPageService.openProductPage();
        String productTitle = productPageService.getProductTitleText();
        CartPage shoppingCartPage =
                productPageService.addProductToBag(TestDataService.getValue("size"));
        Assert.assertTrue(shoppingCartPage.isPageOpened(), "Cart isn't opened");
        String cartTitle = productPageService.getLastProductTitle();
        Assert.assertTrue(cartTitle.contains(productTitle), "The product isn't added to cart");
    }
}
