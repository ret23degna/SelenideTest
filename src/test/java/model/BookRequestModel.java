package model;

import lombok.Data;

import java.util.List;

@Data
public class BookRequestModel {
  String userId;
  List<IsbnModel> collectionOfIsbns;
}
