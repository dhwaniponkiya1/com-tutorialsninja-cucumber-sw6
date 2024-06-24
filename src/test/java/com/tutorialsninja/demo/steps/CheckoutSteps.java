package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutSteps {
    @Then("Verify {string} heading")
    public void verifyHeading(String heading) {
        Assert.assertEquals(new CheckoutPage().getNewCustHeading(), heading, "New customer not displayed");
    }

    @And("I click on guest checkout radio")
    public void iClickOnGuestCheckoutRadio() {
        new CheckoutPage().clickOnGuestRadio();
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        new CheckoutPage().clickOnCheckoutOptContButton();
    }

    @And("I fill billing form details; {string},{string},{string},{string},{string}, {string}, {string}, {string},{string}")
    public void iFillBillingFormDetails(String fName, String lName, String email, String mobile
            , String add1, String city, String postCode, String country, String state) {
        new CheckoutPage().fillBillingFormDetails(fName, lName, email, mobile, add1, city, postCode, country, state);
    }

    @And("I click on del method continue btn")
    public void iClickOnDelMethodContinueBtn() {
        new CheckoutPage().clickOnDelMethodContButton();
    }

    @And("I click on agree terms checkbox")
    public void iClickOnAgreeTermsCheckbox() {
        new CheckoutPage().clickOnAgreeTermsCheckbox();
    }

    @And("I click on payment method continue btn")
    public void iClickOnPaymentMethodContinueBtn() {
        new CheckoutPage().clickOnPaymentMethodCont();
    }
}
