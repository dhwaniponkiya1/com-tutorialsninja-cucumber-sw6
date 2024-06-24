package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    private static final Logger log = Logger.getLogger(DesktopPage.class);

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropdown;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts1;

    public void selectFromSortByDropdown(String value) {
        selectByVisibleTextFromDropDown(sortByDropdown, value);
    }

    public ArrayList expectedList() {

        List<WebElement> products = listOfProducts;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }

        return originalProductsName;
    }

    public ArrayList getSortedProductList() {

        Collections.reverse(expectedList());
        List<WebElement> products = listOfProducts1;

        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        return afterSortByZToAProductsName;
    }

//    public List<String> getListOfProducts() {
//        List<WebElement> products = listOfProducts;
//        List<String> originalProductList = new ArrayList<>();
//        try {
//            for (WebElement list : products) {
//                System.out.println(list.getText());
//                originalProductList.add(list.getText());
//            }
//        } catch (StaleElementReferenceException e) {
//        }
//        return originalProductList;
//    }

    public void clickOnProduct(String product) {
        List<WebElement> products = listOfProducts;
        List<String> productList = new ArrayList<>();
        for (WebElement e : products) {
            if (e.getText().equalsIgnoreCase(product)) {
                e.click();
                break;
            }
        }

        log.info("Click on " + product);
    }



}
