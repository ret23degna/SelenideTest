package packages;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class MainMenu {
  private SelenideElement clickSuc = $x("//div[@class='col-12 mt-4 col-md-6']");
  private ElementsCollection cardsBody = $$x("//div[@class='card-body']");
  public  MainMenu openPage() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize = "1920х1080";
    open("https://demoqa.com");
    return this;
  }
  public  MainMenu  clickCard(String value) {
    cardsBody.findBy(matchText(value)).click();;
    return this;
  }
  public  MainMenu  clickSuccessful (String value) {
    clickSuc.shouldHave(text(value));
    return this;
  }
}
