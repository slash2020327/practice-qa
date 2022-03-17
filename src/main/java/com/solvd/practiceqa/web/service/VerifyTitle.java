package com.solvd.practiceqa.web.service;

import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.function.BiFunction;

public class VerifyTitle implements BiFunction<List<String>, String, Void> {

    @Override
    public Void apply(List<String> resultTitles, String searchText) {
        SoftAssert sa = new SoftAssert();
        resultTitles.
                forEach(resultTitle -> sa.assertTrue(resultTitle.contains(searchText), "Searching exception"));
        sa.assertAll();
        return null;
    }
}
