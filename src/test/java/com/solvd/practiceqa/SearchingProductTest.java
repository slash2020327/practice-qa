package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.AbstractPage;
import com.solvd.practiceqa.web.pages.ProductSearchingPage;
import com.solvd.practiceqa.web.service.ConfigService;
import com.solvd.practiceqa.web.service.DriverService;
import com.solvd.practiceqa.web.service.ProductSearchService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchingProductTest {

    private static WebDriver driver;
    private static ProductSearchService productSearchService;

    @BeforeTest
    public void beforeSearching() {
        new ConfigService();
        driver = DriverService.driverInit();
        productSearchService = new ProductSearchService(driver);
    }

    @Test
    public void sortingPriceTest() {
        List<WebElement> prices = productSearchService.sortSearch();
        List<Integer> intPrices = productSearchService.getResultPrices(prices);
        for (int i = 1; i > intPrices.size(); i++) {
            Assert.assertTrue(intPrices.get(i)<= intPrices.get(i-1), "Sorting isn't working right");
        }
    }

    @DataProvider(name = "searchDataProvider")
    public Object[][] searchData() {
        return new Object[][]
                {{"jacket"}, {"shoes"}};
    }

    @Test(dataProvider = "searchDataProvider")
    public void searchTest(String searchText) {
        ProductSearchingPage productSearchingPage =
                productSearchService.searchInput(searchText);
        AbstractPage.sleep(8);
        List<WebElement> productTitles = productSearchingPage.getProductTitles();
        List<String> resultTitles = productSearchService.getResultTitles(productTitles);
        SoftAssert sa = new SoftAssert();
        resultTitles.
                forEach(resultTitle -> sa.assertTrue(resultTitle.contains(searchText), "Searching exception"));
        sa.assertAll();
    }

    @AfterTest
    public void afterSearching() {
        driver.quit();
    }
}
