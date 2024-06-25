package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import java.util.UUID;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Photo;

// @Component annotation is used to indicate that the class is a Spring
// component. Spring will automatically detect this class and create an
// instance of it.

// @Service annotation is used to indicate that the class is a Spring service.
// Spring will automatically detect this class and create an instance of it.
// The difference between @Component and @Service is that @Service is used to
// indicate that the class is a service layer component, while @Component is
// used to indicate that the class is a general-purpose Spring component.

// @Component
@Service
public class PhotosService {

  private Map<String, Photo> db = new HashMap<>();
  
  public PhotosService() {
    db.put("1", new Photo("1", "photo1.jpg"));
    db.put("2", new Photo("2", "photo2.jpg"));
  }

  public Collection<Photo> getAll() {
    return db.values();
  }

  public Photo get(String id) {
    return db.get(id);
  }

  public Photo save(String filename, String contentType, byte[] data) {
    Photo photo = new Photo();
    photo.setContentType(contentType);
    photo.setId(UUID.randomUUID().toString());
    photo.setFilename(filename);
    photo.setData(data);
    db.put(photo.getId(), photo);
    return photo;
  }

  public Photo remove(String id) {
    return db.remove(id);
  }

  public boolean containsKey(String id) {
    return db.containsKey(id);
  }

}