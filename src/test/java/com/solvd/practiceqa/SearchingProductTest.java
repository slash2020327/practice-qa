package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.ProductSearchingPage;
import com.solvd.practiceqa.web.util.WaitUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchingProductTest extends AbstractTest {

    private static ProductSearchingPage productSearchingPage;

    @BeforeClass
    public void beforeSearching() {
        productSearchingPage = new ProductSearchingPage(driver);
    }

    @Test
    public void sortingPriceTest() {
        List<Integer> intPrices = productSearchingPage.getResultPrices();
        for (int i = 1; i < intPrices.size(); i++) {
            Assert.assertTrue(intPrices.get(i) <= intPrices.get(i - 1), "Sorting isn't working right");
        }
    }

    @DataProvider(name = "searchDataProvider")
    public Object[][] searchData() {
        return new Object[][]
                { { "jacket" }, { "shoes" } };
    }

    @Test(dataProvider = "searchDataProvider")
    public void searchTest(String searchText) {
        productSearchingPage.searchInput(searchText);
        WaitUtil.sleep(8);
        List<String> resultTitles = productSearchingPage.getResultTitles();
        SoftAssert sa = new SoftAssert();
        resultTitles.
                forEach(resultTitle -> sa.assertTrue(resultTitle.contains(searchText), "Searching exception"));
        sa.assertAll();
    }
}
