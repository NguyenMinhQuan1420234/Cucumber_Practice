package com.tms.cucumber.steps;

import com.tms.cucumber.utils.PropertiesFileUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class StepHooks {
    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll() throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile(System.getProperty("env.properties"));
        PropertiesFileUtil.appendSystemProperties(properties);
    }

    @Before
    public void beforeScenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(System.getProperty("BASE_URL"));
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
