package com.lld.parkinglot.exception;

/**
 * Created by Aaditya.t on 9/8/19.
 */
public class IllegalVehicleStateException  extends RuntimeException{
    public IllegalVehicleStateException(String message){
        super(message);
    }
}
