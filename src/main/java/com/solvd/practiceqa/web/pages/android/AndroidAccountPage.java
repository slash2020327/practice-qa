package com.solvd.practiceqa.web.pages.android;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.practiceqa.web.components.android.AndroidHeader;
import com.solvd.practiceqa.web.pages.AccountPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountPageBase.class)
public class AndroidAccountPage extends AccountPageBase {

    @FindBy(xpath = "//div[contains(@class, 'header-mobile')]")
    protected AndroidHeader header;

    @FindBy(xpath = "//h1[contains(@class, heading)]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[@role='tab']")
    private List<ExtendedWebElement> accountLinks;

    public AndroidAccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getEnvArg("base_url") + "/my-account");
    }
}
