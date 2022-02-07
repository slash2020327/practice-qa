package com.solvd.practiceqa.web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v97.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    private final WebDriver driver;
    private static final String URL = "https://www.adidas.com/us/account-login";

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
        PageFactory.initElements(driver, this);
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
        passwordField.click();
        passwordField.sendKeys(Keys.ENTER);
    }

    public AccountPage login(String email, String pass) {
        printEmail(email);
        printPassword(pass);
        loginButton.click();
        return new AccountPage(driver);
    }
}
