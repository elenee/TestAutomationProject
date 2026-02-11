package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    private By viewProductButton = By.xpath("(//a[text()='View Product'])[1]");

    private By writeYourReviewTitle = By.xpath("//a[text()='Write Your Review']");

    private By reviewNameInput = By.id("name");
    private By reviewEmailInput = By.id("email");
    private By reviewTextArea = By.id("review");
    private By reviewSubmitButton = By.id("button-review");
    private By reviewSuccessMessage = By.xpath("//*[contains(text(),'Thank you for your review')]");
    private By brandsSidebar = By.className("brands_products");
    private By firstBrandLink = By.xpath("//div[@class='brands-name']//ul/li[1]/a");
    private By secondBrandLink = By.xpath("//div[@class='brands-name']//ul/li[2]/a");
    private By brandPageTitle = By.xpath("//h2[@class='title text-center']");

    public boolean isBrandsSidebarVisible() {
        return isDisplayed(brandsSidebar);
    }
    public String clickFirstBrand() {
        String brandName = driver.findElement(firstBrandLink).getText();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(firstBrandLink));
        return brandName;
    }
    public String clickSecondBrand() {
        String brandName = driver.findElement(secondBrandLink).getText();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(secondBrandLink));
        return brandName;
    }
    public String getBrandPageTitle() {
        return driver.findElement(brandPageTitle).getText();
    }

    public ProductPage clickViewProduct() {
        clickWithJS(viewProductButton);
        return this;
    }

    public boolean isWriteYourReviewVisible() {
        return isDisplayed(writeYourReviewTitle);
    }

    public ProductPage enterReviewDetails(String name, String email, String review) {
        type(reviewNameInput, name);
        type(reviewEmailInput, email);
        type(reviewTextArea, review);
        return this;
    }

    public ProductPage clickSubmitReview() {
        click(reviewSubmitButton);
        return this;
    }

    public boolean isReviewSuccessMessageVisible() {
        return isDisplayed(reviewSuccessMessage);
    }

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
