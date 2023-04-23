package org.example.API;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    private static final String USER_PATH = "auth/";

    @Step("Send POST request to /api/auth/register : {userRegister}")
    public  ValidatableResponse  register (Registration registration) {
        return given()
                .spec(baseSpec())
                .body(registration)
                .when()
                .post(USER_PATH + "register")
                .then()
                .log().ifError();
    }

    @Step("Send DELETE request to /api/auth/user : {userDelete}")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .header(  "Authorization", "Bearer " + accessToken)
                .spec(baseSpec())
                .when()
                .delete(USER_PATH+ "user")
                .then()
                .log().all();
    }
    @Step("Send DELETE request to /api/auth/user : {userDelete}")
    public ValidatableResponse deleteForLogin(String accessToken) {
        return given()
                .header(  "Authorization", "Bearer" + accessToken)
                .spec(baseSpec())
                .when()
                .delete(USER_PATH+ "user")
                .then()
                .log().all();
    }
}


