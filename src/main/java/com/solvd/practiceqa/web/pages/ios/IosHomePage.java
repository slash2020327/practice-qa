package com.solvd.practiceqa.web.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.practiceqa.web.components.ios.IosFooter;
import com.solvd.practiceqa.web.components.ios.IosHeader;
import com.solvd.practiceqa.web.pages.HomePageBase;
import com.solvd.practiceqa.web.pages.SearchPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchPageBase.class)
public class IosHomePage extends HomePageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected IosHeader header;

    @FindBy(xpath = "//footer")
    protected IosFooter footer;

    public IosHomePage(WebDriver driver) {
        super(driver);
    }
}
