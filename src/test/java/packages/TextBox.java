package packages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class TextBox {
  private SelenideElement
      clickTextBox = $x("//li[@class='btn btn-light ']"),
      userName =  $("#userName"),
      userEmail =  $("#userEmail"),
      currentAddress = $("#currentAddress"),
      permanentAddress = $("#permanentAddress"),
      submit  = $("#submit"),
      finalUserName =  $x("//p[@id='name']"),
      finaluserEmail =  $x("//p[@id='email']"),
      finalcurrentAddress = $x("//p[@id='currentAddress']"),
      finalpermanentAddress =  $x("//p[@id='permanentAddress']");
  public  TextBox  ClickTextBox() {
    clickTextBox.click();
    return this;
  }

  public  TextBox  setUserName(String value) {
    userName.setValue(value);
    return this;
  }
  public  TextBox  setUserEmail(String value) {
    userEmail.setValue(value);
    return this;
  }
  public  TextBox  setCurrentAddress(String value) {
    currentAddress.setValue(value);
    return this;
  }
  public  TextBox  setPermanentAddress(String value) {
    permanentAddress.setValue(value);
    return this;
  }
  public  TextBox  clickRegistrationTextBox() {
    submit.click();
    return this;
  }
  public TextBox checkResultUserName( String value) {
    finalUserName.shouldHave(text(value));
    return this;
  }
  public TextBox checkResultUserEmail( String value) {
    finaluserEmail.shouldHave(text(value));
    return this;
  }
  public TextBox checkResultCurrentAddress( String value) {
    finalcurrentAddress.shouldHave(text(value));
    return this;
  }
  public TextBox checkResultPermanentAddress( String value) {
    finalpermanentAddress.shouldHave(text(value));
    return this;
  }
}
