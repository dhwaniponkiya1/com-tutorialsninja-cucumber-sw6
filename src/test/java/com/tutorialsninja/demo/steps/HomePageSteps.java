package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageSteps {
    @When("I mouse hover and click on currency dropdown and pound sterling")
    public void iMouseHoverAndClickOnCurrencyDropdownAndPoundSterling() {
        new HomePage().selectPoundCurrency();
    }

    @When("I click on my accounts link")
    public void iClickOnMyAccountsLink() {
        new HomePage().selectMyAccountOptions("My Account");
    }

    @And("I click on register link")
    public void iClickOnRegisterLink() {
        new HomePage().selectMyAccountOptions("Register");
    }

    @And("I click on login link")
    public void iClickOnLoginLink() {
        new HomePage().selectMyAccountOptions("Login");
    }

    @And("I click on logout link")
    public void iClickOnLogoutLink() {
        new HomePage().selectMyAccountOptions("Logout");
    }

    @Then("Verify the logout text {string}")
    public void verifyTheLogoutText(String text) {
        Assert.assertEquals(new MyAccountsPage().getLogoutConfirmMsg(), text, "Logout confirmation not displayed");
    }

}
