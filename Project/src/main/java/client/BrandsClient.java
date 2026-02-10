package client;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import utils.RequestSpecFactory;

public class BrandsClient {
    private static final String BASE_PATH = "/brandsList";

    public Response getAllBrands() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get(BASE_PATH);
    }
    public Response putAllBrands() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .put(BASE_PATH);
    }
}
