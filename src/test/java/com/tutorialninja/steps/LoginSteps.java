package com.tutorialninja.steps;

import com.tutorialninja.pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {
    @Then("Verify the login text {string}")
    public void verifyTheLoginText(String heading) {
        Assert.assertEquals(new MyAccountPage().getLoginHeading(), heading);
    }

    @And("I enter {string}, {string} and login")
    public void iEnterAndLogin(String email, String pwd) {
        new MyAccountPage().fillLoginData(email, pwd);
    }

    @Then("Verify text after login {string}")
    public void verifyTextAfterLogin(String text) {
        Assert.assertEquals(new MyAccountPage().getAfterLoginHeading(), "My Account");
    }
}
