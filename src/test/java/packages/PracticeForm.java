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
      firstNameInput =  $("#firstName"),
      lastNameInput =  $("#lastName"),
      userEmailInput = $("#userEmail"),
      genderWrapper = $("#genterWrapper"),
      userNumberInput  = $("#userNumber"),
      calendarInput  = $("#dateOfBirthInput"),
      hobbiesWrapper = $("#hobbiesWrapper"),
      currentAddress  = $("#currentAddress"),
      submit  = $("#submit");
  private String tableResponsive[] = {
      "Student Name", "Student Email", "Gender", "Mobile", "Date of Birth", "Hobbies", "Address"
  };
  private CalendarComponent calendarComponent = new CalendarComponent();

  private PracticeFromConfig config = ConfigFactory.create(PracticeFromConfig.class, System.getProperties());

  public  PracticeForm  ShowPracticeForm() {
    showPracticeForm.click();;
    return this;
  }
  public  PracticeForm  setFirstName() {
    firstNameInput.setValue(config.getFirstName());
    return this;
  }
  public  PracticeForm  setLastName() {
    lastNameInput.setValue(config.getLastName());
    return this;
  }
  public  PracticeForm  setEmail() {
    userEmailInput.setValue(config.getEmail());
    return this;

  }
  public  PracticeForm  setGender() {
    genderWrapper.$(byText(config.getGender())).click();
    return this;
  }
  public  PracticeForm  setUserNumber() {
    userNumberInput.setValue(config.getUserNumber());
    return this;
  }
  public PracticeForm setDateBirth() {
    $(calendarInput).click();
    calendarComponent.setDate(config.getDateBirthDay(),config.getDateBirthMonth(),config.getDateBirthYear());
    return this;
  }

  public  PracticeForm  setHobbies() {
    hobbiesWrapper.$(byText(config.getHobbies())).click();
    return this;
  }
  public  PracticeForm  setCurrentAddress() {
    currentAddress.setValue(config.getCurrentAddress());
    return this;
  }
  public  PracticeForm  сlickRegistration() {
    submit.submit();
    return this;
  }
  public PracticeForm checkResult() {
    $(".table-responsive").$(byText(tableResponsive[0])).parent().shouldHave(text(config.getFirstName() + " "+ config.getLastName()));
    $(".table-responsive").$(byText(tableResponsive[1])).parent().shouldHave(text(config.getEmail()));
    $(".table-responsive").$(byText(tableResponsive[2])).parent().shouldHave(text(config.getGender()));
    $(".table-responsive").$(byText(tableResponsive[3])).parent().shouldHave(text(config.getUserNumber()));
    $(".table-responsive").$(byText(tableResponsive[4])).parent().shouldHave(text(config.getDateBirthDay() +" "+config.getDateBirthMonth()+","+config.getDateBirthYear()));
    $(".table-responsive").$(byText(tableResponsive[5])).parent().shouldHave(text(config.getHobbies()));
    $(".table-responsive").$(byText(tableResponsive[6])).parent().shouldHave(text(config.getCurrentAddress()));
    return this;
  }
}
