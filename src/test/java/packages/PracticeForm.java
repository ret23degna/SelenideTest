package packages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import org.aeonbits.owner.ConfigFactory;
import packages.components.CalendarComponent;
import packages.config.PracticeFromConfig;

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

  private CalendarComponent calendarComponent = new CalendarComponent();

  private PracticeFromConfig config = ConfigFactory.create(PracticeFromConfig.class,
      System.getProperties());

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

  public PracticeForm checkResult(String value1, String value2) {
    $(".table-responsive").$(byText(value1)).parent().shouldHave(text(value2));
    return this;
  }
}
