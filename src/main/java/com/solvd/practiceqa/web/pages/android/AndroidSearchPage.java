package com.solvd.practiceqa.web.pages.android;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.android.AndroidHeader;
import com.solvd.practiceqa.web.components.desktop.ProductItem;
import com.solvd.practiceqa.web.pages.SearchPageBase;
import com.solvd.practiceqa.web.service.TestDataService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class AndroidSearchPage extends SearchPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected AndroidHeader header;

    @FindBy(xpath = "//div[contains(@class,'filters-icon')]")
    private ExtendedWebElement filterIcon;

    @FindBy(xpath = "//div[contains(@class,'filters-icon')]//span[@title='Sort By']")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//div[contains(@class,'filters-icon')]//li[contains(@class,'sort')]")
    private List<ExtendedWebElement> sortingOptions;

    @FindBy(xpath = "//div[contains(@class,'grid-item')]//div[contains(@class, 'price')]/div[1]")
    private List<ExtendedWebElement> productPrice;

    @FindBy(xpath = "//p[contains(@class,'product-card') and contains(@class,'title')]")
    private List<ExtendedWebElement> productTitles;

    @FindBy(xpath = "//div[contains(@class,'grid-item')]")
    private List<ProductItem> productItems;

    public AndroidSearchPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/women-new_arrivals");
    }

    @Override
    public AndroidSearchPage chooseOption(String title) {
        ExtendedWebElement option = sortingOptions.stream()
                .filter(webElement -> webElement.getText().equalsIgnoreCase(title))
                .findFirst()
                .get();
        option.click();
        return this;
    }

    @Override
    public AndroidSearchPage sortSearch() {
        open();
        filterIcon.click();
        sortButton.click();
        String sortOption = TestDataService.getValue("sorting_option");
        chooseOption(sortOption);
        return this;
    }

    @Override
    public List<Integer> getResultPrices() {
        return productPrice.stream()
                .map(ExtendedWebElement::getText)
                .map(text -> text.substring(1).replaceAll("[,]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getResultTitles() {
        List<ExtendedWebElement> titles = productTitles;
        return titles.stream()
                .map(ExtendedWebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    @Override
    public AndroidSearchPage searchInput(String text) {
        header.inputSearchText(text);
        return this;
    }

    @Override public AndroidProductPage clickProductByTitle(String title) {
        productItems.stream()
                .filter(productItem -> productItem.getTitleText().contains(title))
                .findFirst()
                .get().clickProduct();
        return new AndroidProductPage(getDriver());
    }
}
