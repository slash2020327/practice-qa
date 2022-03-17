package com.solvd.practiceqa;

import com.solvd.practiceqa.web.pages.SearchPageBase;
import com.solvd.practiceqa.web.service.VerifyTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchingProductTest extends AbstractTest {

    private static SearchPageBase searchPage;

    @BeforeClass
    public void beforeSearching() {
        searchPage = initPage(getDriver(), SearchPageBase.class);
    }

    @Test
    public void sortingPriceTest() {
        searchPage.open();
        searchPage.sortSearch();
        List<Integer> intPrices = searchPage.getResultPrices();
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
        searchPage.open();
        searchPage.searchInput(searchText);
        List<String> resultTitles = searchPage.getResultTitles();
        VerifyTitle vt = new VerifyTitle();
        vt.apply(resultTitles, searchText);
    }
}
