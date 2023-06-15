package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.pages.CheckOutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCheckOutPage {
    static WebDriver driver;
    static ProductPage productPage;
    static CheckOutPage checkOutPage;
    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        productPage = new ProductPage();
        checkOutPage = new CheckOutPage();
    }

    @AfterClass
    public void closeBrowser() {
        DriverSingleton.delay(2);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void addToCart(){
      productPage.product("Black","36");
        Assert.assertEquals(productPage.txtAddedToCart(),"View cart");
    }

    @Test(priority = 2)
    public void validCheckout(){
        checkOutPage.checkout("Revan", "Shop", "Juara Coding", "Jakarta", "Senayan", "Jakarta", "156756", "0877878688", "Please send my order");
        Assert.assertEquals(checkOutPage.validCheck(),"Thank you for order");
    }

}
