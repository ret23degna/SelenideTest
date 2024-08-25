package RESTAPI;

import static RESTAPI.specs.Authorizationspec.getLoginRequestSpec;
import static RESTAPI.specs.Authorizationspec.getLoginResponceSpec;
import static RESTAPI.specs.Authorizationspec.getTokenRequestSpec;
import static RESTAPI.specs.Authorizationspec.getTokenResponceSpec;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import model.UserLoginPasswordModel;

public class AuthorizationRestApi {

  private UserLoginPasswordModel getLoginPassword() {
    UserLoginPasswordModel LoginPassword = new UserLoginPasswordModel();
    LoginPassword.setUserName("qqq");
    LoginPassword.setPassword("qqqWWW111!!!");
    return LoginPassword;
  }

  public Response getLoginResponse() {
    return given()
        .spec(getLoginRequestSpec)
        .body(getLoginPassword())
        .when()
        .post()
        .then()
        .spec(getLoginResponceSpec)
        .extract()
        .response();
  }

  public Response getTokenResponse() {
    return given()
        .spec(getTokenRequestSpec)
        .body(getLoginPassword())
        .when()
        .post()
        .then()
        .spec(getTokenResponceSpec)
        .extract()
        .response();
  }
}
