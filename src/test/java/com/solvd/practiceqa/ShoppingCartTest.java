package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.ShoppingCartPage;
import com.solvd.practiceqa.web.service.ProductPageService;
import com.solvd.practiceqa.web.util.WaitUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingCartTest extends AbstractTest {

    private static ProductPageService productPageService;

    @BeforeClass
    public void beforeCartTest() {
        productPageService = new ProductPageService(driver);
    }

    @Test
    public void addToBagTest() {
        productPageService.openProductPage();
        String productTitle = productPageService.getProductTitleText();
        ShoppingCartPage shoppingCartPage =
                productPageService.addProductToBag();
        WaitUtil.sleep(4);
        Assert.assertTrue(shoppingCartPage.getTitle().isDisplayed(), "Cart isn't opened");
        String cartTitle = productPageService.getLastProductTitle();
        Assert.assertEquals(cartTitle, productTitle, "The product isn't added to cart");
    }
}
