package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Computers text, DesktopsLink, NotebooksLink, SoftwareLink Locators and
 * create appropriate methods for it.
 */
public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//h1[normalize-space()='Computers'])[1]")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//img[@title='Show products in category Desktops']")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//img[@title='Show products in category Notebooks']")
    WebElement notebooksLink;

    @CacheLookup
    @FindBy(xpath = "//img[@title='Show products in category Software']")
    WebElement softwareLink;



    // * Verify "Computer" text
    public void verifyComputerText(String text){
        verifyThatTextIsDisplayed(computerText, text);
    }

    // * Click on Desktops link
    public void clickOnDesktopLink(){
        clickOnElement(desktopLink);
    }

    // * Verify "Desktops" text
        public void verifyTextDesktopTextIsDisplayed(String text){
        verifyThatTextIsDisplayed(desktopText, text);
        }
}
