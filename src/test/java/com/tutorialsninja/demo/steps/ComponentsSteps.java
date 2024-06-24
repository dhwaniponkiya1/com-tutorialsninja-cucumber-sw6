package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.TopMenuPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ComponentsSteps {

    @Then("Verify Components text")
    public void verifyComponentsText() {
        Assert.assertEquals(new TopMenuPage().getComponentsHeading(), "Components");
    }
}
