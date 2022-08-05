package com.tms.cucumber.pages.shared;

import com.tms.cucumber.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePickerPage extends BasePage {

    public static final By BTN_SDATE_PICKER = By.xpath("//button[@ng-click='pcC.openSDatePicker()']");
    public static final By BTN_EDATE_PICKER = By.xpath("//button[@ng-click='pcC.openEDatePicker()']");
    // public static final By BTN_TODAY = By.xpath("//button[text()='Today']");
    // public static final By BTN_CLEAR = By.xpath("//button[text()='Clear']");
    // public static final By BTN_CLOSE = By.xpath("//button[text()='Close']");
    public static final By BTN_MONTH_YEAR = By.xpath("//button[@ng-disabled='datepickerMode === maxMode']");
    public static final By BTN_NEXT_20_YEAR_BUTTON = By.xpath("//button[@ng-click='move(1)']");
    public static final By BTN_PREVIOUS_20_YEAR_BUTTON = By.xpath("//button[@ng-click='move(-1)']");
    public static final By BTN_YEAR_RANGE = By.cssSelector("strong.ng-binding");

    public static final By DATE_PICKER_YEAR(String text) { // YYYY
        return By.xpath(String.format("//span[text()='%s']", text));
    }

    public static final By DATE_PICKER_MONTH(String text) { // MM
        return By.xpath(String.format("//span[text()='%s']", text));
    }

    public static final By DATE_PICKER_DAY(String text) { // DD
        return By.xpath(String.format("//span[@class='ng-binding'][text()='%s']", text));
    }

    public String[] yearRange() { // "2022 - 2042"
        return getText(BTN_YEAR_RANGE).split(" - ");
    }

    public void sdayOpen() {
        clickElement(BTN_SDATE_PICKER); // open start DatePicker

    }

    public void edayOpen() {
        clickElement(BTN_EDATE_PICKER); // open end DatePicker

    }

    public void datePicker(String year, String month, String day) {

        clickElement(BTN_MONTH_YEAR); // go to Month
        clickElement(BTN_MONTH_YEAR); // go to year range

        String[] yearRange = yearRange();
        // System.out.println(yearRange[0] + " and " + yearRange[1]);
        // int a = Integer.parseInt(year);
        // System.out.println(a);

        while(!((Integer.parseInt(year) > Integer.parseInt(yearRange[0]) &&
                (Integer.parseInt(year))< Integer.parseInt(yearRange[1])))) {
            if (Integer.parseInt(year) < Integer.parseInt(yearRange[0]))
                clickElement(BTN_PREVIOUS_20_YEAR_BUTTON);
            else
                clickElement(BTN_NEXT_20_YEAR_BUTTON);
            yearRange = yearRange();
        }

        clickElement(DATE_PICKER_YEAR(year));
        clickElement(DATE_PICKER_MONTH(month));
        clickElement(DATE_PICKER_DAY(day));

    }


}
