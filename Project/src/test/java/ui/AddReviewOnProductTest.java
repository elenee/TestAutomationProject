package ui;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import utils.DriverFactory;

@Epic("UI Tests")
public class AddReviewOnProductTest extends TestBase {

    @Test()
    @Description("This test verifies that a user can add a review to a product and sees the success message.")
    public void addReviewOnProductTest() {
        Allure.step("Open homepage", () ->
                DriverFactory.getDriver().get("http://automationexercise.com")
        );

        ProductPage productPage = new ProductPage(DriverFactory.getDriver());

        Allure.step("Click 'Products' button", productPage::clickProductsButton);

        Allure.step("Verify ALL PRODUCTS page is visible", () ->
                Assert.assertTrue(productPage.isAllProductsPageVisible(),
                        "ALL PRODUCTS page is NOT visible")
        );

        Allure.step("Click 'View Product'", productPage::clickViewProduct);

        Allure.step("Verify 'Write Your Review' section is visible", () ->
                Assert.assertTrue(productPage.isWriteYourReviewVisible(),
                        "'Write Your Review' is NOT visible")
        );

        Allure.step("Enter review details", () ->
                productPage.enterReviewDetails(
                        "vinme",
                        "vinme@test.com",
                        "This is a good product."
                )
        );

        Allure.step("Click 'Submit Review'", productPage::clickSubmitReview);

        Allure.step("Verify review success message", () ->
                Assert.assertTrue(productPage.isReviewSuccessMessageVisible(),
                        "Review success message is NOT visible")
        );
    }
}

