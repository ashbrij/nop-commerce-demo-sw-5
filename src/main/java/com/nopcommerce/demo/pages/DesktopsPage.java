package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Desktops text, Sortby, Display, selectProductList Locators and it's actions
 */
public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement sortBy;

    @CacheLookup
    @FindBy(id = "products-pagesize")
    WebElement displayBy;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'List')]")
    WebElement selectProductList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='picture']")
    WebElement selectProduct;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Build your own computer')]")
    WebElement buildYourOwnComputer;



    // * Verify "Desktops" text
    public void verifyTextDesktopTextIsDisplayed(String text){
        verifyThatTextIsDisplayed(desktopText, text);
    }
    public void clickOnSortBy(){
        clickOnElement(sortBy);
    }
    public void clickOnDisplayBy(){
        clickOnElement(displayBy);
    }
    public void clickOnSelectProductList(){
        clickOnElement(selectProductList);
    }
    public void clickOnSelectProductFromDesktopPage(){
        clickOnElement(buildYourOwnComputer);
    }
}
