package RESTAPI.specs;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;

public class Authorizationspec {

  public static RequestSpecification getLoginRequestSpec = with()
      .filter(new AllureRestAssured())
      .log().uri()
      .log().body()
      .log().headers()
      .contentType("application/json")
      .baseUri("https://demoqa.com/")
      .basePath("Account/v1/Login");
  public static ResponseSpecification getLoginResponceSpec = new ResponseSpecBuilder()
      .expectStatusCode(200)
      .log(STATUS)
      .log(BODY)
      .build();
  public static RequestSpecification getTokenRequestSpec = with()
      .filter(new AllureRestAssured())
      .log().uri()
      .log().body()
      .log().headers()
      .contentType("application/json")
      .baseUri("https://demoqa.com/")
      .basePath("Account/v1/GenerateToken");
  public static ResponseSpecification getTokenResponceSpec = new ResponseSpecBuilder()
      .expectStatusCode(200)
      .log(STATUS)
      .log(BODY)
      .build();
}
