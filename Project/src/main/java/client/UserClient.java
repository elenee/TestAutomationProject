package client;

import io.restassured.response.Response;
import utils.RequestSpecFactory;
import static io.restassured.RestAssured.given;

public class UserClient {
    public Response getUserDetail(String email) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .queryParam("email", email)
                .when()
                .get("/getUserDetailByEmail");
    }
    public Response deleteUserAccount(String email, String password) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .contentType(io.restassured.http.ContentType.URLENC)
                .formParam("email", email)
                .formParam("password", password)
                .log().parameters()
                .when()
                .delete("/deleteAccount");
    }
}