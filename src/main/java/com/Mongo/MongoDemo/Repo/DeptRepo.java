package com.Mongo.MongoDemo.Repo;

import com.Mongo.MongoDemo.Model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeptRepo extends MongoRepository<Department,Integer>{
}
