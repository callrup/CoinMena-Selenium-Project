package org.example.testcases;

import org.example.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.PropertyReader;

public class Login extends BaseTestClass {
    private LoginPage loginPage;

    @Override
    @BeforeClass
    void beforeClass() {
        super.beforeClass();
        loginPage = header.clickOnLogin();
    }
    
    // SignUp test should be executed
    @Test(priority = 1)
    public void validLogin() {
        loginPage.login(PropertyReader.getData("USERNAME"), PropertyReader.getData("PASSWORD"));
        softAssert.assertTrue(header.isWelcomeUserDisplayed());
        softAssert.assertTrue(header.isLogoutDisplayed());
        softAssert.assertAll();
    }

   
}
