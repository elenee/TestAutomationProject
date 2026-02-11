package api;

import client.ProductSearch;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

@Epic("API Tests")
public class ProductSearchTest {

    private final ProductSearch productSearch = new ProductSearch();

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Description("Verify that searching a product with valid parameter returns status 200")
    @Test
    public void verifySearchProduct() {
        Allure.step("Search for product 'tshirt' and verify response", () -> {
            productSearch.searchProduct("tshirt")
                    .then()
                    .log().body()
                    .statusCode(200)
                    .body("responseCode", equalTo(200));
        });
    }

    @Description("Verify that searching a product without parameter returns proper error")
    @Test
    public void verifySearchProductWithoutParameter() {
        Allure.step("Send search request without parameters and verify 400 error", () -> {
            productSearch.searchProductWithoutParameter()
                    .then()
                    .log().body()
                    .statusCode(200)
                    .body("responseCode", equalTo(400))
                    .body("message", equalTo("Bad request, search_product parameter is missing in POST request."));
        });
    }
}
