package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    private static final Logger log = Logger.getLogger(LaptopsAndNotebooksPage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']")
    List<WebElement> listOfPrice;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Sony VAIO']")
    WebElement sonyHeading;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productPriceList;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productPriceList1;


    public List<Double> priceHighToLow() {

        List<WebElement> products = productPriceList1;
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        log.info("Verify Product sorted  price High to low " + productPriceList1.toString());
        return originalProductsPrice;
    }

    public List<Double> getPriceHighToLow() {
        Collections.sort(priceHighToLow(), Collections.reverseOrder());
        List<WebElement> products = productPriceList;
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortByPrice;
    }

    public ArrayList<Double> getProductsPriceList() {
        log.info("Get product prices " + productsPrices.toString());
        List<WebElement> products = productsPrices;
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public boolean isSorted() throws InterruptedException {
        List<Double> sortedList = getProductsPriceList();
        Collections.sort(getProductsPriceList(), Collections.reverseOrder());
        return getProductsPriceList().equals(sortedList);
    }

    public List<Double> getPriceList() {
        List<WebElement> prices = listOfPrice;
        List<Double> originalPriceList = new ArrayList<>();
        try {
            for (WebElement element : prices) {
                String price = element.getText().replaceAll("[E,x,T,a,x,:,$]", "").replace(",", "");
                Double priceValue = Double.parseDouble(price);
                originalPriceList.add(priceValue);
            }
            System.out.println(originalPriceList);
        } catch (StaleElementReferenceException e) {
        }
        return originalPriceList;
    }

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

    public String getSonyVAIOHeading() {
        return getTextFromElement(sonyHeading);
    }


}
