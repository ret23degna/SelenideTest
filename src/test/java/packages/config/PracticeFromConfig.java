package packages.config;
import org.aeonbits.owner.Config;

public interface PracticeFromConfig extends Config {
  @Key("firstName")
  @DefaultValue("Вася")
  String getFirstName();

  @Key("lastName")
  @DefaultValue("Пупкин")
  String getLastName();

  @Key("Email")
  @DefaultValue("qwe@qwe.qwe")
  String getEmail();

  @Key("Gender")
  @DefaultValue("Male")
  String getGender();

  @Key("UserNumber")
  @DefaultValue("9999999999")
  String getUserNumber();

  @Key("DateBirthDay")
  @DefaultValue("8")
  String getDateBirthDay();

  @Key("DateBirthMonth")
  @DefaultValue("July")
  String getDateBirthMonth();

  @Key("DateBirthYear")
  @DefaultValue("2008")
  String getDateBirthYear();

  @Key("Hobbies")
  @DefaultValue("Music")
  String  getHobbies();

  @Key("CurrentAddress")
  @DefaultValue("kgn")
  String  getCurrentAddress();

}

