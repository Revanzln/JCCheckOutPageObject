package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.chrome.driver", "E:\\JUARA CODING SQA 9\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}