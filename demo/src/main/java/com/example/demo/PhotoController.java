package com.example.demo;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
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
  public Photo getOne(@PathVariable String id) {
    Photo photo = db.get(id);
    if (photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      "Photo not found with id " + id);
    }
    return photo;
  }

  @DeleteMapping("/photos/{id}")
  public void deleteOne(@PathVariable String id) {
    Photo photo = db.remove(id);
    if (photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      "Photo not found with id " + id);
    }
  }

  // @Valid is used to validate the request body and @RequestBody
  // is used to bind the request body to the method parameter.
  // @RequestPart is used to bind the request part to the method parameter.
  // MultipartFile is used to represent a file part in a multipart request.
  // The method returns the created photo object.
  @PostMapping("/photos")
  public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
    Photo photo = new Photo();
    photo.setId(UUID.randomUUID().toString());
    photo.setFilename(file.getOriginalFilename());
    photo.setData(file.getBytes());
    db.put(photo.getId(), photo);
    return photo;
  }

  @PutMapping("/photos/{id}")
  public Photo updateOne(@PathVariable String id, Photo photo) {
    if (!db.containsKey(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      "Photo not found with id " + id);
    }
    photo.setId(id);
    db.put(id, photo);
    return photo;
  }
  

}
