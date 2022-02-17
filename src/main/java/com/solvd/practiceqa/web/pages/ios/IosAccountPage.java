package com.solvd.practiceqa.web.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.ios.IosHeader;
import com.solvd.practiceqa.web.pages.AccountPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AccountPageBase.class)
public class IosAccountPage extends AccountPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected IosHeader header;

    @FindBy(xpath = "//h1[contains(@class, heading)]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[@role='tab']")
    private List<ExtendedWebElement> accountLinks;

    public IosAccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url") + "/my-account");
    }
}
