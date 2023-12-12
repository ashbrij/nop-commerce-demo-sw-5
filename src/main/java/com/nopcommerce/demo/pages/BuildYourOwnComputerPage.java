package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Build your own computer Text, Processor Drop Down, Ram
 * drop down, HDD radios, os radio, software check boxes, Add To Card button, "The product has
 * been added to your shopping cart" message locators and it's actions
 */
public class BuildYourOwnComputerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Build your own computer']")
    WebElement titleText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processor;

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ram;

    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement hdd;

    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement os;

    @CacheLookup
    @FindBy(id = "product_attribute_5_12")
    WebElement software;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartLink;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement message;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement buildYourOwnComputerText;

    public void selectProcessor(String Text) {
        selectByVisibleTextFromDropDown(processor, Text);
    }

    public void selectRAM(String Text) {
        selectByVisibleTextFromDropDown(ram, Text);
    }

    public void selectHDD(String text) {
        sendTextToElement(hdd, text);
    }

    public void selectOS(String text) {
        sendTextToElement(os, text);
    }

    public void selectSoftware(String text) {
        sendTextToElement(software, text);
    }

    public void clickOnAddToCartLink() {
        clickOnElement(addToCartLink);
    }

    public void getMessageText(String text) {
        verifyThatTextIsDisplayed(message, text);
    }

}

