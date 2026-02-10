package client;
import io.restassured.response.Response;
import utils.RequestSpecFactory;
import static io.restassured.RestAssured.given;
public class ProductSearch {
    public Response searchProduct(String productName) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .contentType("application/x-www-form-urlencoded")
                .formParam("search_product", productName)
                .when()
                .post("/searchProduct");
    }
    public Response searchProductWithoutParameter() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .contentType("application/x-www-form-urlencoded")
                .when()
                .post("/searchProduct");
    }
}
