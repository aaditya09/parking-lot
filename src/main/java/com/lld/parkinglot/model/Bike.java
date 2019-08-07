package com.lld.parkinglot.model;

import com.lld.parkinglot.enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class Bike extends Vehicle{

    public Bike(String number, Type type) {
        super(number, type);
    }

    @Override
    public String toString(){
        return "Bike : " +  this.getNumber()+" " + this.getType();
    }
}

