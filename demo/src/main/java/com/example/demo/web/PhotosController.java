package com.example.demo.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Photo;
import com.example.demo.service.PhotosService;

import java.io.IOException;
import java.util.Collection;


@RestController
public class PhotosController {

  private final PhotosService photosService;

  public PhotosController(@Autowired PhotosService photosService) {
    this.photosService = photosService;
  }
  
  private static final String PHOTO_NOT_FOUND_MSG = "Photo not found with id ";

  @GetMapping("/photos")
  public Collection<Photo> getPhotos() {
    return photosService.getAll();
  }

  @GetMapping("/photos/{id}")
  public Photo getOne(@PathVariable String id) {

    Photo photo = photosService.get(id);

    if (photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      PHOTO_NOT_FOUND_MSG + id);
    }

    return photo;
  }

  @DeleteMapping("/photos/{id}")
  public void deleteOne(@PathVariable String id) {

    Photo photo = photosService.remove(id);

    if (photo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      PHOTO_NOT_FOUND_MSG + id);
    }
  }

  // @Valid is used to validate the request body and @RequestBody
  // is used to bind the request body to the method parameter.
  // @RequestPart is used to bind the request part to the method parameter.
  // MultipartFile is used to represent a file part in a multipart request.
  // The method returns the created photo object.
  @PostMapping("/photos")
  public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
    return photosService.save(
      file.getOriginalFilename(), 
      file.getContentType(), 
      file.getBytes()
    );
  }

  // @PutMapping("/photos/{id}")
  // public Photo updateOne(@PathVariable String id, Photo photo) {
  //   if (!photosService.containsKey(id)) {
  //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
  //     PHOTO_NOT_FOUND_MSG + id);
  //   }
  //   photo.setId(id);
  //   photosService.save(photo.getFilename(), photo.getData());
  //   return photo;
  // }
  

}
