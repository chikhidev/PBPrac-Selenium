package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.demo.pom.LoginPage;

public class LoginTest {
    
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://practicetestautomation.com/practice-test-login/");
        this.loginPage = new LoginPage(this.driver);
    }

    // This is where they are both wrong
    @Test
    public void testBothWrongInputs() {
        this.loginPage.login("user12", "wpswd");
        assertEquals(this.loginPage.errorSectionContent(), "Your username is invalid!");
    }

    // This is where the username is wrong only
    @Test
    public void testWrongUsername() {
        this.loginPage.login("user14", "Password123");
        assertEquals(this.loginPage.errorSectionContent(), "Your username is invalid!");
    }

    // here only the password is wrong
    @Test
    public void testWrongPassword() {
        this.loginPage.login("student", "passwrod");
        assertEquals(this.loginPage.errorSectionContent(), "Your password is invalid!");
    }

    @AfterMethod
    public void tearDown() {
        try {
            synchronized (this) {
                this.wait(2000);
                if (this.driver != null) this.driver.quit();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
    }

}
