package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
public class DownloadController {

  private final PhotosService photosService;

  public DownloadController(@Autowired PhotosService photosService) {
    this.photosService = photosService;
  }

  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> download(@PathVariable String id) {
    Photo photo = photosService.get(id);
    if (photo == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    byte[] data = new byte[0];
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(photo.getContentType()));

    ContentDisposition build = ContentDisposition
        .builder("attachment")
        .filename(photo.getFilename())
        .build();
    headers.setContentDisposition(build);

    return new ResponseEntity<>(data, headers, HttpStatus.OK);

  }
  
}
