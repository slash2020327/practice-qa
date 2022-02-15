package com.solvd.practiceqa.web.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.desktop.Header;
import com.solvd.practiceqa.web.pages.SearchPageBase;
import com.solvd.practiceqa.web.service.TestDataService;
import com.solvd.practiceqa.web.util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-bottom')]")
    protected Header header;

    @FindBy(xpath = "//div[contains(@class,'controllers')]//button[contains(@class,'select')]//span[contains(@class,'text')]")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//div[contains(@class,'sortby')]//div[contains(@class,'options')]//button")
    private List<ExtendedWebElement> sortingOptions;

        @FindBy(xpath = "//div[contains(@class,'grid-item')]//div[contains(@class, 'price')]/div[1]")
    private List<ExtendedWebElement> productPrice;

    @FindBy(xpath = "//p[contains(@class,'product-card') and contains(@class,'title')]")
    private List<ExtendedWebElement> productTitles;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/women-new_arrivals");
    }

    @Override
    public void chooseOption(String title) {
        ExtendedWebElement option = sortingOptions.stream()
                .filter(webElement -> webElement.getText().equals(title))
                .findFirst()
                .get();
        option.click();
    }

    @Override
    public List<ExtendedWebElement> sortSearch() {
        open();
        sortButton.click();
        String sortOption = TestDataService.getValue("sorting_option");
        chooseOption(sortOption);
        return getProductPrice();
    }

    @Override
    public List<Integer> getResultPrices() {
        List<ExtendedWebElement> prices = sortSearch();
        return prices.stream()
                .map(ExtendedWebElement::getText)
                .map(text -> text.substring(1).replaceAll("[,]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getResultTitles() {
        List<ExtendedWebElement> titles = getProductTitles();
        return titles.stream()
                .map(ExtendedWebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    @Override
    public void searchInput(String text) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        ExtendedWebElement searchField = homePage.getHeader().getSearchField();
        searchField.type(text);
    }

    public Header getHeader() {
        return header;
    }

    public ExtendedWebElement getSortButton() {
        return sortButton;
    }

    public List<ExtendedWebElement> getSortingOptions() {
        return sortingOptions;
    }

    public List<ExtendedWebElement> getProductPrice() {
        return productPrice;
    }

    public List<ExtendedWebElement> getProductTitles() {
        return productTitles;
    }
}
