package in.reqres.test.registration;

import Utils.ApiUtils;
import in.reqres.model.request.RegistrationRequest;
import in.reqres.test.ApiTestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegistrationTests extends ApiTestBase {
    @Test
    public void testSuccessfulRegistration() {
        RegistrationRequest registrationRequest = new RegistrationRequest("eve.holt@reqres.in", "pistol");
        given()
                .spec(ApiUtils.jsonRequestSpec())
                .body(registrationRequest)
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue());


    }

    @Test
    public void testUnsuccessfulRegistration() {
        RegistrationRequest registrationRequest = new RegistrationRequest("ka@abv.bg", "");

        given()
                .spec(ApiUtils.jsonRequestSpec())
                .body(registrationRequest)
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

}