package com.tutorialninja.steps;

import com.tutorialninja.pages.TopMenuPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Components {
    @Then("Verify Components text")
    public void verifyComponentsText() {
        Assert.assertEquals(new TopMenuPage().getComponentsHeading(), "Components");
    }
}
