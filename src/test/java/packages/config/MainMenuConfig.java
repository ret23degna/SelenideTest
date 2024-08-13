package packages.config;

import org.aeonbits.owner.Config;

public interface MainMenuConfig extends Config {

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
