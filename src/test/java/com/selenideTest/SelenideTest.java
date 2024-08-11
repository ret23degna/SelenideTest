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
          .clickCardElements()
          .clickSuccessful();

  }
  @Test
  void DemoqaForm(){
    mainMenu.openPage()
            .clickCardForms();
    practiceForm.ShowPracticeForm()
        .setFirstName()
        .setLastName()
        .setEmail()
        .setGender()
        .setUserNumber()
        .setDateBirth()
        .setHobbies()
        .setCurrentAddress()
        .сlickRegistration()
        .checkResult();

  }
  @Test
  void RegisterBooks() {
    mainMenu.openPage()
            .clickCardElements();
    textBox.ClickTextBox()
            .setUserName()
            .setUserEmail()
            .setCurrentAddress()
            .setPermanentAddress()
            .clickRegistrationTextBox()
            .checkResult();

  }
}
