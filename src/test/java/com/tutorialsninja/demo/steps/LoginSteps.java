package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.MyAccountsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {
    @Then("Verify the login text {string}")
    public void verifyTheLoginText(String heading) {
        Assert.assertEquals(new MyAccountsPage().getLoginHeading(), heading);
    }

    @And("I enter {string}, {string} and login")
    public void iEnterAndLogin(String email, String pwd) {
        new MyAccountsPage().fillLoginData(email, pwd);
    }

    @Then("Verify text after login {string}")
    public void verifyTextAfterLogin(String text) {
        Assert.assertEquals(new MyAccountsPage().getAfterLoginHeading(), "My Account");
    }
}
