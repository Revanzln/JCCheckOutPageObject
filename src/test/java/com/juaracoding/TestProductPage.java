package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProductPage {
    static WebDriver driver;
    static ProductPage productPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        productPage = new ProductPage();
    }
    @AfterClass
    public void closeBrowser(){
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void addToCart(){
        productPage.product("Black","36");
        Assert.assertEquals(productPage.txtAddedToCart(),"View cart");
    }
}
