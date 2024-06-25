package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

  private String id;
  
  // This annotation is used to validate that 
  @NotEmpty // the field is not null or empty
  private String filename;

  private String contentType;

  // @JsonIgnore annotation is used to ignore the field
  // when serializing the object to JSON.
  @JsonIgnore
  private byte[] data;

  public Photo() {
  }

  public Photo(String id, String filename) {
    this.id = id;
    this.filename = filename;
  }

  // Getters and setters

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  
}
