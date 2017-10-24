package com.Mongo.MongoDemo.Repo;

import com.Mongo.MongoDemo.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudRepo extends MongoRepository<Student,Integer>{
}
