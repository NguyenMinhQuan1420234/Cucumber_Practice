package com.tms.cucumber.pages.shared;

import com.tms.cucumber.pages.BasePage;
import org.openqa.selenium.By;

public class NavigationPage extends BasePage {
    /**---------------Locator-----------**/
    private static final By LBL_USERNAME = By.xpath("//img[@id='ava']//..");
    private static final By LBL_PROJECTS = By.xpath("//a[contains(text(),'Projects')]");
    private static final By LBL_CREATE_PROJECT = By.xpath("//a[text()='Create Project']");
    private static final By LBL_SEARCH_PROJECT = By.xpath("//a[text()='Search Project']");

    private static final By IMG_TXT = By.xpath("//a[text()=' Admin2 ']");
    private static final By CLASS_NAME = By.id("userName");
    private static final By ERR_MSG = By.xpath("//p[@ng-message='required']");
    private static final By ERR_MSG_2 = By.xpath("//div[@ng-show='isError']");

    // Search Page
    public static final By SEARCH_RESULT_NAME = By.xpath("//a[contains(text(),'%s')]");
    public static final By BTN_NEXT_PAGE = By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']");
    public static final By BTN_NEXT_PAGE_DISABLE = By.xpath("//li[@class='ng-scope disabled']/a[@ng-click='setCurrent(pagination.current + 1)'']");
    // Create Page
    private By PROJECT_NAME = By.xpath("//label[@for='name']/following-sibling::p");
    /**---------------Method-----------**/

    public String getUsername() {
        return getText(LBL_USERNAME);
    }
    public void clickCreateProject() {
        clickElement(LBL_PROJECTS);
        clickElement(LBL_CREATE_PROJECT);
    }
    public void goToSearchProjectPage() {
        clickElement(LBL_PROJECTS);
        clickElement(LBL_SEARCH_PROJECT);
    }
    public String getProjectName() {
        return getText(PROJECT_NAME);
    }
}

