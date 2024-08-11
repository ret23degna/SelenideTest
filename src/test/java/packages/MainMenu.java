package packages;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.aeonbits.owner.ConfigFactory;
import packages.config.MainMenuConfig;
import packages.config.PracticeFromConfig;

public class MainMenu {
  private SelenideElement clickSuc = $x("//div[@class='col-12 mt-4 col-md-6']");
  private ElementsCollection cardsBody = $$x("//div[@class='card-body']");

  private MainMenuConfig config = ConfigFactory.create(MainMenuConfig.class, System.getProperties());
  public  MainMenu openPage() {
    Configuration.pageLoadStrategy = config.getPageLoadStrategy() ;
    Configuration.browserSize = config.getbrowserSize();
    open( config.getOpen());
    return this;
  }
  public  MainMenu  clickCardElements() {
    cardsBody.findBy(matchText(config.getClickCardElements())).click();;
    return this;
  }
  public  MainMenu  clickCardForms() {
    cardsBody.findBy(matchText(config.getClickCardForms())).click();;
    return this;
  }
  public  MainMenu  clickSuccessful () {
    clickSuc.shouldHave(text(config.getClickSuccessful()));
    return this;
  }
}
