package com.lld.parkinglot.model;


import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    private String number;
    private Type type;
    private Space space;
    private Boolean isCharagesPaid;

    public Vehicle(){

    }

    public Vehicle(String number, Type type) {
        this.number = number;
        this.type = type;
    }

    public Vehicle(String number, Type type, Space space) {
        this.number = number;
        this.type = type;
        this.space = space;
    }

    public Vehicle(String number, Type type, Space space, Boolean isCharagesPaid) {
        this.number = number;
        this.type = type;
        this.space = space;
        this.isCharagesPaid = isCharagesPaid;
    }

    @Override
    public String toString(){
        return "Vehicle : " +  this.getNumber()+" " + this.getType();
    }
}
