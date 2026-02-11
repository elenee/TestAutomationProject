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

    public Response verifyLogin(String email, String password) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .contentType(io.restassured.http.ContentType.URLENC)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/verifyLogin");
    }

    public Response verifyLoginWithoutEmail(String password) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .contentType(io.restassured.http.ContentType.URLENC)
                .formParam("password", password)
                .log().parameters()
                .when()
                .post("/verifyLogin");
    }
}