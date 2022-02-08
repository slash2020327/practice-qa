package com.solvd.practiceqa.web.pages;

import com.solvd.practiceqa.web.AbstractPage;
import com.solvd.practiceqa.web.service.ConfigService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        String pageUrl = ConfigService.BASE_URL + "/account-login";
        setUrl(pageUrl);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void printEmail(String email) {
        emailField.sendKeys(email);
    }

    public void printPassword(String pass) {
        passwordField.sendKeys(pass);
    }
}
