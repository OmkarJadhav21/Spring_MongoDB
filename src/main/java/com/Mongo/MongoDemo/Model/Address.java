package com.Mongo.MongoDemo.Model;

import org.springframework.data.annotation.Id;

public class Address  {
    @Id
    String streetName;
    String area;
    String city;
    Integer pin;

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", pin=" + pin +
                '}';
    }



    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

}
