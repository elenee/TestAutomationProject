package client;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import config.ConfigManager;

public class UserClient {
    private final String baseUrl = ConfigManager.get("base.url");

    public Response getUserDetail(String email) {
        return given()
                .baseUri(baseUrl)
                .queryParam("email", email)
                .when()
                .get("/getUserDetailByEmail");
    }
}