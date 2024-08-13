package packages;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

import org.junit.jupiter.api.BeforeEach;
import packages.config.MainMenuConfig;

public class BaseTest {
  MainMenuConfig config = ConfigFactory.create(MainMenuConfig.class,
      System.getProperties());

 @BeforeEach
void Base() {
   Configuration.pageLoadStrategy = config.getPageLoadStrategy();
   Configuration.browserSize = config.getbrowserSize();
   Configuration.baseUrl = config.getOpen();
 }


}
