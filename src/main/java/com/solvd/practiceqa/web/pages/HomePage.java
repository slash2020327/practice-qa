package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.service.ConfigData;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

    public HomePage(WebDriver driver) {
        super(driver);
        String pageUrl = ConfigService.getValue(ConfigData.BASE_URL);
        setUrl(pageUrl);
    }
}
