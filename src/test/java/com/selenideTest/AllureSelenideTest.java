package com.selenideTest;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import packages.MainMenu;
import packages.PracticeForm;
import packages.WebSteps;
import packages.utilss.RandomUtils;

public class AllureSelenideTest {

  MainMenu mainMenu = new MainMenu();
  PracticeForm practiceForm = new PracticeForm();
  RandomUtils random = new RandomUtils();
  String firstName = random.firstName();
  String lastName = random.lastName();
  String email = random.emailAddress();
  String number = random.phoneNumber();
  String currentAddress = random.Address();
  String permanentAddress = random.Address();
  String gender = random.genderRandomer();
  String hobbies = random.hobbiesRandomer();
  String day = random.dayRandomer();
  String month = random.monthRandomer();
  String year = random.yearRandomer();

  @Test
  void CardElements() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    mainMenu.openPage()
        .clickCard("Elements")
        .clickSuccessful("Please select an item from left to start practice.");
  }

  @Test
  void DemoqaForm() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    step("Открываем главную страницу", () -> {
      mainMenu.openPage();
    });
    step("кликаем по блоку Forms", () -> {
      mainMenu.clickCard("Forms");
    });
    step("Открываем PracticeForm", () -> {
      practiceForm.ShowPracticeForm();
    });
    step("Вводим имя", () -> {
      practiceForm.setFirstName(firstName);
    });
    step("Вводим фамилию", () -> {
      practiceForm.setLastName(lastName);
    });
    step("Вводим Email", () -> {
      practiceForm.setEmail(email);
    });
    step("Выбраем пол", () -> {
      practiceForm.setGender(gender);
    });
    step("Вводим номер", () -> {
      practiceForm.setUserNumber(number);
    });
    step("Вводим дату рождения", () -> {
      practiceForm.setDateBirth(day, month, year);
    });
    step("Выбираем хобби", () -> {
      practiceForm.setHobbies(hobbies);
    });
    step("Вводим адрес", () -> {
      practiceForm.setCurrentAddress(currentAddress);
    });
    step("клик по кнопке регитсрации", () -> {
      practiceForm.сlickRegistration();
    });
    step("Проверяем результат", () -> {
      practiceForm.checkResult(firstName, lastName, email, gender, number, day, month, year,
          hobbies, currentAddress);
    });


  }

  @Test
  void RegisterBooks() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();
    steps.openMainPage();
    steps.clickCard("Elements");
    steps.ClickTextBox();
    steps.setUserName(firstName);
    steps.setUserEmail(email);
    steps.setCurrentAddress(currentAddress);
    steps.setPermanentAddress(permanentAddress);
    steps.clickRegistrationTextBox();
    steps.checkResult(firstName, email, currentAddress, permanentAddress);

  }

}
