package com.solvd.practiceqa;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.practiceqa.web.pages.CartPageBase;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import com.solvd.practiceqa.web.service.TestDataService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingCartTest extends AbstractTest implements IAbstractTest {

    private static ProductPageBase productPage;
    private static CartPageBase cartPage;

    @BeforeClass
    public void beforeCartTest() {
        productPage = initPage(getDriver(), ProductPageBase.class);
        cartPage = initPage(getDriver(), CartPageBase.class);
    }

    @Test
    public void addToBagTest() {
        productPage.open();
        String productTitle = productPage.getProductTitleText();
        cartPage = productPage.addProductToBag(TestDataService.getValue("size"));
        Assert.assertTrue(cartPage.isPageOpened(), "Cart isn't opened");
        Runnable cartCheck = (() -> {
            String cartTitle = cartPage.getLastProductTitle();
            Assert.assertTrue(cartTitle.contains(productTitle), "The product isn't added to cart");
        });
        cartCheck.run();
    }
}
