package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * 1. verifyUserShouldNavigateToComputerPageSuccessfully()
 * Click on Computer tab
 * Verify "Computer" text
 * 2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * Click on Computer tab
 * Click on Desktops link
 * Verify "Desktops" text
 * 3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
 * processor, String ram, String hdd, String os, String software)
 * Click on Computer tab
 * Click on Desktops link
 * Click on product name "Build your own computer"
 * Select processor "processor"
 * Select RAM "ram"
 * Select HDD "hdd"
 * Select OS "os"
 * Select Software "software"
 * Click on "ADD TO CART" Button
 * Verify message "The product has been added to your shopping cart"
 */
@Listeners(CustomListeners.class)

public class ComputerTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }


    //1. verifyUserShouldNavigateToComputerPageSuccessfully()
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        // * Click on Computer tab
        homePage.selectMenu("Computers");

        // * Verify "Computer" text
        computerPage.verifyComputerText("Computers");
    }

    @Test(groups = {"smoke", "regression"})
    //* 2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // * Click on Computer tab
        homePage.selectMenu("Computers");

        // * Click on Desktops link
        computerPage.clickOnDesktopLink();

        // * Verify "Desktops" text
        desktopsPage.verifyTextDesktopTextIsDisplayed("Desktops");
    }

    //* 3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software)

    @Test(groups = {"regression"}, dataProvider = "Build your own computer", dataProviderClass = TestData.class)

    public void verifyThatUserShouldBuildYouOwnComputer(String processor, String ram,
                                                        String hdd, String os, String software)  {

        // Click on Computer tab
        homePage.selectMenu("Computers");

        // Click on Desktops link
        computerPage.clickOnDesktopLink();

        // Click on product name "Build your own computer"
        desktopsPage.clickOnSelectProductFromDesktopPage();

        // Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);

        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);

        // Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);

        // Select OS "os"
        buildYourOwnComputerPage.selectOS(os);

        // Select Software "software"
        buildYourOwnComputerPage.selectSoftware(software);

        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartLink();

        //  Verify message "The product has been added to your shopping cart"
        buildYourOwnComputerPage.getMessageText("The product has been added to your shopping cart");
    }

}


