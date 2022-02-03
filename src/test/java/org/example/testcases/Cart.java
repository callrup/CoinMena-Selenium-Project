package org.example.testcases;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyReader;

import java.util.Calendar;
import java.util.HashMap;

public class Cart extends BaseTestClass {
    private HomePage homePage;
    private CartPage cartPage;

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        cartPage = header.clickOnCart();
    }

    @Test(priority = 1)
    public void cartTotalPrice() {
        Assert.assertEquals(cartPage.getActualPrice(), cartPage.getExpectedPrice());
    }

//    @Test(priority = 2)
//    public void cartDelete() throws InterruptedException {
//        cartPage.deleteProduct();
//        Assert.assertTrue(cartPage.isProductDeleted());
//    }

    @Test(priority = 2)
    public void cartPlaceOrder() throws InterruptedException {
  
        cartPage.clickOnPlaceOrder();
        
        cartPage.enterPlaceOrderData(PropertyReader.getData("NAME"), PropertyReader.getData("COUNTRY"), PropertyReader.getData("CITY"),
        		PropertyReader.getData("CARD"), PropertyReader.getData("MONTH"), PropertyReader.getData("YEAR"));
        
                
        cartPage.clickOnPurchase();
        softAssert.assertEquals(cartPage.getSuccessMessage(), PropertyReader.getAlertMessage("SUCCESSFUL.PURCHASE"));
        softAssert.assertTrue(cartPage.areTheRightDataAppear(PropertyReader.getData("CARD"), PropertyReader.getData("NAME")));

        homePage = cartPage.clickOnOk();
        softAssert.assertEquals(homePage.getUrl(), PropertyReader.getData("HOME.URL"));
        softAssert.assertAll();
    }
}
