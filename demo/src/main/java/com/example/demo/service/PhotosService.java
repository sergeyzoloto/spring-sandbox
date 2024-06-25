package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Photo;
import com.example.demo.repository.PhotosRepository;

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

  private final PhotosRepository photosRepository;

  public PhotosService(PhotosRepository photosRepository) {
    this.photosRepository = photosRepository;
  }

  public Iterable<Photo> getAll() {
    return photosRepository.findAll();
  }

  public Photo get(Integer id) {
    return photosRepository.findById(id).orElse(null);
  }

  public void remove(Integer id) {
    photosRepository.deleteById(id); 
  }

  public Photo save(String filename, String contentType, byte[] data) {
    Photo photo = new Photo();
    photo.setContentType(contentType);
    photo.setFilename(filename);
    photo.setData(data);
    photosRepository.save(photo);
    return photo;
  }

}