package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.*;

@RestController
public class DownloadController {

  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> download(@PathVariable String id) {
    byte[] data = new byte[0];
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(data, headers, HttpStatus.OK);

  }
  
}
