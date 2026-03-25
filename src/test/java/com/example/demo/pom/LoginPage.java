package com.example.demo.pom;

// Implementation of the POM Design Pattern
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// This is class is representing the login page
public class LoginPage {
    
    private WebDriver driver;

    // The elements in the page as attributs
    private By loginInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("submit");

    private By errorSection = By.id("error");

    public LoginPage(WebDriver givenDriver) {
        this.driver = givenDriver;
    }

    // Actions as methods, [Page Objects should contain actions, not test cases].
    public void login(String login, String password) {
        this.driver.findElement(this.loginInput).sendKeys(login);
        this.driver.findElement(this.passwordInput).sendKeys(password);
        this.driver.findElement(this.loginButton).click();
    }

    public String errorSectionContent() {
        return this.driver.findElement(this.errorSection).getText();
    }

}
