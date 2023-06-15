package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
    private WebDriver driver;
    public CheckOutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    WebElement viewCartBtn;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward wp-element-button']")
    WebElement checkoutBtn;

    @FindBy(id = "billing_first_name")
    WebElement firstname;
    @FindBy(id = "billing_last_name")
    WebElement lastname;
    @FindBy(id = "billing_company")
    WebElement companyname;
    @FindBy(id = "select2-billing_country-container")
    private WebElement dropdownElement;
    @FindBy(id = "billing_address_1")
    WebElement billingaddress1;
    @FindBy(id = "billing_address_2")
    WebElement billingaddress2;
    @FindBy(id = "billing_city")
    WebElement billingcity;
    @FindBy(id = "select2-billing_country-container")
    private WebElement dropdownElement1;
    @FindBy(id = "billing_postcode")
    WebElement postcode;
    @FindBy(id = "billing_phone")
    WebElement phonenumber;
    //@FindBy(id = "billing_email")
    //WebElement email;
    @FindBy(xpath = "//textarea[@id='order_comments']")
    WebElement ordercomments;
    @FindBy(xpath = "//input[@id='terms']")
    WebElement btnterms;
    @FindBy(id = "place_order")
    WebElement btnOrder;
    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/div/p[1]")
    WebElement validCheckout;


    public void checkout(String firstname, String lastname,String companyname,String billingaddress1,String billingaddress2,String billingcity, String postcode, String phonenumber, String ordercomments){
        DriverSingleton.scroll(-500);
        viewCartBtn.click();
        DriverSingleton.scroll(500);
        checkoutBtn.click();
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.companyname.sendKeys(companyname);
        this.billingaddress1.sendKeys(billingaddress1);
        this.billingaddress2.sendKeys(billingaddress2);
        this.postcode.sendKeys(postcode);
        this.billingcity.sendKeys(billingcity);
        this.phonenumber.sendKeys(phonenumber);
        DriverSingleton.scroll(200);
        this.ordercomments.sendKeys(ordercomments);
        btnterms.click();
        btnOrder.click();
    }

    public String validCheck(){
        return validCheckout.getText();
    }
}