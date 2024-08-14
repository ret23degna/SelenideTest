package com.selenideTest;

import packages.PracticeForm;
import packages.MainMenu;
import org.junit.jupiter.api.Test;
import packages.TextBox;
import packages.utilss.RandomUtils;

public class SelenideTest {

  MainMenu mainMenu = new MainMenu();
  PracticeForm practiceForm = new PracticeForm();
  TextBox textBox = new TextBox();
  RandomUtils random = new RandomUtils();
  String firstName = random.firstName();
  String lastName = random.lastName();
  String email = random.emailAddress();
  String number = random.phoneNumber();
  String сurrentAddress = random.Address();
  String permanentAddress = random.Address();
  String gender = random.genderRandomer();
  String hobbies = random.hobbiesRandomer();
  String day = random.dayRandomer();
  String month = random.monthRandomer();
  String year = random.yearRandomer();

  @Test
  void CardElements() {
    mainMenu.openPage()
        .clickCard("Elements")
        .clickSuccessful("Please select an item from left to start practice.");
  }

  @Test
  void DemoqaForm() {

    mainMenu.openPage()
        .clickCard("Forms");
    practiceForm.ShowPracticeForm()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setEmail(email)
        .setGender(gender)
        .setUserNumber(number)
        .setDateBirth(day, month, year)
        .setHobbies(hobbies)
        .setCurrentAddress(сurrentAddress)
        .сlickRegistration()
        .checkResult(firstName, lastName, email, gender, number, day, month, year, hobbies,
            сurrentAddress);
  }

  @Test
  void RegisterBooks() {
    mainMenu.openPage()
        .clickCard("Elements");
    textBox.ClickTextBox()
        .setUserName(firstName)
        .setUserEmail(email)
        .setCurrentAddress(сurrentAddress)
        .setPermanentAddress(permanentAddress)
        .clickRegistrationTextBox()
        .checkResult(firstName, email, сurrentAddress, permanentAddress);

  }

}
