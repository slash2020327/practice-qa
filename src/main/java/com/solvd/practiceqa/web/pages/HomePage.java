package com.solvd.practiceqa.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.WebDriver;

public class HomePage extends AdidasPage {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("base_url"));
    }
}
