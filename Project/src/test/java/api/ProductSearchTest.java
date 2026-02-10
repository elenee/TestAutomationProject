package api;
import client.ProductSearch;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class ProductSearchTest {
    private final ProductSearch productSearch = new ProductSearch();

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    public void verifySearchProduct() {
        productSearch.searchProduct("tshirt")
                .then()
                .log().body()
                .statusCode(200)
                .body("responseCode", equalTo(200));
    }

    @Test
    public void verifySearchProductWithoutParameter() {
        productSearch.searchProductWithoutParameter()
                .then()
                .log().body()
                .statusCode(200)
                .body("responseCode", equalTo(400))
                .body("message", equalTo("Bad request, search_product parameter is missing in POST request."));
    }
}
