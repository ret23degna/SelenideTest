package com.selenideTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SelenideTest {
 @BeforeEach
 void begin() {
       Configuration.browserSize = "1920х1080";
       Configuration.pageLoadTimeout = 120_000;
       open("https://demoqa.com");

     }
@Test
  void Card_Elements() throws InterruptedException{
   SelenideElement element = $(byTagAndText("h5","Elements"));
   actions().moveToElement(element).click(element).perform();
   $(byXpath("//div[@class='col-12 mt-4 col-md-6']")).shouldHave(text("Please select an item from left to start practice."));
  }
  @Test
  void demoqa_form() throws InterruptedException{
    SelenideElement element = $(byTagAndText("h5","Forms"));
    actions().moveToElement(element).click(element).perform();
    element = $(byXpath("//div[@class='element-list collapse show']"));
    actions().moveToElement(element).click(element).perform();
    $("#firstName").setValue("Вася");
    $("#lastName").setValue("Пупкин");
    $("#userEmail").setValue("qwe@qwe.qwe");
    $("#userNumber").setValue("9999999999");
    element = $(byXpath("//label[text()='Male']"));
    actions().moveToElement(element).click(element).perform();
    element = $(byXpath("//label[text()='Music']"));
    actions().moveToElement(element).click(element).perform();
    $("#currentAddress").setValue("kgn");
    $(byXpath("//button[text()='Submit']")).submit();
    $(byXpath("//div[@class='modal-title h4']")).shouldHave(text("Thanks for submitting the form"));
  }
  @Test
  void RegisterBooks() throws InterruptedException{
    SelenideElement element = $(byTagAndText("h5","Elements"));
    actions().moveToElement(element).click(element).perform();
    element = $(byXpath("//li[@class='btn btn-light ']"));
    actions().moveToElement(element).click(element).perform();
    $("#userName").setValue("Вася Пупкин");
    $("#userEmail").setValue("qwe@qwe.qwe");
    $("#currentAddress").setValue("qwe");
    $("#permanentAddress").setValue("ewq");
    element = $("#submit");
    actions().moveToElement(element).click(element).perform();
    $(byXpath("//p[@id='name']")).shouldHave(text("Вася Пупкин"));
    $(byXpath("//p[@id='email']")).shouldHave(text("qwe@qwe.qwe"));
    $(byXpath("//p[@id='currentAddress']")).shouldHave(text("qwe"));
    $(byXpath("//p[@id='permanentAddress']")).shouldHave(text("ewq"));
  }
}
