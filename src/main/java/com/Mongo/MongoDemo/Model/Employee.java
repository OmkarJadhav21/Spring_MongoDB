package com.Mongo.MongoDemo.Model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Employee {

    @Id
    Integer id;
    String empName;
    Integer empAge;
    List<Address>addresses;         //send data into this format {..add:[{stret: karve,city:pune..},{stret: karve2,city:pune2.}]}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", addresses=" + addresses +
                '}';
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }



    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }





}
