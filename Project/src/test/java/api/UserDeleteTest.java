package api;

import client.UserClient;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class UserDeleteTest {
    private final UserClient userClient = new UserClient();

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    public void verifyDeleteUserAccount() {
        String email = "tester@test.com";
        String password = "password123";

        userClient.deleteUserAccount(email, password)
                .then()
                .log().body()
                .statusCode(200)
                .body("responseCode", equalTo(404))
                .body("message", equalTo("Account not found!"));
    }
}