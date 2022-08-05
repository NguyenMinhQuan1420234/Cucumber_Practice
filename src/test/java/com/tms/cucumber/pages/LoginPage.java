package com.tms.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    /**---------------Locator-----------**/
    public static final By TXT_USERNAME = By.id("username");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By CHK_REMEMBER = By.id("remember");
    public static final By BTN_LOGIN = By.cssSelector("input[value='Login']");
    public static final By LNK_FORGOT_PASSWORD = By.linkText("Forgot the password?");
    public final String RQR_MSG = "This is a required field.";
    public final String ERR_MSG = "The Username or Password you entered is incorrect";

    /**---------------Method-----------**/

    public void inputUsername(String username) {
        inputText(TXT_USERNAME, username);
    }

    public void inputPassword(String password) {
        inputText(TXT_PASSWORD, password);
    }

    public void clickLoginBtn() {
        clickElement(BTN_LOGIN);
    }

    public void clickForgotPasswordLink() {
        clickElement(LNK_FORGOT_PASSWORD);
    }

}
