package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account
 * link and LogOut link locators and create appropriate methods for it.
 */
public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Computers'])[1]")
    WebElement computerLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Electronics')]")
    WebElement electronicsTabLink;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Apparel')]")
    WebElement apparelTabLink;
    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Digital downloads'])[1]")
    WebElement digitalDownloadsLink;
    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Books'])[1]")
    WebElement booksLink;
    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Jewelry'])[1]")
    WebElement jewelryLink;
    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Gift Cards'])[1]")
    WebElement giftCardsLink;

    @CacheLookup
    //@FindBy(xpath = "(//a[normalize-space()='Log in'])[1]")
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'My account')]")
    WebElement getmyAccountLink;
    @CacheLookup
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement getNopCommerceLogo;


    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public void verifyLogInLinkIsDisplayed(String text) {
        verifyThatTextIsDisplayed(loginLink, text);
    }

    public void verifyLogOutLinkIsDisplayed(String text) {
        verifyThatTextIsDisplayed(logOutLink, text);
    }

    public void clickOnRegisterLinkIsDisplayed() {
        clickOnElement(registerLink);
    }

    @Override
    public void verifyLogoVisible(WebElement element) {
        super.verifyLogoVisible(element);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }
}
