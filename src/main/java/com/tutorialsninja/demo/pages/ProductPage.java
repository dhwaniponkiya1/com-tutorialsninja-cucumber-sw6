package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Utility {

    private static final Logger log = Logger.getLogger(ProductPage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productHeading;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantityTextBox;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successAlertMsg;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement cartLinkInMsg;

    public String getProductHeading() {
        log.info("Get text" + productHeading.toString());
        return getTextFromElement(productHeading);
    }

    public void enterQuantity(String qty) {
        quantityTextBox.clear();
        sendTextToElement(quantityTextBox, qty);
        log.info("update " + qty);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        log.info("Click on " + addToCartButton.toString());
    }

    public String getSuccessAlertMsg() {
        log.info("Get " + successAlertMsg.toString());
        return getTextFromElement(successAlertMsg);
    }

    public void clickOnCartLinkInMsgButton() {
        clickOnElement(cartLinkInMsg);
        log.info("Click on " + cartLinkInMsg.toString());
    }

}
