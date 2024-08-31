package packages;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


public class MainMenu extends BaseTest {

  private SelenideElement clickSuc = $x("//div[@class='col-12 mt-4 col-md-6']");
  private ElementsCollection cardsBody = $$x("//div[@class='card-body']");

  //Base();

  public MainMenu openPage() {
    Base();
    open("/");
    getWebDriver().manage().window().maximize();
    return this;
  }

  public MainMenu clickCard(String values) {
    cardsBody.findBy(matchText(values)).click();
    return this;
  }

  public MainMenu clickSuccessful(String values) {
    clickSuc.shouldHave(text(values));
    return this;
  }
}
