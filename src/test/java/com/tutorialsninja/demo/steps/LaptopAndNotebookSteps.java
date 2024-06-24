package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class LaptopAndNotebookSteps {
    @When("I mouse hover and click on laptops and notebooks link")
    public void iMouseHoverAndClickOnLaptopsAndNotebooksLink() {
        new TopMenuPage().mouseHoverOnLaptopsAndNotebookAndClick();
    }

    @And("I click on Show all laptops and notebooks link")
    public void iClickOnShowAllLaptopsAndNotebooksLink() {
        new TopMenuPage().selectMenu("Show AllLaptops & Notebooks");
    }

    @Then("Verify Laptops & Notebooks text")
    public void verifyLaptopsNotebooksText() {
        Assert.assertEquals(new TopMenuPage().getLaptopANdNotebookHeading(), "Laptops & Notebooks");
    }

    @And("I select Sort By position Price \\(High > Low)")
    public void iSelectSortByPositionPriceHighLow() {
        new DesktopPage().selectFromSortByDropdown("Price (High > Low)");
    }

    @Then("Verify the product arrange in high to low order")
    public void verifyTheProductArrangeInHighToLowOrder() throws InterruptedException {
        List<Double> expectedList = new LaptopsAndNotebooksPage().priceHighToLow();
        List<Double> actualList = new LaptopsAndNotebooksPage().getPriceHighToLow();
        Assert.assertEquals(actualList, expectedList);
    }

}
