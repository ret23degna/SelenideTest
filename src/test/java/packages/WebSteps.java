package packages;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebSteps {

  TextBox textBox = new TextBox();
  MainMenu mainMenu = new MainMenu();

  @Step("Открываем главную страницу")
  public void openMainPage() {
    mainMenu.openPage();
  }

  @Step("кликаем по Elements")
  public void clickCard(String Card) {
    mainMenu.clickCard(Card);
  }

  @Step("кликаем поссылке TextBo")
  public void ClickTextBox() {
    textBox.ClickTextBox();
  }

  @Step("вводим имя")
  public void setUserName(String FirstName) {
    textBox.setUserName(FirstName);
  }

  @Step("вводим Email")
  public void setUserEmail(String Email) {
    textBox.setUserEmail(Email);
  }

  @Step("вводим адрес")
  public void setCurrentAddress(String CurrentAddress) {
    textBox.setCurrentAddress(CurrentAddress);
  }

  @Step("вводим адрес еще какой-то")
  public void setPermanentAddress(String PermanentAddress) {
    textBox.setPermanentAddress(PermanentAddress);
  }

  @Step("кликаем кнопку проверки")
  public void clickRegistrationTextBox() {
    textBox.clickRegistrationTextBox();
  }

  @Step("проверка результатов")
  public void checkResult(String FirstName, String Email, String CurrentAddress,
      String PermanentAddress) {
    textBox.checkResult(FirstName, Email, CurrentAddress, PermanentAddress);
  }
}