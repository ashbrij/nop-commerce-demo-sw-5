package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
 * * Click on Register Link
 * * Verify "Register" text
 * * 2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
 * * Click on Register Link
 * * Click on "REGISTER" button
 * * Verify the error message "First name is required."
 * * Verify the error message "Last name is required."
 * * Verify the error message "Email is required."
 * * Verify the error message "Password is required."
 * * Verify the error message "Password is required."
 * * 2. verifyThatUserShouldCreateAccountSuccessfully()
 * * Click on Register Link
 * * Select gender "Female"
 * * Enter firstname
 * * Enter lastname
 * * Select day
 * * Select month
 * * Select year
 * * Enter email
 * * Enter password
 * * Enter Confirm Password
 * * Click on "REGISTER" button
 * * Verify message "Your registration completed"
 */
@Listeners(CustomListeners.class)

public class RegistrationTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

    }

    // 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLinkIsDisplayed();

        //Verify "Register" text
        registerPage.verifyTheTextRegisterOnRegisterPage("Register");

    }

    // 2.  verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {

        // *      * Click on Register Link
        homePage.clickOnRegisterLinkIsDisplayed();

        // *      * Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        // *      * Verify the error message "First name is required."
        registerPage.verifyFirstNameRequiredErrorText("First name is required.");

        // *      * Verify the error message "Last name is required."
        registerPage.verifyLastNameRequiredErrorText("Last name is required.");

        // *      * Verify the error message "Email is required."
        registerPage.verifyEmailRequiredErrorText("Email is required.");

        // *      * Verify the error message "Password is required."
        registerPage.verifyPasswordRequiredErrorText("Password is required.");

        // *      * Verify the error message "Password is required."
        registerPage.verifyConfirmPasswordRequiredErrorText("Password is required.");
    }

    // 3. verifyThatUserShouldCreateAccountSuccessfully()
    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully()  {
        // Click on Register Link
        homePage.clickOnRegisterLinkIsDisplayed();

        // Select gender "Female"
        registerPage.selectGender("Female");

        // Enter firstname
        registerPage.inputFirstName("Asha");

        // Enter lastname
        registerPage.inputLastName("Kakadiya");

        // Select day, select month, Select year for date of birth
        registerPage.selectDateOfDay("18");
        registerPage.selectDateOfMonth("October");
        registerPage.selectDateOfYear("1984");

        // Enter email
        enterEmailAddress();

        //registerPage.inputEmailAddress(randomEmail);

        // Enter password
        registerPage.inputPassword("Ash123");

        // Enter Confirm Password
        registerPage.inputConfirmPassword("Ash123");

        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        // Verify message "Your registration completed"
        registerPage.verifyRegistrationCompleted();
    }

}


