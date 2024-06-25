package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "PHOTOS")
public class Photo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  // This annotation is used to validate that 
  @NotEmpty // the field is not null or empty
  private String filename;

  @Column(name = "content_type")
  private String contentType;

  // @JsonIgnore annotation is used to ignore the field
  // when serializing the object to JSON.
  @JsonIgnore
  @Lob
  @Column(name = "data")
  private byte[] data;

  public Photo() {
  }

  // Getters and setters

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
