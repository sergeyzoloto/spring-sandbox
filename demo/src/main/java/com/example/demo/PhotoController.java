package com.example.demo;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;


@RestController
public class PhotoController {

  private Map<String, Photo> db = new HashMap<>();
  {
    db.put("1", new Photo("1", "photo1.jpg"));
    db.put("2", new Photo("2", "photo2.jpg"));
  }
  

  @GetMapping("/photos")
  public Collection<Photo> getPhotos() {
    return db.values();
  }

  @GetMapping("/photos/{id}")
  public Photo getPhoto(@PathVariable String id) {
    Photo photo = db.get(id);
    if (photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      "Photo not found with id " + id);
    }
    return photo;
  }

  @DeleteMapping("/photos/{id}")
  public void deletePhoto(@PathVariable String id) {
    Photo photo = db.remove(id);
    if (photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      "Photo not found with id " + id);
    }
  }

  @PostMapping("/photos")
  public Photo addPhoto(Photo photo) {
    photo.setId(UUID.randomUUID().toString());
    db.put(photo.getId(), photo);
    return photo;
  }

  @PutMapping("/photos/{id}")
  public Photo updatePhoto(@PathVariable String id, Photo photo) {
    if (!db.containsKey(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      "Photo not found with id " + id);
    }
    photo.setId(id);
    db.put(id, photo);
    return photo;
  }
  

}
