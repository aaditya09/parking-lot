package com.lld.parkinglot.model;


import com.lld.parkinglot.enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
public class Car extends Vehicle {

    public Car(String number, Type type) {
        super(number, type);
    }
}
