package client;
import io.restassured.response.Response;
import utils.RequestSpecFactory;
import static io.restassured.RestAssured.given;
public class ProductClient {
    public Response getAllProducts() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get("/productsList");
    }
    public Response postAllProducts() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .post("/productsList");
    }
}
