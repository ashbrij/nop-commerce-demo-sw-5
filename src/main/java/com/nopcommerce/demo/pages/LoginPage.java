package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Email, password, Login Button and "Welcome, Please Sign In!" text Locators and
 * create appropriate methods for it.
 */
public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutLink;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;



    //Verify the Text "Welcome, Please Sign In!"

    public String getWelcomeMessage() {
        String message = getTextFromElement(welcomeText);
        return message;
    }

    //Enter Email into the email field
    public void enterEmailAddress(String email) {
        sendTextToElement(enterEmail, email);
    }

    //Enter Password into the password field
    public void enterPassword(String password) {
        sendTextToElement(enterPassword, password);
    }

    //Click on Login button
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public void clickOnLogOutButton() {
        clickOnElement(logOutLink);
    }

    public void getErrorMessage(String message) {
        verifyThatTextIsDisplayed(errorMessage,message);
    }
    public void loginToTheApplication(String email, String password){
        enterEmailAddress(email);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
    }
}
