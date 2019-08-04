package com.lld.parkinglot.model;

import com.lld.parkinglot.enums.Type;
import lombok.Data;

@Data
public class Bike extends Vehicle{

    public Bike(String number, Type type) {
        super(number, type);
    }
}

