package packages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import org.aeonbits.owner.ConfigFactory;
import packages.config.PracticeFromConfig;
import packages.config.TextBoxConfig;

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
  private TextBoxConfig config = ConfigFactory.create(TextBoxConfig.class, System.getProperties());
  public  TextBox  ClickTextBox() {
    clickTextBox.click();
    return this;
  }

  public  TextBox  setUserName() {
    userName.setValue(config.getUserName());
    return this;
  }
  public  TextBox  setUserEmail() {
    userEmail.setValue(config.getUserEmail());
    return this;
  }
  public  TextBox  setCurrentAddress() {
    currentAddress.setValue(config.getCurrentAddress());
    return this;
  }
  public  TextBox  setPermanentAddress() {
    permanentAddress.setValue(config.getPermanentAddress());
    return this;
  }
  public  TextBox  clickRegistrationTextBox() {
    submit.click();
    return this;
  }
  public TextBox checkResult( ) {
    finalUserName.shouldHave(text(config.getUserName()));
    finaluserEmail.shouldHave(text(config.getUserEmail()));
    finalcurrentAddress.shouldHave(text(config.getCurrentAddress()));
    finalpermanentAddress.shouldHave(text(config.getPermanentAddress()));
    return this;
  }
}

