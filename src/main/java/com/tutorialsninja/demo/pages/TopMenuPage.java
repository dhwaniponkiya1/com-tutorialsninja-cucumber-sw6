package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopMenuPage extends Utility {

    private static final Logger log = Logger.getLogger(TopMenuPage.class);


    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//li//a")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement deskTopLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNoteLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement componentsLink;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Desktops']")
    WebElement deskTopHeading;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Laptops & Notebooks']")
    WebElement laptopsAndNoteHeading;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Components']")
    WebElement componentsHeading;


    public void selectMenu(String menu) {
        List<WebElement> topMenuElements = topMenu;
        for (WebElement e : topMenuElements) {
            if (e.getText().equalsIgnoreCase(menu)) {
                e.click();
                break;
            }
        }
    }

    public void mouseHoverOnDesktopAndClick() {
        mouseHoverToElementAndClick(deskTopLink);
        log.info("Click on " + deskTopLink.toString());
    }

    public String getDesktopHeading() {
        log.info("get " + deskTopHeading.toString());
        return getTextFromElement(deskTopHeading);
    }

    public void mouseHoverOnLaptopsAndNotebookAndClick() {
        mouseHoverToElementAndClick(laptopsAndNoteLink);
        log.info("Click on " + laptopsAndNoteLink.toString());
    }

    public String getLaptopANdNotebookHeading() {
        log.info("get " + laptopsAndNoteHeading.toString());
        return getTextFromElement(laptopsAndNoteHeading);
    }

    public void mouseHoverOnComponentsAndClick() {
        mouseHoverToElementAndClick(componentsLink);
        log.info("Click on " + componentsLink.toString());
    }

    public String getComponentsHeading() {
        log.info("get " + componentsHeading.toString());
        return getTextFromElement(componentsHeading);
    }


}
