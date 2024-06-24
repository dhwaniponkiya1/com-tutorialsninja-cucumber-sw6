package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    private static final Logger log = Logger.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement poundLink;

    public void clickOnCurrency() {
        clickOnElement(currencyLink);
        clickOnElement(By.xpath("(//button[@class='currency-select btn btn-link btn-block'])[2]"));
        log.info("Click on " + currencyLink.toString());
    }

    public void selectPoundCurrency() {
        clickOnElement(currencyLink);
        clickOnElement(poundLink);
        log.info("Click on " + poundLink.toString());
    }

    public void selectMyAccountOptions(String option){
        clickOnElement(By.xpath("//a[normalize-space()='" + option + "']"));
        log.info("Select my account options" + option);
    }


}
