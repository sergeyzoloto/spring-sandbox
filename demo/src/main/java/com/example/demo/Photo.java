package com.example.demo;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

  private String id;
  
  // This annotation is used to validate that 
  @NotEmpty // the field is not null or empty
  private String filename;

  private byte[] data;

  public Photo() {
  }

  public Photo(String id, String filename) {
    this.id = id;
    this.filename = filename;
  }

  // raw data

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

  
}
