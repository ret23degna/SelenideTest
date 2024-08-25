package com.selenideTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

import RESTAPI.AuthorizationRestApi;
import RESTAPI.BookRestApi;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.response.Response;
import model.BookRequestModel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import packages.BaseTest;

public class APISelenideTest extends BaseTest {

  private String cookieTokenKey = "token";
  private String cookieExpiresKey = "expires";
  private String cookieUserIDKey = "userID";
  private AuthorizationRestApi authorizationApi = new AuthorizationRestApi();
  private BookRequestModel regParams = new BookRequestModel();
  private BookRestApi Book = new BookRestApi();

  @Test
  void deleteBooks() {
    Response responseUser = authorizationApi.getLoginResponse();
    String cookieUserIDValue = responseUser.path("userId");
    Response responseToken = authorizationApi.getTokenResponse();
    String cookieTokenValue = responseToken.path("token");
    String cookieExpiresValue = responseToken.path("expires");
    Cookie cookieToken = new Cookie(cookieTokenKey, cookieTokenValue);
    Cookie cookieExpires = new Cookie(cookieExpiresKey, cookieExpiresValue);
    Cookie cookieUserID = new Cookie(cookieUserIDKey, cookieUserIDValue);
    regParams.setUserId(cookieUserIDValue);
    regParams.setCollectionOfIsbns(BookRestApi.generationISBNBook());
    Book.addBook(responseUser, cookieTokenValue, regParams);
    open("/images/Toolsqa.jpg");
    getWebDriver().manage().addCookie(cookieToken);
    getWebDriver().manage().addCookie(cookieExpires);
    getWebDriver().manage().addCookie(cookieUserID);
    getWebDriver().navigate().refresh();
    SelenideLogger.addListener("allure", new AllureSelenide());
    step("Открываем demoqa", () -> {
      open("/profile");
    });
    step("Удаляем книгу", () -> {
      $("#delete-record-undefined").click();
      $("#closeSmallModal-ok").click();
      confirm();
    });
    step("Проверяем Результат", () ->
        $(".rt-noData").shouldHave(text("No rows found")));
  }
}
