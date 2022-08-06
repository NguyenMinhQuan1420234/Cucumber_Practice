package com.tms.cucumber.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.tms.cucumber.steps.StepHooks.driver;


public class BasePage {

    public WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND"))));;

    public void navigate(String url) {
        driver.get(System.getProperty("BASE_URL") + url);
    }
    public Select elementSelect(By locator) {
        WebElement selectElement = waitForElementToBeClickable(locator);
        Select selectObject = new Select(selectElement);
        return selectObject;
    }

    public void inputText(By locator, String text) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(text);
    }

    public void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    public String getAttribute(By locator, String attribute) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getAttribute(attribute);
    }

    public String getText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();
    }

    public List<WebElement> waitForListOfElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void zoomOutWeb(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        // Actions action = new Actions(driver);
        // action.keyDown(Keys.CONTROL);
        // action.sendKeys(Keys.SUBTRACT);
        // action.perform();
        element.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
    }

    public void moveToElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static ArrayList<String> getTextOfElements(By locator, Boolean moveToElement) {
        List<WebElement> elements = findElements(locator);
        ArrayList<String> result = new ArrayList<>();
        for (WebElement element : elements) {
            if (moveToElement == Boolean.TRUE) {
                Actions actionChains = new Actions(driver);
                actionChains.moveToElement(element).perform();
            }
            result.add(element.getText());
        }
        return result;
    }
    public void elementSelectByIndex(By locator, int number) {
        Select element = elementSelect(locator);
        element.selectByIndex(number);
    }
    public void elementSelectByValue(By locator, String value) {
        Select element = elementSelect(locator);
        element.selectByValue(value);
    }
    public void elementSelectByVisibleText(By locator, String text) {
        clickElement(locator);
        Select element = elementSelect(locator);
        element.selectByVisibleText(text);
    }
    public boolean isElementDisplayed(By locator) {
        try {
            waitForElementToBeVisible(locator);
            return true;
        }
        catch(TimeoutException e)
        {
            return false;
        }
    }

    public ArrayList<String> getTextOfListElement(By locator) {
         List<WebElement> Elements = waitForListOfElementToBeVisible(locator);
         ArrayList<String> list = new ArrayList<>();
         for(WebElement element: Elements) {
             list.add(element.getText());
         }
         return list;
    }
    public boolean isElementClickable(By locator) {
        try {
            waitForElementToBeClickable(locator);
            return true;
        }
        catch(TimeoutException e) {
            return false;
        }
    }
    public String getTextOfElementAttribute(By locator, String tag) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getAttribute(tag);
    }
}

