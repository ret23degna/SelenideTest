package packages.utilss;

import com.github.javafaker.Faker;
import java.util.Random;

public class RandomUtils {

  Faker faker = new Faker();
  private String[] hobbies = {"Sports", "Reading", "Music"};
  private String[] genders = {"Male", "Female", "Other"};
  private String[] month = {"January", "February", "March", "April", "May", "June", "July",
      "August", "September", "October", "November", "December", "Hobbies"};

  public String firstName() {
    return faker.name().firstName();
  }

  public String lastName() {
    return faker.name().lastName();
  }

  public String emailAddress() {
    return faker.internet().emailAddress();
  }

  public String genderRandomer() {
    return getRandomerItemFromArray(genders);
  }

  public String phoneNumber() {
    return faker.phoneNumber().subscriberNumber(10);
  }

  public String dayRandomer() {
    return String.valueOf(faker.number().numberBetween(1, 28));
  }

  public String monthRandomer() {
    return getRandomerItemFromArray(month);
  }

  public String yearRandomer() {
    return String.valueOf(faker.number().numberBetween(1900, 2024));
  }

  public String hobbiesRandomer() {
    return getRandomerItemFromArray(hobbies);
  }

  public String Address() {
    return faker.address().streetAddress();
  }

  private static String getRandomerItemFromArray(String[] array) {
    Random random = new Random();
    int index = random.nextInt(array.length);
    return array[index];
  }
}
