package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverFactory;

@Epic("UI Tests")
public class SubscriptionTest extends TestBase {

    @Description("Verify that a user can subscribe to the newsletter from the homepage footer")
    @Test
    public void verifySubscriptionInHomePageFooter() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible", () -> {
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page isn't visible");
        });

        Allure.step("Scroll to footer subscription section", () -> {
            homePage.scrollToFooterSubscription();
            Assert.assertTrue(homePage.isSubscriptionHeaderVisible(), "'SUBSCRIPTION' header isn't visible in footer");
        });

        Allure.step("Subscribe with a random email", () -> {
            String randomEmail = "test+" + System.currentTimeMillis() + "@example.com";
            homePage.subscribeWithEmail(randomEmail);
        });

        Allure.step("Verify subscription success message is visible", () -> {
            Assert.assertTrue(homePage.isSubscriptionSuccessVisible(), "Success message for subscription isn't visible");
        });
    }
}
