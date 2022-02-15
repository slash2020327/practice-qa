package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.desktop.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchingProductTest extends AbstractTest {

    private static SearchPage productSearchingPage;

    @BeforeClass
    public void beforeSearching() {
        productSearchingPage = new SearchPage(getDriver());
    }

    @Test
    public void sortingPriceTest() {
        productSearchingPage.sortSearch();
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
        List<String> resultTitles = productSearchingPage.getResultTitles();
        SoftAssert sa = new SoftAssert();
        resultTitles.
                forEach(resultTitle -> sa.assertTrue(resultTitle.contains(searchText), "Searching exception"));
        sa.assertAll();
    }
}
