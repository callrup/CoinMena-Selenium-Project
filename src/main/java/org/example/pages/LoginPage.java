package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginusername")
    WebElement textInputUsername;

    @FindBy(id = "loginpassword")
    WebElement textInputPassword;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement buttonLogin;

    @FindBy(xpath = "//*[@id='logInModal']/div/div/div[3]/button[1]")
    WebElement buttonClose;

    public void login(String username, String password) {
        sendText(textInputUsername, username);
        sendText(textInputPassword, password);
        clickElement(buttonLogin);
    }
    
    public void closeLoginPage(){
        clickElement(buttonClose);
    }
}
