package RESTAPI;

import static RESTAPI.specs.Bookspec.addBookRequestSpec;
import static RESTAPI.specs.Bookspec.addBookResponceSpec;
import static RESTAPI.specs.Bookspec.generationISBNRequestSpec;
import static RESTAPI.specs.Bookspec.generationISBNResponceSpec;
import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import model.BookRequestModel;
import model.IsbnModel;

public class BookRestApi {

  private static Faker faker = new Faker();

  public void addBook(Response user, String coockieValue, BookRequestModel regParams) {
    given()
        .spec(addBookRequestSpec)
        .auth().basic(user.path("username"), user.path("password"))
        .auth().oauth2(coockieValue)
        .body(regParams)
        .when()
        .post()
        .then()
        .spec(addBookResponceSpec);
  }

  public static List<IsbnModel> generationISBNBook() {
    int elemArrayBooks = faker.number().numberBetween(0, 7);
    Response responseAllIsbn = given()
        .spec(generationISBNRequestSpec)
        .when()
        .get()
        .then()
        .spec(generationISBNResponceSpec)
        .extract()
        .response();
    List<IsbnModel> isbnList = new ArrayList<>();
    IsbnModel isbn = new IsbnModel();
    isbn.setIsbn(responseAllIsbn.path("books[" + elemArrayBooks + "].isbn"));
    isbnList.add(isbn);
    return isbnList;
  }
}



