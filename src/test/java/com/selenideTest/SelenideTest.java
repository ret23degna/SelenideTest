package com.selenideTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SelenideTest {
 @BeforeEach
 void begin() {
       Configuration.pageLoadStrategy = "eager";
       Configuration.browserSize = "1920х1080";
       open("https://demoqa.com");

     }
@Test
  void Card_Elements() {
  $x("//div[@class='card-body']//h5[text()='Elements']").click();
  $x("//div[@class='col-12 mt-4 col-md-6']").shouldHave(text("Please select an item from left to start practice."));
  }
  @Test
  void demoqa_form(){
    $x("//div[@class='card-body']//h5[text()='Forms']").click();
    $x("//div[@class='element-list collapse show']").click();
    $("#firstName").setValue("Вася");
    $("#lastName").setValue("Пупкин");
    $("#userEmail").setValue("qwe@qwe.qwe");
    $("#userNumber").setValue("9999999999");
    $x("//label[text()='Male']").click();
    $x("//label[text()='Music']").click();
    $("#currentAddress").setValue("kgn");
    $("#submit").submit();
    $x("//div[@class='modal-title h4']").shouldHave(text("Thanks for submitting the form"));
  }
  @Test
  void RegisterBooks() {
    $x("//div[@class='card-body']//h5[text()='Elements']").click();
    $x("//li[@class='btn btn-light ']").click();
    $("#userName").setValue("Вася Пупкин");
    $("#userEmail").setValue("qwe@qwe.qwe");
    $("#currentAddress").setValue("qwe");
    $("#permanentAddress").setValue("ewq");
    $("#submit").click();
    $x("//p[@id='name']").shouldHave(text("Вася Пупкин"));
    $x("//p[@id='email']").shouldHave(text("qwe@qwe.qwe"));
    $x("//p[@id='currentAddress']").shouldHave(text("qwe"));
    $x("//p[@id='permanentAddress']").shouldHave(text("ewq"));
  }
}
