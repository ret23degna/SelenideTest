package packages.config;

import org.aeonbits.owner.Config;

public interface MainMenuConfig extends Config {
  @Key("Forms")
  @DefaultValue("Forms")
  String getClickCardForms();

  @Key("Elements")
  @DefaultValue("Elements")
  String getClickCardElements();

  @Key("ClickSuccessful")
  @DefaultValue("Please select an item from left to start practice.")
  String getClickSuccessful();

  @Key("PageLoadStrategy")
  @DefaultValue("eager")
  String getPageLoadStrategy();
  @Key("BrowserSize")
  @DefaultValue("1920х1080")
  String getbrowserSize();
  @Key("Open")
  @DefaultValue("https://demoqa.com")
  String getOpen();
}
