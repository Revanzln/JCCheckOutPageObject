package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CheckOutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account");
        DriverSingleton.scroll(500);
        LoginPage loginPage = new LoginPage();
        loginPage.login("revan_zn", "Shopqa1122");
         DriverSingleton.delay(2);
        ProductPage productPage = new ProductPage();
        productPage.product("Black","36");
        DriverSingleton.delay(5);
        driver.get("https://shop.demoqa.com/checkout/");
        DriverSingleton.scroll(500);

        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.checkout("Revan", "Shop", "Juara Coding", "Jakarta", "Senayan", "Jakarta", "156756", "0877878688", "Please send my order");
        DriverSingleton.closeObjectInstance();
    }
}