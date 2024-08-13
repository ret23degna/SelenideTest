package packages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import org.aeonbits.owner.ConfigFactory;
import packages.config.TextBoxConfig;

public class TextBox {

  private SelenideElement
      clickTextBox = $x("//li[@class='btn btn-light ']"),
      userName = $("#userName"),
      userEmail = $("#userEmail"),
      currentAddress = $("#currentAddress"),
      permanentAddress = $("#permanentAddress"),
      submit = $("#submit"),
      finalUserName = $x("//p[@id='name']"),
      finaluserEmail = $x("//p[@id='email']"),
      finalcurrentAddress = $x("//p[@id='currentAddress']"),
      finalpermanentAddress = $x("//p[@id='permanentAddress']");
  private TextBoxConfig config = ConfigFactory.create(TextBoxConfig.class, System.getProperties());

  public TextBox ClickTextBox() {
    clickTextBox.click();
    return this;
  }

  public TextBox setUserName(String values) {
    userName.setValue(values);
    return this;
  }

  public TextBox setUserEmail(String values) {
    userEmail.setValue(values);
    return this;
  }

  public TextBox setCurrentAddress(String values) {
    currentAddress.setValue(values);
    return this;
  }

  public TextBox setPermanentAddress(String values) {
    permanentAddress.setValue(values);
    return this;
  }

  public TextBox clickRegistrationTextBox() {
    submit.click();
    return this;
  }

  public TextBox checkResult(String userName, String userEmail, String currentAddress,
      String permanentAddress) {
    finalUserName.shouldHave(text(userName));
    finaluserEmail.shouldHave(text(userEmail));
    finalcurrentAddress.shouldHave(text(currentAddress));
    finalpermanentAddress.shouldHave(text(permanentAddress));
    return this;
  }
}

