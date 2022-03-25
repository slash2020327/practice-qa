package com.solvd.practiceqa;

import com.solvd.practiceqa.util.ProxyUtil;
import com.solvd.practiceqa.web.pages.ProductPageBase;
import com.solvd.practiceqa.web.pages.SearchPageBase;
import com.solvd.practiceqa.web.service.TestDataService;
import com.solvd.practiceqa.web.service.VerifyTitle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SearchingProductTest extends AbstractTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(SearchingProductTest.class);
    private static SearchPageBase searchPage;
    private static ProductPageBase productPage;
    private ConcurrentHashMap<Long, ProxyUtil> proxyServerUtilMap = new ConcurrentHashMap<>();

    @BeforeClass
    public void beforeSearching() {
        searchPage = initPage(getDriver(), SearchPageBase.class);
        productPage = initPage(getDriver(), ProductPageBase.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        proxyServerUtilMap.put(Thread.currentThread().getId(), new ProxyUtil(TestDataService.getValue("title")));
        LOGGER.info("Current thread (beforeMethod): " + Thread.currentThread().getId());
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
                { { "jacket" } };
    }

    @Test(dataProvider = "searchDataProvider")
    public void searchTest(String searchText) {
        searchPage.open();
        searchPage.searchInput(searchText);
        List<String> resultTitles = searchPage.getResultTitles();
        VerifyTitle vt = new VerifyTitle();
        proxyServerUtilMap.get(Thread.currentThread().getId()).showHarLog();
        vt.apply(resultTitles, searchText);
    }

    @Test
    public void clickProduct() {
        searchPage.open();
        productPage = searchPage.clickProductByTitle(TestDataService.getValue("title"));
        System.out.println();
    }

    @AfterMethod
    public void afterMethod() {
        proxyServerUtilMap.get(Thread.currentThread().getId()).showHarLog();
        proxyServerUtilMap.remove(Thread.currentThread().getId());
    }
}
