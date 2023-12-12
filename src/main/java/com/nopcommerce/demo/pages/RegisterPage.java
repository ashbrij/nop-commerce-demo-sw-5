package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Register Text, male female radio, Firstname, lastname, Date of Birth drop
 * down, email, Password, Confirm Password, Register Button, "First name is required.","Last name
 * is required.", "Email is required.","Password is required.", "Password is required." error message,
 * "Your registration completed" message, "CONTINUE" button
 * Locators and it's actions
 */

public class RegisterPage extends Utility {
    //Verify "Register" text
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    // Verify the error message "First name is required."
    @CacheLookup
    @FindBy(id = "FirstName-error")
    WebElement firstNameErrorText;


    // Verify the error message "Last name is required."
    @CacheLookup
    @FindBy(id = "LastName-error")
    WebElement lastNameErrorText;

    // Verify the error message "Email is required."
    @CacheLookup
    @FindBy(id = "Email-error")
    WebElement emailFieldErrorText;

    // Verify the error message "Password is required."
    @CacheLookup
    @FindBy(id = "Password-error")
    WebElement passwordErrorText;

    // Verify the error message "Password is required."
    @CacheLookup
    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordErrorText;

    @CacheLookup
    @FindBy(id = "gender-male")
    WebElement genderMale;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement genderFemale;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath= "(//select[@name='DateOfBirthDay'])[1]")
    WebElement dateOfBirthDay;
    @CacheLookup
    @FindBy(xpath = "(//select[@name='DateOfBirthMonth'])[1]")
    WebElement dateOfBirthMonth;
    @CacheLookup
    @FindBy(xpath = "(//select[@name='DateOfBirthYear'])[1]")
    WebElement dateOfBirthYear;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement enterConfirmPassword;
    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompleted;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;
    //*********************************************  Methods  ***************************************************

    //Verify "Register" text
    public void verifyTheTextRegisterOnRegisterPage(String text) {
       verifyThatTextIsDisplayed(registerText, text);
    }
    // Verify the error message "First name is required."
    public void verifyFirstNameRequiredErrorText(String text) {
       verifyThatTextIsDisplayed(firstNameErrorText, text);
    }
    // Verify the error message "Last name is required."
    public void verifyLastNameRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(lastNameErrorText, text);
    }
    // Verify the error message "Email is required."
    public void verifyEmailRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(emailFieldErrorText, text);
    }
    // Verify the error message "Password is required."
    public void verifyPasswordRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(passwordErrorText, text);
    }
    // Verify the error message "Password is required."
    public void verifyConfirmPasswordRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(confirmPasswordErrorText, text);
    }

    // Select gender "Female"
    public void selectGender(String maleOrFemale) {
        CustomListeners.test.log(Status.PASS, "Select gender." + maleOrFemale);
        switch (maleOrFemale) {
            case "Male":
                clickOnElement(genderMale);
                break;
            case "Female":
                clickOnElement(genderFemale);
                break;
            default:
                break;
        }
    }

    // *      * Enter firstname
    public void inputFirstName(String name){
        sendTextToElement(firstName, name);
    }

    // *      * Enter lastname
    public void inputLastName(String name){
        sendTextToElement(lastName, name);
    }

    // Select day,
    public void selectDateOfDay(String day) {
        selectByVisibleTextFromDropDown(dateOfBirthDay, day);
    }
    //Select month,
        public void selectDateOfMonth(String month) {
            selectByVisibleTextFromDropDown(dateOfBirthMonth, month);
        }
        //Select year
    public void selectDateOfYear(String year){
        selectByVisibleTextFromDropDown(dateOfBirthYear, year);
    }

    // Enter password
    public void inputPassword(String password){
        sendTextToElement(enterPassword, password);
    }
    // Enter Confirm Password
    public void inputConfirmPassword(String confirmPsw){
        sendTextToElement(enterConfirmPassword, confirmPsw);
    }

    // Click on "REGISTER" button
    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
    }

    // Verify message "Your registration completed"
    public void verifyRegistrationCompleted(){
        verifyThatElementIsDisplayed(registrationCompleted);
    }
}
