package com.Mongo.MongoDemo.Repo;

import com.Mongo.MongoDemo.Model.Address;
import com.Mongo.MongoDemo.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmpRepo extends MongoRepository<Employee,Integer> {
    List<Employee>findByAddress(Address address);
}
