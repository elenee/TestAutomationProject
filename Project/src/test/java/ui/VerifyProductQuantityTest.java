package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;

public class VerifyProductQuantityTest extends TestBase {
    @Test
    public void verifyProductQuantityInCart() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        CartPage cartPage = new CartPage(DriverFactory.getDriver());

        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.clickFirstProductView();

        Assert.assertTrue(productPage.isProductDetailVisible(), "Product detail page is not visible");

        productPage.setQuantity(4)
                .clickAddToCart()
                .clickViewCart();

        int actualQty = cartPage.getProductQuantity();
        Assert.assertEquals(actualQty, 4, "Product quantity in cart is incorrect!");
    }
}
