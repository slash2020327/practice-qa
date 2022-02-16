package com.solvd.practiceqa.web.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchPageBase chooseOption(String title);

    public abstract SearchPageBase sortSearch();

    public abstract List<Integer> getResultPrices();

    public abstract List<String> getResultTitles();

    public abstract SearchPageBase searchInput(String text);
}
