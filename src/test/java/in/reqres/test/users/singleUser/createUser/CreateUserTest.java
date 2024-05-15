package in.reqres.test.users.singleUser.createUser;

import Utils.ApiUtils;
import in.reqres.model.request.create.UserCreate;
import in.reqres.model.responce.Create.UserResponse;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class CreateUserTest   {

    @Test
    public void createUserTest() {

        UserCreate userCreateRequest = new UserCreate();
        userCreateRequest.setName("morpheus");
        userCreateRequest.setJob("leader");

        UserResponse userResponse = given()
                .spec(ApiUtils.jsonRequestSpec())
                .body(userCreateRequest)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .extract().as(UserResponse.class);


        assertNotNull(userResponse.getId(), "ID should not be null");
        assertEquals(userResponse.getName(), "morpheus", "Name should be 'morpheus'");
        assertEquals(userResponse.getJob(), "leader", "Job should be 'leader'");
    }
}
