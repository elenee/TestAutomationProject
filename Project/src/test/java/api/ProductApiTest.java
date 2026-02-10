package api;
import client.ProductClient;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class ProductApiTest {
    private final ProductClient productClient = new ProductClient();

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    public void verifyGetAllProductsList() {
        productClient.getAllProducts()
                .then()
                .log().body()
                .statusCode(200);
    }
    @Test
    public void verifyPostAllProductsNotAllowed() {
        productClient.postAllProducts()
                .then()
                .log().body()
                .statusCode(200)
                .body("responseCode", equalTo(405))
                .body("message", equalTo("This request method is not supported."));
    }

}
