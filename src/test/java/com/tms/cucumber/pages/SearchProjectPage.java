package com.tms.cucumber.pages;

import java.util.List;
import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import static com.tms.cucumber.steps.StepHooks.driver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchProjectPage extends BasePage {
    // drop down list Project option
    public static final By BTN_DROPDOWN_PROJECT = By.xpath("//a[contains(text(),'Projects')]");
    public static final By OPT_CREATE_PROJECT = By.xpath("//a[contains(text(),'Create Project')]");
    public static final By OPT_SEARCH_PROJECT = By.xpath("//a[contains(text(),'Search Project')]");
    // Search options
    public static final By TXT_PROJECT_NAME = By.xpath("//input[@ng-model='input.projectname']");
    public static final By DDL_LOCATION = By.id("ddl-location");
    public static final By DDL_PROJECT_TYPE = By.id("ddl-projecttype");
    public static final By BTN_SEARCH = By.xpath("//search-project//button[@ng-click='search(input)']");

    public static final By SEARCH_RESULT_NAME = By.xpath("//a[contains(text(),'%s')]");
    public static final By HTML = By.cssSelector("html[ng-app='TMS']");
    public static final By TITLE = By.xpath("//b[@class='ng-binding']");
    public static final By ITEMS_PER_PAGE = By.xpath("//div[@ui-view='projectsresult']//tr[@total-items]");
    public static final By PROJECT_NAME_TABLE_DATA = By.xpath("//div[@ui-view='projectsresult']//a");
    public static final By PROJECT_TYPE_TABLE_DATA = By.xpath("//div[@ui-view='projectsresult']//td[3]");
    public static final By PROJECT_LOCATION_TABLE_DATA = By.xpath("//div[@ui-view='projectsresult']//td[6]");
    public static final By TOTAL_PAGE = By.xpath("(//a[@ng-click='setCurrent(pageNumber)'])[last()]");
    public static final By BTN_NEXT_PAGE = By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']");
    public static final By BTN_NEXT_PAGE_STATUS = By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']/..");

    public void clickSearchMenu() {
        clickElement(BTN_DROPDOWN_PROJECT);
        clickElement(OPT_SEARCH_PROJECT);
    }

    public void inputSearchProjectName(String text) {
        inputText(TXT_PROJECT_NAME, text);
    }
    public void selectLocation(String text) {
        elementSelectByVisibleText(DDL_LOCATION, text);
    }
    public void selectType(String text) {
        elementSelectByVisibleText(DDL_PROJECT_TYPE, text);
    }

    public void clickSearchButton() {
        clickElement(BTN_SEARCH);
    }

    public List<WebElement> listOfProjectName(By locator) {
        return (List<WebElement>) waitForListOfElementToBeVisible(locator);
    }

    public void verifyDataFromTable(List<String> data, String searchCriteria) {
        for(String item: data) {
            item = searchCriteria;
        }
    }

    public void verifyProjectInDataTable(String expectedProjectName, String expectedLocation, String expectedType) {

        while(isElementDisplayed(ITEMS_PER_PAGE)) {
            isElementDisplayed(PROJECT_NAME_TABLE_DATA);
            List<String> listNameOfProjects = getTextOfListElement(PROJECT_NAME_TABLE_DATA);
            List<String> listProjectLocation = getTextOfListElement(PROJECT_LOCATION_TABLE_DATA);
            List<String> listProjectType = getTextOfListElement(PROJECT_TYPE_TABLE_DATA);

            for(String name: listNameOfProjects) {
                assertThat(
                    "verify project name match criteria: ",
                    name.toLowerCase(),
                    containsString(expectedProjectName)
                );
            }
            if(!(expectedLocation.equals("All"))) {
                for(String location: listProjectLocation) {
                    assertThat(
                            "verify project location match criteria: ",
                            location,
                            equalTo(expectedLocation)
                    );
                }
            }
            if(!(expectedLocation.equals("All"))) {
                for (String type : listProjectType) {
                    assertThat(
                            "verify project type match criteria: ",
                            type,
                            equalTo(expectedType)
                    );
                }
            }

            if(isElementDisplayed(BTN_NEXT_PAGE)) {
                if(getTextOfElementAttribute(BTN_NEXT_PAGE_STATUS, "class").contains("disabled"))
                    break;
                else
                    clickElement(BTN_NEXT_PAGE);
            }
            else
                break;
        }


    }




    public void zoomOutSearchPage() throws AWTException {
        WebElement textboxSearchProject = driver.findElement(TXT_PROJECT_NAME);
        Actions a = new Actions(driver);
        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(textboxSearchProject);
        // driver.manage().window()
        a.moveToElement(textboxSearchProject).click();
        a.sendKeys(Keys.EQUALS);
        a.keyDown(Keys.LEFT_CONTROL);
        a.scrollFromOrigin(scrollOrigin, 120, 0);
        a.keyDown(Keys.SUBTRACT);
        a.keyUp(Keys.SUBTRACT);
        a.perform();

    }

    public void zoom() {
        zoomOutWeb(HTML);
    }
}
