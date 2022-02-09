package com.solvd.practiceqa.web.service;

public enum ConfigData {

    BASE_URL("base_url"), BROWSER("browser");

    private final String title;

     ConfigData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
