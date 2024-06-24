package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends Utility {

    private static final Logger log = Logger.getLogger(MyAccountsPage.class);

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement regAccHeading;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement loginHeading;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement fNameField;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lNameField;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement mobileField;


    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeCheckbox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement regConfirmMsg;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement contAfterRegButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement logoutConfirmMsg;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement afterLoginHeading;

    public String getLoginHeading() {
        log.info("Get " + loginHeading.toString());
        return getTextFromElement(loginHeading);
    }

    public String getRegAccHeading() {
        log.info("Get " + regAccHeading.toString());
        return getTextFromElement(regAccHeading);
    }

    public void fillRegistrationData(String fName, String lName, String email, String mobile
            , String pwd, String cpwd) {
        sendTextToElement(fNameField, fName);
        sendTextToElement(lNameField, lName);
        sendTextToElement(emailField, email);
        sendTextToElement(mobileField, mobile);
        sendTextToElement(passwordField, pwd);
        sendTextToElement(confirmPasswordField, cpwd);
        clickOnElement(agreeCheckbox);
        clickOnElement(continueButton);
    }

    public void fillLoginData(String email, String pwd) {
        sendTextToElement(emailField, email);
        sendTextToElement(passwordField, pwd);
        clickOnElement(loginButton);
    }

    public String getRegConfirmText() {
        log.info("Get " + regConfirmMsg.toString());
        return getTextFromElement(regConfirmMsg);
    }

    public void clickOnContAfterRegButton() {
        clickOnElement(contAfterRegButton);
        log.info("Get " + contAfterRegButton.toString());
    }

    public String getLogoutConfirmMsg() {
        log.info("Get " + logoutConfirmMsg.toString());
        return getTextFromElement(logoutConfirmMsg);
    }

    public String getAfterLoginHeading() {
        log.info("Get " + afterLoginHeading.toString());
        return getTextFromElement(afterLoginHeading);
    }

}

