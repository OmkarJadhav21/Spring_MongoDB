package com.Mongo.MongoDemo.Controller;

import com.Mongo.MongoDemo.Model.Department;
import com.Mongo.MongoDemo.Repo.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptRepo deptRepo;
    @PostMapping(value = "/dbrefDept")
    String dbrefDept(@RequestBody Department department){
        deptRepo.save(department);
        return "Inserted into Dept";
    }
}
