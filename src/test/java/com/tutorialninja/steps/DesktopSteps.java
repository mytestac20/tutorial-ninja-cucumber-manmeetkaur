package com.tutorialninja.steps;

import com.tutorialninja.pages.CartPage;
import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.ProductPage;
import com.tutorialninja.pages.TopMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class DesktopSteps {
    @Then("Verify Desktops text")
    public void verifyDesktopsText() {
        Assert.assertEquals(new TopMenuPage().deskTopMessage(), "Desktops");
    }

    @Then("I Verify the Product will arrange in Descending order.")
    public void iVerifyTheProductWillArrangeInDescendingOrder() {
        List<String> actualList = new DesktopPage().getSortedProductList();
        List<String> expectedList = new DesktopPage().expectedList();
        Assert.assertEquals(actualList, expectedList, "Products not sorted in descending order");

    }

    @And("I Select Sort By position Name \\(Z to A)")
    public void iSelectSortByPositionNameZToA() {
        new DesktopPage().selectFromSortByDropdown("Name (Z - A)");
    }

    @And("I Select Sort By position Name \\(A to Z)")
    public void iSelectSortByPositionNameAToZ() {
        new DesktopPage().selectFromSortByDropdown("Name (A - Z)");
    }

    @And("I select {string}")
    public void iSelect(String product) {
        new DesktopPage().clickOnProduct(product);
    }


    @Then("Verify text {string}")
    public void verifyText(String productName) {
        Assert.assertEquals(new ProductPage().getProductHeading(), productName, "product name doesn't match");


    }

    @And("I enter qty {string}")
    public void iEnterQty(String qty) {
        new ProductPage().enterQuantity(qty);

    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @Then("Verify the Message Success: You have added {string} to your shopping cart!")
    public void verifyTheMessageSuccessYouHaveAddedToYourShoppingCart(String product) {
        Assert.assertEquals(new ProductPage().getSuccessAlertMsg(), "Success: You have added " + product + " to your shopping cart!\n" + "×");
    }

    @And("I click on link shopping cart into message")
    public void iClickOnLinkShoppingCartIntoMessage() {
        new ProductPage().clickOnCartLinkInMsgButton();
    }

    @Then("Verify Shopping cart text {string}")
    public void verifyShoppingCartText(String text) {
        Assert.assertEquals(new CartPage().getShoppingCartHeading().substring(0,13), text, "Navigation to shopping cart page failed");
    }

    @Then("Verify the Product name {string}")
    public void verifyTheProductName(String product) {
        Assert.assertEquals(new CartPage().getProductName(), product, "Product name not valid");

    }

    @Then("Verify the Model {string}")
    public void verifyTheModel(String model) {
        Assert.assertEquals(new CartPage().getModelName(), model, "Model name not valid");
    }

    @Then("Verify the Total {string}")
    public void verifyTheTotal(String total) {
        Assert.assertEquals(new CartPage().getTotalPrice(), total, "Total not valid");
    }
}

