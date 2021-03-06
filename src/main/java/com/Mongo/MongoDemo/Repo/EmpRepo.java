package com.Mongo.MongoDemo.Repo;

import com.Mongo.MongoDemo.Model.Address;
import com.Mongo.MongoDemo.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Set;

public interface EmpRepo extends MongoRepository<Employee,Integer> {

    @Query(value = "{addresses:{'$elemMatch':{'pin':?0}}}",fields = "{addresses.$:1}")
    Employee findByPin(Integer Pin);

    @Query(value = "{addresses:{'$elemMatch':{'city':?0}}}",fields = "{addresses.$:1}")
    Employee findByCity(String city);

}
