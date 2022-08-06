package com.tms.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateProjectPage extends BasePage {
    /**---------------Locator-----------**/
    // Search Page Button
    private static final By BTN_DROPDOWN_PROJECT = By.xpath("//a[contains(text(),'Projects')]");
    private static final By OPT_CREATE_PROJECT = By.xpath("//a[contains(text(),'Create Project')]");
    private static final By OPT_SEARCH_PROJECT = By.xpath("//a[contains(text(),'Search Project')]");

    // Create Project Form
    private static final By TXT_PROJECT_NAME = By.id("name");
    private static final By DDL_PROJECT_TYPE = By.id("projecttype");
    private static final By DDL_PROJECT_STATUS = By.id("status");
    private static final By DDL_START_DATE = By.cssSelector("input[name='sdate']");
    private static final By DDL_END_DATE = By.cssSelector("input[name='edate']");
    private static final By TXT_SIZEDAY = By.id("sizeday");
    private static final By DDL_LOCATION = By.id("location");
    private static final By DDL_PROJECT_MANAGER = By.id("projectManager");
    private static final By DDL_DELIVERY_MANAGER = By.id("deliveryManager");
    private static final By DDL_ENGAGEMENT_MANAGER = By.id("engagementManager");
    private static final By TXT_SHORT_DESCRIPTION = By.id("shortDescription");
    private static final By TXT_LONG_DESCRIPTION = By.id("longDescription");
    private static final By TXT_TECHNOLOGIES = By.id("technologies");
    private static final By TXT_CLIENTNAME = By.id("clientName");
    private static final By DDL_CLIENT_INDUSTRY = By.id("clientindustry");
    private static final By TXT_CLIENT_DESCRIPTION = By.id("clientdescription");
    private static final By BTN_CREATE = By.cssSelector("project-create button[type='submit']");
    private static final By BTN_CANCEL = By.xpath("//button[@ng-click='pcC.cancel()']");

    // Delete Project information
    private static final By BTN_DELETE = By.xpath("//button[text()='Delete']");
    private static final By BTN_YES = By.xpath("//button[@ng-click='piC.deleteProject()']");
    private static final By ALT_MSG = By.xpath("//span[@data-notify='message']");

    /**---------------Method-----------**/

    public void clickCreateProjectOptionFromDropdownList() {
        clickElement(BTN_DROPDOWN_PROJECT);
        clickElement(OPT_CREATE_PROJECT);
    }

    public void clickCreateButton() {
        clickElement(BTN_CREATE);
    }

    public void clickCancelButton() {
        clickElement(BTN_CANCEL);
    }

    public void deleteProject() {
        clickElement(BTN_DELETE);
        clickElement(BTN_YES);
        waitForElementToBeVisible(ALT_MSG);
    }


    public void inputTextBox(By locator, String text) {
        inputText(locator, text);
    }


    public void inputProjectName(String text) {
        inputTextBox(TXT_PROJECT_NAME, text);
    }
    public void inputSizeday(Integer day) {
        inputTextBox(TXT_SIZEDAY, Integer.toString(day));
    }
    public void inputShortDescription(String text) {
        inputTextBox(TXT_SHORT_DESCRIPTION, text);
    }
    public void inputLongDescription(String text) {
        inputTextBox(TXT_LONG_DESCRIPTION, text);
    }
    public void inputTechnologies(String text) {
        inputTextBox(TXT_TECHNOLOGIES, text);
    }
    public void inputClientname(String text) {
        inputTextBox(TXT_CLIENTNAME, text);
    }
    public void inputClientDescription(String text) {
        inputTextBox(TXT_CLIENT_DESCRIPTION, text);
    }
    public void selectProjectStatus(String text) {
        elementSelectByVisibleText(DDL_PROJECT_STATUS,text);
    }
    public void selectProjectType(String text) {
        elementSelectByVisibleText(DDL_PROJECT_TYPE,text);
    }
    public void selectProjectLocation(String text) {
        elementSelectByVisibleText(DDL_LOCATION,text);
    }
    public void selectProjectManager(String text) {
        elementSelectByVisibleText(DDL_PROJECT_MANAGER,text);
    }
    public void selectProjectDelieveryManager(String text) {
        elementSelectByVisibleText(DDL_DELIVERY_MANAGER,text);
    }
    public void selectProjectEngagementManager(String text) {
        elementSelectByVisibleText(DDL_ENGAGEMENT_MANAGER,text);
    }
    public void selectProjectClientIndustry(String text) {
        elementSelectByVisibleText(DDL_CLIENT_INDUSTRY,text);
    }


}

