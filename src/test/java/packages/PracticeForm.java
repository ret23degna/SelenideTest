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
      firstNameInput =  $("#firstName"),
      lastNameInput =  $("#lastName"),
      userEmailInput = $("#userEmail"),
      genderWrapper = $("#genterWrapper"),
      userNumberInput  = $("#userNumber"),
      calendarInput  = $("#dateOfBirthInput"),
      hobbiesWrapper = $("#hobbiesWrapper"),
      currentAddress  = $("#currentAddress"),
      submit  = $("#submit");


  CalendarComponent calendarComponent = new CalendarComponent();

  public  PracticeForm  ShowPracticeForm() {
    showPracticeForm.click();;
    return this;
  }
  public  PracticeForm  setFirstName(String value) {
    firstNameInput.setValue(value);
    return this;
  }
  public  PracticeForm  setLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }
  public  PracticeForm  setEmail(String value) {
    userEmailInput.setValue(value);
    return this;

  }
  public  PracticeForm  setGender(String value) {
    genderWrapper.$(byText(value)).click();
    return this;
  }
  public  PracticeForm  setUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
  }
  public PracticeForm setDateBirth(String day, String month, String year) {
    $(calendarInput).click();
    calendarComponent.setDate(day,month,year);
    return this;
  }

  public  PracticeForm  setHobbies(String value) {
    hobbiesWrapper.$(byText(value)).click();
    return this;
  }
  public  PracticeForm  setCurrentAddress(String value) {
    currentAddress.setValue(value);
    return this;
  }
  public  PracticeForm  сlickRegistration() {
    submit.submit();
    return this;
  }
  public PracticeForm checkResult(String key, String value) {
    $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    return this;
  }
}
