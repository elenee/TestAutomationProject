package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By productsButton = By.xpath("//a[@href='/products']");
    private By allProductsTitle = By.xpath("//h2[text()='All Products']");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
    private By productNames = By.cssSelector(".productinfo.text-center p");
    private By productDetailSection = By.cssSelector(".product-details");
    private By quantityInput = By.id("quantity");
    private By addToCartButton = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    private By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");


    public ProductPage clickProductsButton() {
        click(productsButton);
        return this;
    }

    public boolean isAllProductsPageVisible() {
        return isDisplayed(allProductsTitle);
    }

    public ProductPage enterSearchTerm(String productName) {
        type(searchInput, productName);
        return this;
    }

    public ProductPage clickSearchButton() {
        click(searchButton);
        return this;
    }

    public boolean isSearchedProductsVisible() {
        return isDisplayed(searchedProductsTitle);
    }

    public List<String> getSearchedProductNames() {
        wait.until(driver -> !driver.findElements(productNames).isEmpty());
        List<WebElement> products = driver.findElements(productNames);
        return products.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean areAllProductsRelatedToSearchVisible(String productName) {
        String lowerTerm = productName.toLowerCase();
        return getSearchedProductNames().stream()
                .allMatch(name -> name.toLowerCase().contains(lowerTerm));
    }

    public boolean isProductDetailVisible() {
        return isDisplayed(productDetailSection);
    }

    public ProductPage setQuantity(int qty) {
        driver.findElement(quantityInput).clear();
        driver.findElement(quantityInput).sendKeys(String.valueOf(qty));
        return this;
    }

    public ProductPage clickAddToCart() {
        click(addToCartButton);
        return this;
    }

    public CartPage clickViewCart() {
        click(viewCartButton);
        return new CartPage(driver);
    }
}
