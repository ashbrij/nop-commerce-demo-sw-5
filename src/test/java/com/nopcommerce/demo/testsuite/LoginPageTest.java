package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1.LoginPageTest
 * Inside LoginPageTest class create following test methods
 * 1.userShouldNavigateToLoginPageSuccessFully().
 * Click on login link
 * verify that "Welcome, Please Sign In!" message display
 * <p>
 * 2. verifyTheErrorMessageWithInValidCredentials().
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Verify that the Error message
 * <p>
 * 3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Verify that LogOut link is display
 * 4. verifyThatUserShouldLogOutSuccessFully()
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Click on LogOut Link
 * Verify that LogIn Link Display
 */
@Listeners(CustomListeners.class)

public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        //Click on login link
        homePage.clickOnLoginLink();

        //verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(loginPage.getWelcomeMessage(), expectedMessage, "Incorrect message displayed!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {

        // Click on login link
        homePage.clickOnLoginLink();

        //	 Enter EmailId
        loginPage.enterEmailAddress("akakad@gmail.com");

        //	 Enter Password
        loginPage.enterPassword("Asha123");

        //	 Click on Login Button
        loginPage.clickOnLoginButton();

        //	 Verify that the Error message
        loginPage.getErrorMessage("Login was unsuccessful. Please correct the errors and try again.No customer account found");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {

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

        // Enter password
        registerPage.inputPassword("Ash123");

        // Enter Confirm Password
        registerPage.inputConfirmPassword("Ash123");

        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        // Verify message "Your registration completed"
        registerPage.verifyRegistrationCompleted();

        // * Click on login link
        homePage.clickOnLoginLink();

        // * Enter EmailId
        loginPage.enterEmailAddress(randomEmail);

        // * Enter Password
        loginPage.enterPassword("Ash123");

        // * Click on Login Button
        loginPage.clickOnLoginButton();

        // * Verify that LogOut link is display
        homePage.verifyLogOutLinkIsDisplayed("Log out");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully()  {
        //calling the above method
        verifyThatUserShouldLogInSuccessFullyWithValidCredentials();

        // * Click on LogOut Link
        loginPage.clickOnLogOutButton();

        // * Verify that LogIn Link Display
        homePage.verifyLogInLinkIsDisplayed("Log in");
    }
}
