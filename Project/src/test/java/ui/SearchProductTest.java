package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;

public class SearchProductTest extends TestBase {

    @Test
    public void searchProductTest() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());

        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        productPage.clickProductsButton();

        Assert.assertTrue(productPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible");

        String productName = "Jeans";
        productPage.enterSearchTerm(productName).clickSearchButton();

        Assert.assertTrue(productPage.isSearchedProductsVisible(), "'SEARCHED PRODUCTS' title not visible");

        Assert.assertTrue(productPage.areAllProductsRelatedToSearchVisible(productName),
                "Not all products are related to search");
    }
}