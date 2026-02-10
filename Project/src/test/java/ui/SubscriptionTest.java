package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverFactory;

public class SubscriptionTest extends TestBase {

    @Test
    public void verifySubscriptionInHomePageFooter() {
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());

        Assert.assertTrue(homePage.isHomePageVisible(), "Home page isn't visible");

        homePage.scrollToFooterSubscription();

        Assert.assertTrue(homePage.isSubscriptionHeaderVisible(), "'SUBSCRIPTION' header isn't visible in footer");

        String randomEmail = "test+" + System.currentTimeMillis() + "@example.com";
        homePage.subscribeWithEmail(randomEmail);

        Assert.assertTrue(homePage.isSubscriptionSuccessVisible(), "Success message for subscription isn't visible");
    }
}

