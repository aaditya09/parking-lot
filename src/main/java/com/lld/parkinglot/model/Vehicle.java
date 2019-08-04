package com.lld.parkinglot.model;


import com.lld.parkinglot.enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    private String number;
    private Type type;

    public Vehicle(){

    }

    public Vehicle(String number, Type type) {
        this.number = number;
        this.type = type;
    }
}
