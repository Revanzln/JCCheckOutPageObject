package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {
    static WebDriver driver;
    static LoginPage loginPage;
   @BeforeClass
   public void setUp(){
       DriverSingleton.getInstance("chrome");
       driver = DriverSingleton.getDriver();
       driver.get("https://shop.demoqa.com/my-account");

       loginPage = new LoginPage();
    }

  @AfterClass
   public void closeBrowser(){
     DriverSingleton.delay(2);
     DriverSingleton.closeObjectInstance();
   }

  @Test(priority = 1)
    public void testValidLogin(){
       loginPage.login("revan_zn","Shopqa1122");
       DriverSingleton.delay(3);
       Assert.assertEquals(loginPage.getTxtDashboard(),"MY ACCOUNT");
      loginPage.logout();
    }

  @Test(priority = 2)
public void testInvalidLogin(){
    loginPage.login("aadmin", "admin123456");
     DriverSingleton.delay(3);
      Assert.assertEquals(loginPage.getTxtErrorLogin(),"ERROR");
   }
}
