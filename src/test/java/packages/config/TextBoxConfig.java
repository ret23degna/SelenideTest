package packages.config;

import org.aeonbits.owner.Config;

public interface TextBoxConfig extends Config {
  @Key("UserName")
  @DefaultValue("Вася Пупкин")
  String getUserName();
  @Key("UserEmail")
  @DefaultValue("qwe@qwe.qwe")
  String getUserEmail();
  @Key("CurrentAddress")
  @DefaultValue("qwe")
  String getCurrentAddress();
  @Key("PermanentAddress")
  @DefaultValue("ewq")
  String getPermanentAddress();
}
