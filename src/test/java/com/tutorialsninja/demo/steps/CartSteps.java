package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartSteps {
    @And("I change qty to {string}")
    public void iChangeQtyTo(String qty) {
        new CartPage().sendQty(qty);
    }

    @And("I click on update qty button")
    public void iClickOnUpdateQtyButton() {
        new CartPage().clickOnUpdateQty();
    }

    @Then("Verify the Message Success: You have modified your shopping cart!")
    public void verifyTheMessageSuccessYouHaveModifiedYourShoppingCart() {
        Assert.assertEquals(new CartPage().getSuccessCartUpdateMsg(), "Success: You have modified your shopping cart!\n"+"×", "Cart modification failed");
    }

    @And("I click on checkout button")
    public void iClickOnCheckoutButton() {
        new CartPage().clickOnCheckOut();
    }
}
