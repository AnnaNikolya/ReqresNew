import org.testng.annotations.Test;
import reqresPage.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresTest {

    @Test
    public void postCreateUserTest() {
        //https://reqres.in/api/users
        User user = User.builder()
                .name("morpheus")
                .job("leader")
                .build();
        given()
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void singleUserNotFound() {
        given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }

    @Test
    public void updateAtTest() {
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        given()
                .body(user)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateAtPatchTest() {
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        given()
                .body(user)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deleteTest() {
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        given()
                .body(user)
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }
    @Test
    public void registerSuccessfulTest() {
        User user = User.builder()
              .email("eve.holt@reqres.in")
              .password("pistol")
                .build();
        given()
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(200)
                .body("token", equalTo( "QpwL5tke4Pnpja7X4"));

    }
    
}