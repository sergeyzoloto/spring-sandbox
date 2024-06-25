package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Photo;

public interface PhotosRepository extends CrudRepository<Photo, Integer>{
  
}
