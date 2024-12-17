package com.tutorialninja.steps;

import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.LaptopsAndNoteBooksPage;
import com.tutorialninja.pages.TopMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class LaptopAndNotebooksSteps {
    @And("I select Sort By position Price \\(High > Low)")
    public void iSelectSortByPositionPriceHighLow() {
        new DesktopPage().selectFromSortByDropdown("Price (High > Low)");
    }

    @Then("Verify the product arrange in high to low order")
    public void verifyTheProductArrangeInHighToLowOrder() {
        List<Double> expectedList = new LaptopsAndNoteBooksPage().priceHighToLow();
        List<Double> actualList = new LaptopsAndNoteBooksPage().getPriceHighToLow();
        Assert.assertEquals(actualList, expectedList);
    }

    @Then("Verify Laptops & Notebooks text")
    public void verifyLaptopsNotebooksText() {
        new TopMenuPage().selectMenu("Show AllLaptops & Notebooks");
    }
}
