package com.selenideTest;

import packages.PracticeForm;
import packages.MainMenu;
import org.junit.jupiter.api.Test;
import packages.TextBox;

public class SelenideTest {
  MainMenu mainMenu = new MainMenu();
  PracticeForm practiceForm = new PracticeForm();
  TextBox textBox = new TextBox();
@Test
  void CardElements() {
  mainMenu.openPage()
          .clickCard("Elements")
          .clickSuccessful( "Please select an item from left to start practice.");

  }
  @Test
  void DemoqaForm(){
    mainMenu.openPage()
            .clickCard("Forms");
    practiceForm.ShowPracticeForm()
        .setFirstName("Вася")
        .setLastName("Пупкин")
        .setEmail("qwe@qwe.qwe")
        .setGender("Male")
        .setUserNumber("9999999999")
        .setDateBirth("31","July","2008")
        .setHobbies("Music")
        .setCurrentAddress("kgn")
        .сlickRegistration()
        .checkResult("Student Name", "Вася Пупкин")
        .checkResult("Student Email", "qwe@qwe.qwe")
        .checkResult("Gender", "Male")
        .checkResult("Mobile", "9999999999")
        .checkResult("Date of Birth", "31 July,2008")
        .checkResult("Hobbies", "Music")
        .checkResult("Address", "kgn");
  }
  @Test
  void RegisterBooks() {
    mainMenu.openPage()
            .clickCard("Elements");
    textBox.ClickTextBox()
            .setUserName("Вася Пупкин")
            .setUserEmail("qwe@qwe.qwe")
            .setCurrentAddress("qwe")
            .setPermanentAddress("ewq")
            .clickRegistrationTextBox()
            .checkResultUserName("Вася Пупкин")
            .checkResultUserEmail("qwe@qwe.qwe")
            .checkResultCurrentAddress("qwe")
            .checkResultPermanentAddress("ewq");
  }
}
