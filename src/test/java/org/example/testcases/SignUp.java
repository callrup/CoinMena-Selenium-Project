package org.example.testcases;

import org.example.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyReader;

public class SignUp extends BaseTestClass {
    private SignUpPage signUpPage;


    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        signUpPage = header.clickOnSignUp();
    }

    @Test(priority = 1)
    public void validSingUp() {
        //signUpPage.signUp(fakeDataGenerator.getValidUsername(), fakeDataGenerator.getValidPassword());
    	signUpPage.signUp(PropertyReader.getData("USERNAME"), PropertyReader.getData("PASSWORD"));
        softAssert.assertEquals(signUpPage.getAlertMessage(), PropertyReader.getAlertMessage("VALID.SIGN.UP"));
        signUpPage.acceptAlert();
        softAssert.assertAll();
    }

    @Test(priority = 2, dependsOnMethods = "validSingUp")
    public void singUpWithUsedUsername() {
        signUpPage.signUp(PropertyReader.getData("USERNAME"),PropertyReader.getData("PASSWORD"));
        softAssert.assertEquals(signUpPage.getAlertMessage(), PropertyReader.getAlertMessage("USED.SIGN.UP"));
        signUpPage.acceptAlert();
        signUpPage.closeSignUpPageUsingX();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void singUpWithEmptyFields() {
        signUpPage.signUp("", "");
        softAssert.assertEquals(signUpPage.getAlertMessage(), PropertyReader.getAlertMessage("EMPTY.SIGN.UP"));
        signUpPage.acceptAlert();
        signUpPage.closeSignUpPageUsingX();
        softAssert.assertAll();
    }

}
