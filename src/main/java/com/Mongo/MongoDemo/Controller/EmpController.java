package com.Mongo.MongoDemo.Controller;

import com.Mongo.MongoDemo.Model.Address;
import com.Mongo.MongoDemo.Model.Employee;
import com.Mongo.MongoDemo.Repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpRepo empRepo;

    @PostMapping(value = "/insertEmp")
    String insertEmp(@RequestBody Employee employee){
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
    List<Employee>getAllEmp(@PathVariable String addr){
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


}
