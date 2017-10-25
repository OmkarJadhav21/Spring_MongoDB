package com.Mongo.MongoDemo.Controller;

import com.Mongo.MongoDemo.Model.Address;
import com.Mongo.MongoDemo.Model.Employee;
import com.Mongo.MongoDemo.Repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EmpController {
    @Autowired
    EmpRepo empRepo;

    @PostMapping(value = "/insertEmp")
    String insertEmp(@RequestBody Employee employee){
        empRepo.save(employee);
        return "Data saved";
      }

    @PostMapping(value = "/insertEmpupdate")
    String insertEmpupdate(@RequestBody Employee employee){
        Integer empId=employee.getId();
        Employee empInfo=empRepo.findOne(empId);
//        Integer id=empInfo.getId();
                    if(empInfo!=null){
                        List<Address> addr=empInfo.getAddresses();
                            addr.addAll(employee.getAddresses());
                        employee.setAddresses(addr);
                        empRepo.save(employee);
                        return "sdfds";
                    }else{
                        empRepo.save(employee);
                        return "bbbbbbbb";
                    }

    }

    @GetMapping(value = "/getAllEmp")
    List<Employee>getAllEmp(){
        List<Employee>employeeList=empRepo.findAll();
        return employeeList;
    }

    @GetMapping(value = "/getEmpId")
    Employee getEmpId(@RequestParam Integer empId){
      Employee empOne=empRepo.findOne(empId);
      return empOne;
    }

    @PostMapping(value = "updtIdByparamAndBody")
    String updtIdbyparamAndBody(@RequestParam Integer id,@RequestBody Employee empl){
        Employee empInfo=empRepo.findOne(id);
        empInfo.setEmpName(empl.getEmpName());
        empRepo.save(empInfo);
        return "Employee name Updated";
    }

    @GetMapping(value = "/DeleteAllMongo")
    String DeleteAllMongo(){
        empRepo.deleteAll();
        return "All Data Deleted in mongo";
    }
    @GetMapping(value = "/DeleteOneMongo")
    String DeleteOneMongo(@RequestParam Integer id ){
        empRepo.delete(id);
        return "Data Deleted for Given ID";
    }

    @GetMapping(value = "/findAddrByPin")
    Employee findAddrByPin(@RequestParam Integer Pin){
        Employee raw=empRepo.findByPin(Pin);
        return raw;
    }

    @GetMapping(value = "/findAddrBycity")
    Employee findAddrBycity(@RequestParam String city){
        Employee emp=empRepo.findByCity(city);
        return emp;
    }


}
