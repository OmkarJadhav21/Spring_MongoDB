package com.Mongo.MongoDemo.Controller;

import com.Mongo.MongoDemo.Model.Student;
import com.Mongo.MongoDemo.Repo.StudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudControlr {
 @Autowired
    StudRepo studRepo;


 @PostMapping(value = "/insertMongo")
    String insertMongo(@RequestBody Student student){
        studRepo.save(student);
        return "Data insered into mongo";
    }

 @GetMapping(value = "/findOne")
    Student findOne(@RequestParam Integer id){
        Student st=studRepo.findOne(id);
        return st;
    }

 @GetMapping(value = "/findAll")
    List<Student>findAll(){

       List<Student>st1=studRepo.findAll();
       return st1;
 }

 @GetMapping(value = "/deletedata")
 String deletedata(@RequestParam Integer id){
     studRepo.delete(id);
     return "Data Deleted by Id";
 }

 @GetMapping(value = "/deleteAll")
     String deleteAll(){
     studRepo.deleteAll();
     return "All Data Deleted";
 }

 @PostMapping(value = "/useDbRef")
    String useDbRef(@RequestBody Student student){
    studRepo.save(student);
    return "values inserted only when dept id is first present in dept";
}

}
