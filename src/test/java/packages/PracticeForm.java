package packages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import packages.components.CalendarComponent;


public class PracticeForm {

  private SelenideElement
      showPracticeForm = $x("//div[@class='element-list collapse show']"),
      firstNameInput = $("#firstName"),
      lastNameInput = $("#lastName"),
      userEmailInput = $("#userEmail"),
      genderWrapper = $("#genterWrapper"),
      userNumberInput = $("#userNumber"),
      calendarInput = $("#dateOfBirthInput"),
      hobbiesWrapper = $("#hobbiesWrapper"),
      currentAddress = $("#currentAddress"),
      submit = $("#submit");

  String[] checkResult = {"Student Name", "Student Email", "Gender", "Mobile", "Date of Birth",
      "Hobbies", "Address"};

  private CalendarComponent calendarComponent = new CalendarComponent();


  public PracticeForm ShowPracticeForm() {
    showPracticeForm.click();
    ;
    return this;
  }

  public PracticeForm setFirstName(String value) {
    firstNameInput.setValue(value);
    return this;
  }

  public PracticeForm setLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }

  public PracticeForm setEmail(String value) {
    userEmailInput.setValue(value);
    return this;

  }

  public PracticeForm setGender(String value) {
    genderWrapper.$(byText(value)).click();
    return this;
  }

  public PracticeForm setUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
  }

  public PracticeForm setDateBirth(String day, String month, String year) {
    $(calendarInput).click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public PracticeForm setHobbies(String value) {
    hobbiesWrapper.$(byText(value)).click();
    return this;
  }

  public PracticeForm setCurrentAddress(String value) {
    currentAddress.setValue(value);
    return this;
  }

  public PracticeForm сlickRegistration() {
    submit.submit();
    return this;
  }

  public PracticeForm checkResult(String firstName, String lastName, String email, String gender,
      String number, String day, String month, String year, String hobbies, String сurrentAddress) {
    $(".table-responsive").$(byText(checkResult[0])).parent()
        .shouldHave(text(firstName + " " + lastName));
    $(".table-responsive").$(byText(checkResult[1])).parent().shouldHave(text(email));
    $(".table-responsive").$(byText(checkResult[2])).parent().shouldHave(text(gender));
    $(".table-responsive").$(byText(checkResult[3])).parent().shouldHave(text(number));
    $(".table-responsive").$(byText(checkResult[4])).parent()
        .shouldHave(text(day + " " + month + "," + year));
    $(".table-responsive").$(byText(checkResult[5])).parent().shouldHave(text(hobbies));
    $(".table-responsive").$(byText(checkResult[6])).parent().shouldHave(text(сurrentAddress));
    return this;
  }
}
