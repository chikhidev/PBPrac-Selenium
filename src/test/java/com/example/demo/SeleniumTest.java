package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        this.driver = new ChromeDriver();
    }

    @Test
    public void urlTest() {
        this.driver.get("https://start.spring.io/");

        String title = this.driver.getTitle();
        assertEquals(title, "Spring Initializr");
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }

}
