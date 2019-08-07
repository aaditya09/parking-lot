package com.lld.parkinglot.exception;

/**
 * Created by Aaditya.t on 7/8/19.
 */
public class VehicleNotFoundException  extends ObjectNotFoundException{
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
