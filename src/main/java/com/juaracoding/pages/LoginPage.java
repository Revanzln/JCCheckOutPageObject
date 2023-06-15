package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath= "//a[normalize-space()='My Account']")
    WebElement btnAcc;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnlogin;
    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement dashboardTxt;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btnLogout;
    @FindBy(xpath = "//strong[normalize-space()='ERROR']")
    WebElement invalidLogin;
    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnlogin.click();
    }
    public void logout(){ 
        btnLogout.click();
    }

    public String getTxtDashboard(){
        return dashboardTxt.getText();
    }

    public String getTxtErrorLogin(){
        return invalidLogin.getText();
    }
}
