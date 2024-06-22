package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PhotoController {

  private List<Photo> db = List.of(
    new Photo("1", "photo1.jpg"), 
    new Photo("2", "photo2.jpg")
  );

  @GetMapping("/photos")
  public List<Photo> getPhotos() {
    return db;
  }

  @GetMapping("/photos/{id}")
  public Photo getPhoto(@PathVariable String id) {
    return db.stream()
      .filter(photo -> photo.getId().equals(id))
      .findFirst()
      .orElse(null);
  }
  

}
